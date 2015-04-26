package kr.co.crewmate.site.model.system;

import kr.co.crewmate.site.model.PageParam;

@SuppressWarnings("serial")
public class MailCriteria extends PageParam {
    
    private String title;
    
    private String sendGbn;
    
    private String receiverMailAddress;
    
    private String receiverName;
    
    private String sequence;
     
    private String rgstStartDt;
    
    private String rgstEndDt;

    private String sendStartDt;
    
    private String sendEndDt;
    
    
    
     
    
    public String getSendStartDt() {
        return sendStartDt;
    }

    public void setSendStartDt(String sendStartDt) {
        this.sendStartDt = sendStartDt;
    }

    public String getSendEndDt() {
        return sendEndDt;
    }

    public void setSendEndDt(String sendEndDt) {
        this.sendEndDt = sendEndDt;
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

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSendGbn() {
        return sendGbn;
    }

    public void setSendGbn(String sendGbn) {
        this.sendGbn = sendGbn;
    }

    public String getReceiverMailAddress() {
        return receiverMailAddress;
    }

    public void setReceiverMailAddress(String receiverMailAddress) {
        this.receiverMailAddress = receiverMailAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    
    
}
