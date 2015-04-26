package kr.co.crewmate.site.model.system;

import java.util.Date;

import kr.co.crewmate.site.model.ToString;

@SuppressWarnings("serial")
public class Sms extends ToString {
    
    public final static String NO_SEND = "N";
    
    public final static String SENDER_TEL_NUM = "1577-0161";
    
    private int smsSeq;
    
    private String sendTelNum;
    
    private String recvTelNum;
    
    private String smsTitle;
    
    private String smsCont;
    
    private String filePath;
    
    private Date rgstDtm;
    
    private String rgstAdminId;
    
    private String sendYn;
    
    private Date sendDtm;
    
    private String smsSendCode;


    public int getSmsSeq() {
        return smsSeq;
    }

    public void setSmsSeq(int smsSeq) {
        this.smsSeq = smsSeq;
    }

    public static String getNoSend() {
        return NO_SEND;
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

    public String getSmsCont() {
        return smsCont;
    }

    public void setSmsCont(String smsCont) {
        this.smsCont = smsCont;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getRgstDtm() {
        return rgstDtm;
    }

    public void setRgstDtm(Date rgstDtm) {
        this.rgstDtm = rgstDtm;
    }

    public String getRgstAdminId() {
        return rgstAdminId;
    }

    public void setRgstAdminId(String rgstAdminId) {
        this.rgstAdminId = rgstAdminId;
    }

    public String getSendYn() {
        return sendYn;
    }

    public void setSendYn(String sendYn) {
        this.sendYn = sendYn;
    }

    public Date getSendDtm() {
        return sendDtm;
    }

    public void setSendDtm(Date sendDtm) {
        this.sendDtm = sendDtm;
    }

    public String getSmsSendCode() {
        return smsSendCode;
    }

    public void setSmsSendCode(String smsSendCode) {
        this.smsSendCode = smsSendCode;
    }

    public static Sms getInstace() {
        Sms sms = new Sms();
        sms.setSendYn(NO_SEND);
        sms.setSendTelNum(SENDER_TEL_NUM);
        sms.setSmsSendCode("SMS");
        return sms;
    }

}
