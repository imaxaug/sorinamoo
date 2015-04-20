package kr.co.crewmate.site.model.common;

import kr.co.crewmate.site.model.ToString;

/**
 * 
 * 클래스명: <code>ExcelHeader</code>
 *
 * <pre>
 *  엑셀 헤더 정보
 * </pre>
 *
 * @author newstar000
 * @date 2011. 11. 28.
 *
 */
public class ExcelHeader extends ToString {

    private String header;
    
    private String displayName;
    
    private String gubunKey;

    public ExcelHeader() {
        
    }
    
    public ExcelHeader(String header, String displayName) {
        this.header = header;
        this.displayName = displayName;
    }
    
    public ExcelHeader(String header, String displayName, String gubunKey) {
        this.header = header;
        this.displayName = displayName;
        this.gubunKey = gubunKey;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGubunKey() {
        return gubunKey;
    }

    public void setGubunKey(String gubunKey) {
        this.gubunKey = gubunKey;
    }
}
