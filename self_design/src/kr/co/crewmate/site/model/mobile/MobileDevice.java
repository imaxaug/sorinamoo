package kr.co.crewmate.site.model.mobile;

import java.util.Date;

import kr.co.crewmate.site.model.ToString;

public class MobileDevice extends ToString {

    private int mblDvcSeq;
    
    private String mblDvcCode;
    
    private String dvcToken;
    
    private Boolean recvYn;
    
    private Date rgstDtm;
    
    private String userId;
    
    private String siteNatnCode;

    public int getMblDvcSeq() {
        return mblDvcSeq;
    }

    public void setMblDvcSeq(int mblDvcSeq) {
        this.mblDvcSeq = mblDvcSeq;
    }

    public String getDvcToken() {
        return dvcToken;
    }

    public void setDvcToken(String dvcToken) {
        this.dvcToken = dvcToken;
    }

    public Date getRgstDtm() {
        return rgstDtm;
    }

    public void setRgstDtm(Date rgstDtm) {
        this.rgstDtm = rgstDtm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMblDvcCode() {
        return mblDvcCode;
    }

    public void setMblDvcCode(String mblDvcCode) {
        this.mblDvcCode = mblDvcCode;
    }

    public Boolean getRecvYn() {
        return recvYn;
    }

    public void setRecvYn(Boolean recvYn) {
        this.recvYn = recvYn;
    }

	public String getSiteNatnCode() {
		return siteNatnCode;
	}

	public void setSiteNatnCode(String siteNatnCode) {
		this.siteNatnCode = siteNatnCode;
	}
    
}
