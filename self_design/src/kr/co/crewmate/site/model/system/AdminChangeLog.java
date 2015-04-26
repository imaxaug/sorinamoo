package kr.co.crewmate.site.model.system;

import java.util.Date;

import kr.co.crewmate.site.model.ToString;

public class AdminChangeLog extends ToString{
	
    private int adminChngLogSequence;
    
    private String adminRsn;
    
    private String changeLog;
    
    private String adminId;

    private String userId;
    
    private Date rgstDtm;

	public int getAdminChngLogSequence() {
		return adminChngLogSequence;
	}

	public void setAdminChngLogSequence(int adminChngLogSequence) {
		this.adminChngLogSequence = adminChngLogSequence;
	}

	public String getAdminRsn() {
		return adminRsn;
	}

	public void setAdminRsn(String adminRsn) {
		this.adminRsn = adminRsn;
	}

	public String getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(String changeLog) {
		this.changeLog = changeLog;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRgstDtm() {
		return rgstDtm;
	}

	public void setRgstDtm(Date rgstDtm) {
		this.rgstDtm = rgstDtm;
	}


    

    
    
    

    
}
