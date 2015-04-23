package kr.co.crewmate.site.model.common;

import kr.co.crewmate.site.model.ToString;

/**
 * 클래스명: <code>PostBoxPostNum</code>
 * 
 * <pre>
 * 신우편번호 사서함 클래스
 * </pre>
 *  
 * @author sist
 * @date   2013.03.29
 */
public class PostBoxPostNum extends ToString {
    
    /**
     * 우편번호
     */
    private String postNum;
    
    /**
     * 우편번호 일련번호
     */
    private String postNumSeq;
    
    /**
     * 시도
     */
    private String si;
    
    /**
     * 시군구
     */
    private String gu;
    
    /**
     * 읍면동
     */
    private String dong;
    
    /**
     * 도로명
     */
    private String doroName;
    
    /**
     * 시작주번
     */
    private String startMainNum;
    
    /**
     * 시작부번
     */
    private String startSubNum;
    
    /**
     * 끝주번
     */
    private String endSubNum;
    
    /**
     * 끝부번
     */
    private String siEng;
    
    /**
     * 시도영문명
     */
    private String guEng;
    
    /**
     * 시군구영문명
     */
    private String dongEng;
    
    /**
     * 읍면동영문명
     */
    private String doroNameEng;
    
    /**
     * 도로명영문명
     */
    private String lastModDt;
    
    /**
     * 최종수정일자
     */
    private String endMainNum;

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getPostNumSeq() {
        return postNumSeq;
    }

    public void setPostNumSeq(String postNumSeq) {
        this.postNumSeq = postNumSeq;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getDoroName() {
        return doroName;
    }

    public void setDoroName(String doroName) {
        this.doroName = doroName;
    }

    public String getStartMainNum() {
        return startMainNum;
    }

    public void setStartMainNum(String startMainNum) {
        this.startMainNum = startMainNum;
    }

    public String getStartSubNum() {
        return startSubNum;
    }

    public void setStartSubNum(String startSubNum) {
        this.startSubNum = startSubNum;
    }

    public String getEndSubNum() {
        return endSubNum;
    }

    public void setEndSubNum(String endSubNum) {
        this.endSubNum = endSubNum;
    }

    public String getSiEng() {
        return siEng;
    }

    public void setSiEng(String siEng) {
        this.siEng = siEng;
    }

    public String getGuEng() {
        return guEng;
    }

    public void setGuEng(String guEng) {
        this.guEng = guEng;
    }

    public String getDongEng() {
        return dongEng;
    }

    public void setDongEng(String dongEng) {
        this.dongEng = dongEng;
    }

    public String getDoroNameEng() {
        return doroNameEng;
    }

    public void setDoroNameEng(String doroNameEng) {
        this.doroNameEng = doroNameEng;
    }

    public String getLastModDt() {
        return lastModDt;
    }

    public void setLastModDt(String lastModDt) {
        this.lastModDt = lastModDt;
    }

    public String getEndMainNum() {
        return endMainNum;
    }

    public void setEndMainNum(String endMainNum) {
        this.endMainNum = endMainNum;
    }
}
