package kr.co.crewmate.site.utils.excel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import kr.co.crewmate.utils.Closer;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 
 * 클래스명: <code>TemplateExcelDownload</code>
 *
 * <pre>
 *  template 이 있는 exceldownload 를 위한 클래스
 *  
 *  엑셀 템플릿 문법 http://jxls.sourceforge.net/reference/tags.html 참고
 * </pre>
 *
 * @author newstar000
 * @date 2011. 11. 29.
 *
 */
public class TemplateExcelDownload {

    /**
     * excel download
     * @param templateFileName 엑셀 템플릿 파일명
     * @param fileName 엑셀 파일명
     * @param map 다운로드 받을 List를 담은 Map
     * @param response 
     */
    public void download(String templateFileName, String fileName , Map<String, Object> map, HttpServletResponse response) {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        
        OutputStream output = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        
        try {
            output = response.getOutputStream();
            XLSTransformer transformer = new XLSTransformer();
            HSSFWorkbook workbook = transformer.transformXLS(new FileInputStream(new File(templateFileName)), map);
            
            workbook.write(os);
            byte[] bs = os.toByteArray();

            output.write(bs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Closer.close(os, output);
        }
    }
}
