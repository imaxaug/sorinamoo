package kr.co.crewmate.site.model.common;

import kr.co.crewmate.site.model.ToString;

/**
 * 클래스명: <code>Message</code>
 *
 * <pre>
 *  설명을 기입하세요
 * </pre>
 *
 * @author 최홍석
 * @date 2013. 7. 26.
 *
 */
public class Message extends ToString {

    private String mesgKey;
    
    private String langCode;
    
    private String mesgCont;
    
    public String getMesgKey() {
        return mesgKey;
    }
    
    public void setMesgKey(String mesgKey) {
        this.mesgKey = mesgKey;
    }
    
    public String getLangCode() {
        return langCode;
    }
    
    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
    
    public String getMesgCont() {
        return mesgCont;
    }
    
    public void setMesgCont(String mesgCont) {
        this.mesgCont = mesgCont;
    }
    
}
