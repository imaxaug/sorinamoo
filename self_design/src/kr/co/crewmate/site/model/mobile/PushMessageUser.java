package kr.co.crewmate.site.model.mobile;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import kr.co.crewmate.site.model.ToString;

public class PushMessageUser extends ToString {
    private int pushMesgUserSeq;
    private int pushMesgSeq;
    private String userId;
    private String mblDvcCode;
    private String dvcToken;
    private String sendGbn;
    private Date sendDtm;
    
    private String mesgDsc;
    private String siteNatnCode;
    private String sendType;
    private String linkUrl;
    private String imageUrl;
    
    public int getPushMesgUserSeq() {
        return pushMesgUserSeq;
    }
    public void setPushMesgUserSeq(int pushMesgUserSeq) {
        this.pushMesgUserSeq = pushMesgUserSeq;
    }
    public int getPushMesgSeq() {
        return pushMesgSeq;
    }
    public void setPushMesgSeq(int pushMesgSeq) {
        this.pushMesgSeq = pushMesgSeq;
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
    public String getDvcToken() {
        return dvcToken;
    }
    public void setDvcToken(String dvcToken) {
        this.dvcToken = dvcToken;
    }
    public String getSendGbn() {
        return sendGbn;
    }
    public void setSendGbn(String sendGbn) {
        this.sendGbn = sendGbn;
    }
    public Date getSendDtm() {
        return sendDtm;
    }
    public void setSendDtm(Date sendDtm) {
        this.sendDtm = sendDtm;
    }
    public String getMesgDsc() {
        return mesgDsc;
    }
    public void setMesgDsc(String mesgDsc) {
        this.mesgDsc = mesgDsc;
    }
    
    
    public String toXml() {
        if(StringUtils.isEmpty(sendType) || "TEXT".equals(sendType)){
        	linkUrl = "";
        	imageUrl = "";
        } else if("LINK".equals(sendType)){
        	imageUrl = "";
        }

        StringBuilder builder = new StringBuilder();
        
        builder.append("<message>");
        builder.append(String.format("<push_mesg_seq>%d</push_mesg_seq>", pushMesgSeq));
        builder.append(String.format("<mesg_dsc>%s</mesg_dsc>"          , mesgDsc    ));
        builder.append(String.format("<link_url>%s</link_url>"          , linkUrl    ));
        builder.append(String.format("<image_url>%s</image_url>"        , imageUrl   ));
        builder.append(String.format("<valid_end_dtm></valid_end_dtm>"               ));
        builder.append("</message>");
        
        return builder.toString();
    }
	public String getSiteNatnCode() {
		return siteNatnCode;
	}
	public void setSiteNatnCode(String siteNatnCode) {
		this.siteNatnCode = siteNatnCode;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
