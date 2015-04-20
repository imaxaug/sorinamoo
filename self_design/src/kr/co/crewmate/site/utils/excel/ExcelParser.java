package kr.co.crewmate.site.utils.excel;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * 클래스명: <code>ExcelParser</code>
 *
 * <pre>
 *  엑셀로 데이터 등록 하기 위한 클래스
 * </pre>
 *
 * @author newstar000
 * @date 2011. 11. 29.
 *
 * @param <E>
 */
public abstract class ExcelParser<E> {

    Log log = LogFactory.getLog(this.getClass());
    
    private final static String METHOD_PREFIX_SET = "set";
    
    /**
     * 헤더 목록
     */
    private final List<String> headerList;
    
    /**
     * 메소드 목록(헤더에 set붙은 메소드)
     */
    private List<String> methodNamesList;
    
    /**
     * 업로드된 엑셀 파일
     */
    private MultipartFile excelFile;
    
    /**
     * 헤더가 시작되는 row
     */
    private final int headerStartRow;
    
    /**
     * 데이터 시작되는 row
     */
    private final int dataStartRow;
    
    /**
     * 최대 입력 가능 값
     */
    private final int maxInsertCount;
    
    public abstract Method[] getMethods();
    
    public abstract E getNewObject();
    
    /**
     * construct
     * @param headerList
     * @param headerStartRow
     * @param dataStartRow
     * @param maxInsertCount
     */
    public ExcelParser(List<String> headerList, int headerStartRow, int dataStartRow, int maxInsertCount) {
        this.headerList = headerList;
        this.headerStartRow = headerStartRow;
        this.dataStartRow = dataStartRow;
        this.maxInsertCount = maxInsertCount;
        this.setMethodNamesList();
    }
    
    /**
     * 엑셀의 데이터를 해당 객체의 List 형태로 반환 해줌
     * @return
     */
    public List<E> getDataList() {
        List<E> list = new ArrayList<E>();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(this.excelFile.getInputStream()));
            HSSFSheet sheet = workbook.getSheetAt(0);
            
            for (int rowIndex = this.getDataStartRow() ; rowIndex < sheet.getPhysicalNumberOfRows() ; rowIndex++) {
                HSSFRow row = sheet.getRow(rowIndex);
                E e = getNewObject();
                
                for (int cellIndex = 0; cellIndex < this.getHeaderList().size(); cellIndex++) {
                    String headerName = this.getMethodNamesList().get(cellIndex);
                    for (Method method : getMethods()) {
                        if(StringUtils.equals(headerName, method.getName())) {
                            String value = getCellValue(row.getCell(cellIndex));
                            setData(e, method, value);
                        }
                    }
                }
                
                list.add(e);
            }
        } catch (IOException e) {
            new RuntimeException(e);
        }
        
        return list;
    }
    
    public void setData(E e, Method method, String value) {
        Class<?> parameterTypes[] = method.getParameterTypes();
        String parameterType =  parameterTypes[0].getSimpleName();
        
        try {
            if (parameterType.equals("int")) {
                if(StringUtils.isNumeric(value)) {
                    method.invoke(e, Integer.parseInt(value));
                } else {
                    method.invoke(e, 0);
                }
            } else if (parameterType.equals("boolean")) {
                if (StringUtils.equals(value, "Y")) {
                    method.invoke(e, Boolean.TRUE);
                } else {
                    method.invoke(e, Boolean.FALSE);
                }
            } else {
                method.invoke(e, value);
            }
        } catch (Exception exception) {
            new RuntimeException(exception);
        }
    }
    
    /**
     * 파싱 가능한지 확인
     * @return
     */
    public boolean isValidExcelFile() {
        try {
            if (!org.springframework.util.StringUtils.endsWithIgnoreCase(this.excelFile.getOriginalFilename(), "xls")) {
                log.debug("파일명 이상");
                return false;
            }
            
            if(!this.isFormalExcelForm()) {
                log.debug("엑셀파일이 아님");
                return false;
            }
            
            if(!this.isInMaxInsertCount()) {
                log.debug("등록 가능한 개수 아님");
                return false;
            }
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 엑셀파일 여부 확인
     * @param dataStartRow
     * @return
     */
    private boolean isFormalExcelForm() {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(this.excelFile.getInputStream()));
            HSSFSheet sheet = workbook.getSheetAt(0);
            HSSFRow row = sheet.getRow(this.getHeaderStartRow());
            
            if (this.getHeaderList().size() != row.getLastCellNum()) {
                throw new Exception();
            }
            
            int index = 0;
            Iterator<?> it = row.cellIterator();
            while(it.hasNext()) {
                if (!StringUtils.equals(it.next().toString(), this.getHeaderList().get(index++))) {
                    throw new Exception();
                }
            }

        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    /**
     * 등록 가능한 개수인지 체크
     * 
     * @return
     */
    private boolean isInMaxInsertCount() {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(this.excelFile.getInputStream()));
            HSSFSheet sheet = workbook.getSheetAt(0);
            
            if ((sheet.getPhysicalNumberOfRows() - dataStartRow) > maxInsertCount) {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    /**
     * 엑셀 cell값 가져오기
     * 
     * @param cell
     * @return
     */
    private String getCellValue(HSSFCell cell) {
        String value = "";

        if(cell != null) {
            switch(cell.getCellType()) {
                case HSSFCell.CELL_TYPE_FORMULA:
                    value = cell.getCellFormula();
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    value = "" + cell.getNumericCellValue();
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    value = "" + cell.getBooleanCellValue();
                    break;
                default: 
                    break;
            }
        }
        
        return value;
    }

    public List<String> getHeaderList() {
        return headerList;
    }

    public MultipartFile getExcelFile() {
        return excelFile;
    }

    public void setExcelFile(MultipartFile excelFile) {
        this.excelFile = excelFile;
    }

    public int getDataStartRow() {
        return dataStartRow;
    }
    
    private void setMethodNamesList() {
        List<String> methodNamesList = new ArrayList<String>();
        
        for (String header : this.getHeaderList()) {
            String setterName = METHOD_PREFIX_SET + Character.toUpperCase(header.charAt(0)) + header.substring(1);
            methodNamesList.add(setterName);
        }
        
        this.methodNamesList = methodNamesList;
    }
    
    public List<String> getMethodNamesList() {
        return this.methodNamesList;
    }

    public int getMaxInsertCount() {
        return maxInsertCount;
    }

    public int getHeaderStartRow() {
        return headerStartRow;
    }
}
