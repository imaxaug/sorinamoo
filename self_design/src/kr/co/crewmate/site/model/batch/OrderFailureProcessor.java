package kr.co.crewmate.site.model.batch;

import kr.co.crewmate.site.model.ToString;

public class OrderFailureProcessor extends ToString{

    private String totalOrderCnt;
    private String korWebCnt;
    private String korMobileCnt;
    private String chnWebCnt;
    private String chnMobileCnt;
    private String userCnt;
    
    public String getTotalOrderCnt() {
        return totalOrderCnt;
    }
    public void setTotalOrderCnt(String totalOrderCnt) {
        this.totalOrderCnt = totalOrderCnt;
    }
    public String getKorWebCnt() {
        return korWebCnt;
    }
    public void setKorWebCnt(String korWebCnt) {
        this.korWebCnt = korWebCnt;
    }
    public String getKorMobileCnt() {
        return korMobileCnt;
    }
    public void setKorMobileCnt(String korMobileCnt) {
        this.korMobileCnt = korMobileCnt;
    }
    public String getChnWebCnt() {
        return chnWebCnt;
    }
    public void setChnWebCnt(String chnWebCnt) {
        this.chnWebCnt = chnWebCnt;
    }
    public String getChnMobileCnt() {
        return chnMobileCnt;
    }
    public void setChnMobileCnt(String chnMobileCnt) {
        this.chnMobileCnt = chnMobileCnt;
    }
    public String getUserCnt() {
        return userCnt;
    }
    public void setUserCnt(String userCnt) {
        this.userCnt = userCnt;
    }

}
