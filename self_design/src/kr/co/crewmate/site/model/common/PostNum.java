package kr.co.crewmate.site.model.common;

import kr.co.crewmate.site.model.ToString;

/**
 * 
 * 클래스명: <code>PostNum</code>
 *
 * <pre>
 *  구 우편번호테이블 구조
 * </pre>
 *
 * @author newstar000
 * @date 2011. 12. 12.
 *
 */
public class PostNum extends ToString {

    /**
     * 우편번호 일련번호
     */
    private String postNumSeq;
    
    /**
     * 우편번호
     */
    private String postNum;
    
    /**
     * 시
     */
    private String si;
    
    /**
     * 구
     */
    private String gu;
    
    /**
     * 동(읍/면)
     */
    private String dong;
    
    /**
     * 리
     */
    private String ri;
    
    /**
     * 도서
     */
    private String doseo;
    
    /**
     * 번지
     */
    private String bungi;
    
    /**
     * 빌딩이름
     */
    private String bldg_name;
    
    /**
     * 주소
     */
    private  String addr;
    
    private String bldgName;
    
    public String getPostNumSeq() {
        return postNumSeq;
    }

    public void setPostNumSeq(String postNumSeq) {
        this.postNumSeq = postNumSeq;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
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

    public String getRi() {
        return ri;
    }

    public void setRi(String ri) {
        this.ri = ri;
    }

    public String getDoseo() {
        return doseo;
    }

    public void setDoseo(String doseo) {
        this.doseo = doseo;
    }

    public String getBungi() {
        return bungi;
    }

    public void setBungi(String bungi) {
        this.bungi = bungi;
    }

    public String getBldg_name() {
        return bldg_name;
    }

    public void setBldg_name(String bldg_name) {
        this.bldg_name = bldg_name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getBldgName() {
        return bldgName;
    }

    public void setBldgName(String bldgName) {
        this.bldgName = bldgName;
    }
}
