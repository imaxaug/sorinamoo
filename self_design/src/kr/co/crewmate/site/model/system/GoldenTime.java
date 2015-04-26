package kr.co.crewmate.site.model.system;

import java.util.Date;

import kr.co.crewmate.site.model.ToString;

public class GoldenTime extends ToString{

    private String  yyyyMm ;    // YYYYMM
    private String startTime;   //    시작시간
    private String endTime ;    //   종료시간
    private String userGradeId ;    //  회원등급아이디
    private String weekId ; // 요일아이디
    private String lastModAdminId;  //  최종수정관리자아이디
    private Date  lastModDtm ;  //  최종수정일시
    
    private String  order ;    // 
    
    
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
    public String getYyyyMm() {
        return yyyyMm;
    }
    public void setYyyyMm(String yyyyMm) {
        this.yyyyMm = yyyyMm;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getUserGradeId() {
        return userGradeId;
    }
    public void setUserGradeId(String userGradeId) {
        this.userGradeId = userGradeId;
    }
    public String getWeekId() {
        return weekId;
    }
    public void setWeekId(String weekId) {
        this.weekId = weekId;
    }
    public String getLastModAdminId() {
        return lastModAdminId;
    }
    public void setLastModAdminId(String lastModAdminId) {
        this.lastModAdminId = lastModAdminId;
    }
    public Date getLastModDtm() {
        return lastModDtm;
    }
    public void setLastModDtm(Date lastModDtm) {
        this.lastModDtm = lastModDtm;
    }
    
    
}
