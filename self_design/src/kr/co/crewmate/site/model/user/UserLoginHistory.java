package kr.co.crewmate.site.model.user;

import java.util.Date;

import kr.co.crewmate.site.model.ToString;

/**
 * 클래스명: <code>UserLoginHistory</code>
 *
 * <pre>
 *  설명을 기입하세요
 * </pre>
 *
 * @author 이경연 
 * @date 2013. 6. 5.
 *
 */
@SuppressWarnings("serial")
public class UserLoginHistory extends ToString {
    
    private String userId;
    
    private int loginHistSeq;
    
    private String cntrIpAddr;
    
    private Date loginDtm;
    
    private Date logOutDtm;
    
    private String linkSiteGbnCode;
    
    private String siteNatnCode;

    public String getLinkSiteGbnCode() {
        return linkSiteGbnCode;
    }

    public void setLinkSiteGbnCode(String linkSiteGbnCode) {
        this.linkSiteGbnCode = linkSiteGbnCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getLoginHistSeq() {
        return loginHistSeq;
    }

    public void setLoginHistSeq(int loginHistSeq) {
        this.loginHistSeq = loginHistSeq;
    }

    public String getCntrIpAddr() {
        return cntrIpAddr;
    }

    public void setCntrIpAddr(String cntrIpAddr) {
        this.cntrIpAddr = cntrIpAddr;
    }

    public Date getLoginDtm() {
        return loginDtm;
    }

    public void setLoginDtm(Date loginDtm) {
        this.loginDtm = loginDtm;
    }

    public Date getLogOutDtm() {
        return logOutDtm;
    }

    public void setLogOutDtm(Date logOutDtm) {
        this.logOutDtm = logOutDtm;
    }

    public String getSiteNatnCode() {
        return siteNatnCode;
    }

    public void setSiteNatnCode(String siteNatnCode) {
        this.siteNatnCode = siteNatnCode;
    }
}
