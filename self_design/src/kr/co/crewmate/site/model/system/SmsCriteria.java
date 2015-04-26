package kr.co.crewmate.site.model.system;

import kr.co.crewmate.site.model.PageParam;

@SuppressWarnings("serial")
public class SmsCriteria extends PageParam{

    private int smsSeq;
    
    private String sendTelNum;
    
    private String recvTelNum;
    
    private String smsTitle;
    
    private String sendYn;
    
    private String smsSendCode;
    
    private String rgstStartDt;
    
    private String rgstEndDt;

    private String smsCont;

    
	public int getSmsSeq() {
        return smsSeq;
    }

    public void setSmsSeq(int smsSeq) {
        this.smsSeq = smsSeq;
    }

    public String getSendTelNum() {
        return sendTelNum;
    }

    public void setSendTelNum(String sendTelNum) {
        this.sendTelNum = sendTelNum;
    }

    public String getRecvTelNum() {
        return recvTelNum;
    }

    public void setRecvTelNum(String recvTelNum) {
        this.recvTelNum = recvTelNum;
    }

    public String getSmsTitle() {
        return smsTitle;
    }

    public void setSmsTitle(String smsTitle) {
        this.smsTitle = smsTitle;
    }

    public String getSendYn() {
        return sendYn;
    }

    public void setSendYn(String sendYn) {
        this.sendYn = sendYn;
    }

    public String getSmsSendCode() {
        return smsSendCode;
    }

    public void setSmsSendCode(String smsSendCode) {
        this.smsSendCode = smsSendCode;
    }

    public String getRgstStartDt() {
        return rgstStartDt;
    }

    public void setRgstStartDt(String rgstStartDt) {
        this.rgstStartDt = rgstStartDt;
    }

    public String getRgstEndDt() {
        return rgstEndDt;
    }

    public void setRgstEndDt(String rgstEndDt) {
        this.rgstEndDt = rgstEndDt;
    }

	public String getSmsCont() {
		return smsCont;
	}

	public void setSmsCont(String smsCont) {
		this.smsCont = smsCont;
	}
    
}
