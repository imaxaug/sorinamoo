package kr.co.crewmate.site.model.common;

import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ToString;

public class NewPostNum extends ToString implements Parameter {

    private String lawDongCode; // 법정동 코드
    
    private String lawDongName; // 법정동 명

    private String si;          // 시도
    
    private String siEng;       // 시도영문

    private String gu;          // 시군구
    
    private String guEng;       // 시군구영문

    private String dong;        // 읍면

    private String ri;          // 리
    
    private String riEng;       // 읍면영문

    private String mountGbn;    // 산여부

    private String landMainNum; // 지번본번

    private String landSubNum;  // 지번부번

    private String doroCode;    // 도로명코드

    private String doroName;    // 도로명
    
    private String doroEngName; // 도로명 영문
    
    private String jihaGbn;     // 지하여부

    private String bldgMainNum; // 건물번호본번 

    private String bldgSubNum;  // 건물번호부번

    private String bldgName;    // 시군구건물명

    private String bldgDtlName;

    private String bldgMngrName;   // 건물관리번호

    private String dongSeq;        // 읍면동 일련번호

    private String postNum;        // 우편번호 

    private String postSeq;        // 우편일련번호

    private String multiDlvyName;  // 다량배달처명
    
    public String getLawDongCode() {
        return lawDongCode;
    }

    public void setLawDongCode(String lawDongCode) {
        this.lawDongCode = lawDongCode;
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

    public String getMountGbn() {
        return mountGbn;
    }

    public void setMountGbn(String mountGbn) {
        this.mountGbn = mountGbn;
    }

    public String getLandMainNum() {
        return landMainNum;
    }

    public void setLandMainNum(String landMainNum) {
        this.landMainNum = landMainNum;
    }

    public String getLandSubNum() {
        return landSubNum;
    }

    public void setLandSubNum(String landSubNum) {
        this.landSubNum = landSubNum;
    }

    public String getDoroCode() {
        return doroCode;
    }

    public void setDoroCode(String doroCode) {
        this.doroCode = doroCode;
    }

    public String getDoroName() {
        return doroName;
    }

    public void setDoroName(String doroName) {
        this.doroName = doroName;
    }

    public String getJihaGbn() {
        return jihaGbn;
    }

    public void setJihaGbn(String jihaGbn) {
        this.jihaGbn = jihaGbn;
    }

    public String getBldgMainNum() {
        return bldgMainNum;
    }

    public void setBldgMainNum(String bldgMainNum) {
        this.bldgMainNum = bldgMainNum;
    }

    public String getBldgSubNum() {
        return bldgSubNum;
    }

    public void setBldgSubNum(String bldgSubNum) {
        this.bldgSubNum = bldgSubNum;
    }

    public String getBldgName() {
        return bldgName;
    }

    public void setBldgName(String bldgName) {
        this.bldgName = bldgName;
    }

    public String getBldgDtlName() {
        return bldgDtlName;
    }

    public void setBldgDtlName(String bldgDtlName) {
        this.bldgDtlName = bldgDtlName;
    }

    public String getBldgMngrName() {
        return bldgMngrName;
    }

    public void setBldgMngrName(String bldgMngrName) {
        this.bldgMngrName = bldgMngrName;
    }

    public String getDongSeq() {
        return dongSeq;
    }

    public void setDongSeq(String dongSeq) {
        this.dongSeq = dongSeq;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getLawDongName() {
        return lawDongName;
    }

    public void setLawDongName(String lawDongName) {
        this.lawDongName = lawDongName;
    }

    public String getGuEng() {
        return guEng;
    }

    public void setGuEng(String guEng) {
        this.guEng = guEng;
    }

    public String getRiEng() {
        return riEng;
    }

    public void setRiEng(String riEng) {
        this.riEng = riEng;
    }

    public String getDoroEngName() {
        return doroEngName;
    }

    public void setDoroEngName(String doroEngName) {
        this.doroEngName = doroEngName;
    }

    public String getPostSeq() {
        return postSeq;
    }

    public void setPostSeq(String postSeq) {
        this.postSeq = postSeq;
    }

    public String getMultiDlvyName() {
        return multiDlvyName;
    }

    public void setMultiDlvyName(String multiDlvyName) {
        this.multiDlvyName = multiDlvyName;
    }

    public String getSiEng() {
        return siEng;
    }

    public void setSiEng(String siEng) {
        this.siEng = siEng;
    }

    @Override
    public String getKey() {
        return getGu();
    }

    @Override
    public String getValue() {
        return getGu();
    }
}
