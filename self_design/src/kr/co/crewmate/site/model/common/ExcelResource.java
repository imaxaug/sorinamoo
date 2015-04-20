package kr.co.crewmate.site.model.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.co.crewmate.site.model.ToString;

/**
 * 
 * 클래스명: <code>ExcelResource</code>
 *
 * <pre>
 *  엑셀 다운로드를 위한 정보를 저장하는 모델 클래스
 * </pre>
 *
 * @author newstar000
 * @date 2011. 11. 28.
 *
 * @param <E>
 */
@SuppressWarnings("serial")
public class ExcelResource<E> extends ToString {

    private final List<E> list;
    
    private List<ExcelHeader> headers;
    
    public ExcelResource(List<E> list) {
        this.list = list;
    }
    
    public ExcelResource(List<E> list, ExcelHeader[] excelHeaders) {
        this.list = list;
        setHeaders(excelHeaders);
    }
    
    public List<ExcelHeader> getHeaders() {
        return headers;
    }
    
    public void addHeader(ExcelHeader header) {
        this.headers.add(header);
    }
    
    public void addHeaders(List<ExcelHeader> headers) {
        List<ExcelHeader> temp = this.headers;
        this.headers = new ArrayList<ExcelHeader>();
        
        this.headers.addAll(temp);
        this.headers.addAll(headers);
    }

    public List<E> getList() {
        return list;
    }

    public void setHeaders(List<ExcelHeader> headers) {
        this.headers = headers;
    }
    
    public void setHeaders(ExcelHeader[] headers) {
        this.headers = Arrays.asList(headers);
    }
}
