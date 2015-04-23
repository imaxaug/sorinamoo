package kr.co.crewmate.site.model.system;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.ToString;

import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SuppressWarnings("serial")
public class MailQueue extends ToString {
    
    public final static String NO_SEND = "N";
    
    public final static String FAILURE = "F";
    
    private int sequence;
    
    private String title;
    
    private String senderName;
    
    private String senderMailAddress;
    
    private String content;
    
    private Date registDatetime;
    
    private String sendGbn = NO_SEND;
    
    private Date sendDatetime;
    
    private String receiverName;
    
    private String receiverMailAddress;
    
    private String sendFailureReason;

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderMailAddress() {
        return senderMailAddress;
    }

    public void setSenderMailAddress(String senderMailAddress) {
        this.senderMailAddress = senderMailAddress;
    }

    public Date getRegistDatetime() {
        return registDatetime;
    }

    public void setRegistDatetime(Date registDatetime) {
        this.registDatetime = registDatetime;
    }

    public String getSendGbn() {
        return sendGbn;
    }

    public void setSendGbn(String sendGbn) {
        this.sendGbn = sendGbn;
    }

    public Date getSendDatetime() {
        return sendDatetime;
    }

    public void setSendDatetime(Date sendDatetime) {
        this.sendDatetime = sendDatetime;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMailAddress() {
        return receiverMailAddress;
    }

    public void setReceiverMailAddress(String receiverMailAddress) {
        this.receiverMailAddress = receiverMailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendFailureReason() {
        return sendFailureReason;
    }

    public void setSendFailureReason(String sendFailureReason) {
        this.sendFailureReason = sendFailureReason;
    }
    
    public static MailQueue getInstance() {
        MailQueue mail = new MailQueue();
        mail.setSenderName(Config.getString("sender.name"));
        mail.setSenderMailAddress(Config.getString("sender.mail.address"));

        return mail;
    }

    public void send(JavaMailSender mailSender) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.addTo(this.getReceiverMailAddress(), this.getReceiverName());
            helper.setFrom(this.getSenderMailAddress(), this.getSenderName());
            helper.setSubject(this.getTitle());
            helper.setText(StringUtils.isEmpty(this.getContent()) ? this.getTitle() : this.getContent(), true);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        
        mailSender.send(message);
    }
}
