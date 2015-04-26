package kr.co.crewmate.site.model.system;

import java.util.Date;

public class ShinsegaeMember {

    private String empNo;
    private String regNo;
    private String sex;
    private String empNm;
    private String workYn;
    private Date chgDate;
    private String ci;
    
    public String getEmpNo() {
        return empNo;
    }
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
    public String getRegNo() {
        return regNo;
    }
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getEmpNm() {
        return empNm;
    }
    public void setEmpNm(String empNm) {
        this.empNm = empNm;
    }
    public String getWorkYn() {
        return workYn;
    }
    public void setWorkYn(String workYn) {
        this.workYn = workYn;
    }
    public String getCi() {
        return ci;
    }
    public void setCi(String ci) {
        this.ci = ci;
    }
    public Date getChgDate() {
        return chgDate;
    }
    public void setChgDate(Date chgDate) {
        this.chgDate = chgDate;
    }
    
}
