package kr.co.crewmate.site.model.system;

import java.util.Date;

import kr.co.crewmate.site.model.ToString;

public class AdminWorkHistory extends ToString{
	
    private int adminWorkHistorySequence;
    
    private int workSeq;

    private String adminId;
    
    private String userId;
    
    private Date rgstDtm;
    
    private String menuUrl;
    
    private String ipAddr;
    
    private String actionFlag;
    
    private boolean excelFlag;
    
    private String customerAgrees;

	public int getAdminWorkHistorySequence() {
		return adminWorkHistorySequence;
	}

	public void setAdminWorkHistorySequence(int adminWorkHistorySequence) {
		this.adminWorkHistorySequence = adminWorkHistorySequence;
	}

	public int getWorkSeq() {
		return workSeq;
	}

	public void setWorkSeq(int workSeq) {
		this.workSeq = workSeq;
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

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(String actionFlag) {
		this.actionFlag = actionFlag;
	}

	public boolean isExcelFlag() {
		return excelFlag;
	}

	public void setExcelFlag(boolean excelFlag) {
		this.excelFlag = excelFlag;
	}

	public String getCustomerAgrees() {
		return customerAgrees;
	}

	public void setCustomerAgrees(String customerAgrees) {
		this.customerAgrees = customerAgrees;
	}





    
    
    

    
}
