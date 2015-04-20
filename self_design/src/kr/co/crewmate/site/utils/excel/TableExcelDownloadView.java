package kr.co.crewmate.site.utils.excel;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.crewmate.site.model.GubunTagNote;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.common.ExcelHeader;
import kr.co.crewmate.site.model.common.ExcelResource;
import kr.co.crewmate.site.utils.SiteUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.ibatis.common.logging.Log;
import com.ibatis.common.logging.LogFactory;
/**
 * 
 * 클래스명: <code>TableExcelDownloadView</code>
 *
 * <pre>
 *  테이블의 모든 목록을 엑셀로 다운로드한다.
 * </pre>
 *
 * @author 남세건
 * @date 2013. 05. 21.
 *
 * @param <E>
 */
public class TableExcelDownloadView<E> extends AbstractExcelView {
    
    Log log = LogFactory.getLog(this.getClass());
    
    private final ExcelResource<E> excelResource;
    
    private String fileName;
    
    private final static String METHOD_PREFIX_GET = "get";
    
    private final static String METHOD_PREFIX_IS = "is";
    
    private final static String BOOLEAN_TYPE = "BOOLEAN";
    
    public TableExcelDownloadView(ExcelResource<E> excelResource) {
        this.excelResource = excelResource;
    }
    
    public TableExcelDownloadView(ExcelResource<E> excelResource, String fileName) {
        this.excelResource = excelResource;
        this.fileName = fileName;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<E> list = excelResource.getList();
        List<ExcelHeader> headerList = excelResource.getHeaders();
        
        HSSFSheet sheet = workbook.createSheet();

        sheet.setDefaultColumnWidth(20);
        sheet.setDisplayGridlines(true);

        HSSFCellStyle headerStyle = workbook.createCellStyle(); // 해드 객체 생성
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        headerStyle.setFillBackgroundColor(HSSFColor.BLACK.index);
        headerStyle.setFillForegroundColor(HSSFColor.BLACK.index);
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        
        HSSFCellStyle tableNameStyle = workbook.createCellStyle(); // tableName 객체 생성
        
        tableNameStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
        tableNameStyle.setFillForegroundColor(HSSFColor.BLUE.index);
        tableNameStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        
        HSSFFont font = workbook.createFont(); //폰트 객체 생성
        font.setColor(workbook.getCustomPalette().findSimilarColor((byte) 0xff, (byte) 0xff, (byte) 0xff).getIndex());
        headerStyle.setFont(font);
        tableNameStyle.setFont(font);

        HSSFCellStyle cellStyle = workbook.createCellStyle(); // 기본 셀 객체 생성
        cellStyle.setBorderTop((short) 1);
        cellStyle.setBorderBottom((short) 1);
        cellStyle.setBorderLeft((short) 1);
        cellStyle.setBorderRight((short) 1);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        HSSFCellStyle noBorderStyle = workbook.createCellStyle(); // 테두리 없는 셀 객체 생성
        
        HSSFCellStyle leftCellStyle = workbook.createCellStyle(); // 왼쪽 정렬 셀 객체 생성
        leftCellStyle.setBorderTop((short) 1);
        leftCellStyle.setBorderBottom((short) 1);
        leftCellStyle.setBorderLeft((short) 1);
        leftCellStyle.setBorderRight((short) 1);
        leftCellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        
        int headerNum = 0;
        HSSFRow header = sheet.createRow(0);
        for (ExcelHeader excelHeader : headerList) {
            headerNum = createHeader(headerStyle, headerNum, header, excelHeader.getDisplayName());
        }

        int rowNum = 1;
        for (int i = 0; i < list.size(); i++) {
            HSSFRow row = sheet.createRow(rowNum++);
            HSSFCellStyle inputStyle = cellStyle;
            boolean noborderLine = false;
            if ((i+1) < list.size()) {
                Method[] afterMethods = list.get(i+1).getClass().getMethods();
                
                for (Method afterMethod : afterMethods) {
                    if (StringUtils.equals(afterMethod.getName(), "getKoreanName")) {
                        Object afterCellValue = afterMethod.invoke(list.get(i+1));
                        if (afterCellValue != null && afterCellValue instanceof String) {
                            String afterReturnValue = (String)afterCellValue;
                            if (afterReturnValue.startsWith("T_")) {
                                noborderLine = true;
                                inputStyle = noBorderStyle;
                            }
                        }
                    }
                }
            }

            int cellNum = 0;
            for (ExcelHeader excelHeader : headerList) {
                String methodName = this.setMethodNamesList(excelHeader.getHeader());
                Method[] methods = list.get(i).getClass().getMethods();
                
                for (Method method : methods) {
                    String realMethodName = checkBoolAndReplaceMethodName(method);
                    
                    if (StringUtils.equals(methodName, realMethodName)) {
                        Object cellValue = method.invoke(list.get(i));
                        
                        if (StringUtils.equals(method.getName(), "getKoreanName") || StringUtils.equals(method.getName(), "getColumnName")) {
                                if (noborderLine) {
                                    createRow(cellNum++, row, cellValue, inputStyle, excelHeader.getGubunKey());
                                } else {
                                    if (cellValue != null && cellValue instanceof String) {
                                        String returnValue = (String)cellValue;
                                        if (returnValue.startsWith("T_")) {
                                            inputStyle = tableNameStyle;
                                            sheet.addMergedRegion(new CellRangeAddress(rowNum - 1, rowNum - 1, 0, 2));
                                            createRow(cellNum++, row, cellValue, inputStyle, excelHeader.getGubunKey());
                                            noborderLine = true;
                                            inputStyle = noBorderStyle;
                                        } else {
                                            createRow(cellNum++, row, cellValue, leftCellStyle, excelHeader.getGubunKey());
                                        }
                                    } else {
                                        createRow(cellNum++, row, cellValue, leftCellStyle, excelHeader.getGubunKey());
                                    }
                                } 
                        } else {
                            createRow(cellNum++, row, cellValue, inputStyle, excelHeader.getGubunKey());
                        }
                        break;
                    }
                }
            }
        }
        
        if (StringUtils.isNotEmpty(fileName)) {
            SiteUtils.setResponseHeader(response, fileName);
        }
    }
    
    /**
     * header를 생성한다.
     * @param style
     * @param headerNum
     * @param header
     * @param headerName
     * @return
     */
    private int createHeader(HSSFCellStyle style, int headerNum, HSSFRow header, String headerName) {
        HSSFCell cell = header.createCell(headerNum++);
        cell.setCellValue(headerName);
        setCellStyle(cell, style);
        
        return headerNum;
    }
    
    /**
     * cell style
     * @param row
     * @param style
     */
    private void setCellStyle(HSSFCell cell, HSSFCellStyle style) {
        cell.setCellStyle(style);
    }
    
    /**
     * header명에서 getter명을 가져온다.
     * @param headerName
     */
    private String setMethodNamesList(String headerName) {
        return METHOD_PREFIX_GET + Character.toUpperCase(headerName.charAt(0)) + headerName.substring(1);
    }
    
    public ExcelResource<E> getExcelResource() {
        return excelResource;
    }
    
    /**
     * boolean일때는 getter가 'is'로 시작하므로 메소드명을 'get'으로 변경시켜준다.
     * @param method
     * @param realMethodName
     * @return
     */
    private String checkBoolAndReplaceMethodName(Method method) {
        String realMethodName = method.getName();
        Class<?> returnType = method.getReturnType();
        String typeName = returnType.getSimpleName();
        
        if (BOOLEAN_TYPE.equals(StringUtils.upperCase(typeName))) {
            realMethodName = realMethodName.replaceFirst(METHOD_PREFIX_IS, METHOD_PREFIX_GET);
        }

        return realMethodName;
    }
    
    /**
     * excel row를 생성한다
     * @param cellNum
     * @param row
     * @param cellValue
     * @param style
     * @param gubunKey
     */
    private void createRow(int cellNum, HSSFRow row, Object cellValue, HSSFCellStyle style, String gubunKey) {
        HSSFCell cell = row.createCell(cellNum);
        
        if (cellValue instanceof Boolean) {
            if(StringUtils.isEmpty(gubunKey)) {
                cell.setCellValue((Boolean) cellValue);
            } else {
                String value = this.getGubunOptionData(gubunKey, cellValue.toString());
                if(StringUtils.isEmpty(value)) {
                    cell.setCellValue((Boolean) cellValue);
                } else {
                    cell.setCellValue(value);
                }
            }
        } else if (cellValue instanceof Date) {
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) cellValue));
        } else if (cellValue instanceof Integer) {
            cell.setCellValue((Integer) cellValue);
        } else if (cellValue instanceof Double) {
            cell.setCellValue((Double) cellValue);
        } else if (cellValue instanceof Float) {
            cell.setCellValue((Float) cellValue);
        } else {
            if (cellValue != null) {
                if(StringUtils.isEmpty(gubunKey)) {
                    cell.setCellValue(cellValue.toString());
                } else {
                    String value = this.getGubunOptionData(gubunKey, cellValue.toString());
                    if(StringUtils.isEmpty(value)) {
                        cell.setCellValue(cellValue.toString());
                    } else {
                        cell.setCellValue(value);
                    }
                }
            }
        }
        
        setCellStyle(cell, style);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private String getGubunOptionData(String gubunKey, String value) {
        GubunTagNote note = GubunTagNote.getInstance();
        String methodName = gubunKey;
        
        if(!StringUtils.isEmpty(methodName)) {
            try {
                char ch = methodName.charAt(0);
                String getMethod = "get" + methodName.replaceFirst(String.valueOf(ch), String.valueOf(Character.toUpperCase(ch)));
                
                Method method = note.getClass().getMethod(getMethod, new Class[] {});
                Object o = method.invoke(note, new Object[]{});
                
                if(o instanceof List && ((List) o).size() > 0 && ((List) o).get(0) instanceof Parameter) {
                    for (Parameter parameter: (List<Parameter>) o) {
                        if (StringUtils.equals(value, parameter.getKey())) {
                            return parameter.getValue();
                        }
                    }
                }
            } catch (Exception e) {
                // ignore
            }
        }
        
        return null;
    }

}
