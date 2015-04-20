package kr.co.crewmate.site.exceptions;

@SuppressWarnings("serial")
public class SsgGiftCradException extends RuntimeException {

    private int replyCode;

    private String replyMessage;

    public SsgGiftCradException(int replyCode, String replyMessage) {
        this.replyCode = replyCode;
        this.replyMessage = replyMessage;
    }
    
    public SsgGiftCradException(String replyMessage) {
        super(replyMessage);
    }

    public SsgGiftCradException(Exception e) {
        super(e);
    }
    
    public int getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(int replyCode) {
        this.replyCode = replyCode;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }

}
