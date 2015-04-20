package kr.co.crewmate.site.model.mobile;

import java.util.Date;
import java.util.List;

import kr.co.crewmate.site.model.ToString;

import org.apache.commons.lang3.StringUtils;

public class PushMessage extends ToString {
    private int pushMesgSeq;
    private String mesgDsc;
    private String linkUrl;
    private Date validEndDtm;
    private String sendStartDt;
    private String sendEndDt;
    private String sendHh;
    private String weekId;
    private Date rgstDtm;
    private String rgstAdminId;
    private Date lastModDtl;
    private String lastModAdminId;
    private String userGradeNameConcat;
    private List<String> userGradeIds;
    private String userGradeIdsToStr;    
    private String rgstAdminName;
    private String lastModAdminName;
    private String validEndDt;
    private String pushMesgStat;
    private String siteNatnCode;
    // 발송타입 (TEXT, LINK, IMAGE)
    private String sendType;
    private String imageUrl;
    private String testYn;
    
    public int getPushMesgSeq() {
        return pushMesgSeq;
    }
    public void setPushMesgSeq(int pushMesgSeq) {
        this.pushMesgSeq = pushMesgSeq;
    }
    public String getMesgDsc() {
        return mesgDsc;
    }
    public void setMesgDsc(String mesgDsc) {
        this.mesgDsc = mesgDsc;
    }
    public String getLinkUrl() {
        return linkUrl;
    }
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    public Date getValidEndDtm() {
        return validEndDtm;
    }
    public void setValidEndDtm(Date validEndDtm) {
        this.validEndDtm = validEndDtm;
    }
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
    public String getSendHh() {
        return sendHh;
    }
    public void setSendHh(String sendHh) {
        this.sendHh = sendHh;
    }
    public String getWeekId() {
        return weekId;
    }
    public void setWeekId(String weekId) {
        this.weekId = weekId;
    }
    public Date getRgstDtm() {
        return rgstDtm;
    }
    public void setRgstDtm(Date rgstDtm) {
        this.rgstDtm = rgstDtm;
    }
    public Date getLastModDtl() {
        return lastModDtl;
    }
    public void setLastModDtl(Date lastModDtl) {
        this.lastModDtl = lastModDtl;
    }
    public String getLastModAdminId() {
        return lastModAdminId;
    }
    public void setLastModAdminId(String lastModAdminId) {
        this.lastModAdminId = lastModAdminId;
    }
    public String getRgstAdminId() {
        return rgstAdminId;
    }
    public void setRgstAdminId(String rgstAdminId) {
        this.rgstAdminId = rgstAdminId;
    }
    public List<String> getUserGradeIds() {
        return userGradeIds;
    }
    public void setUserGradeIds(List<String> userGradeIds) {
        this.userGradeIds = userGradeIds;
    }
    public String getUserGradeNameConcat() {
        return userGradeNameConcat;
    }
    public void setUserGradeNameConcat(String userGradeNameConcat) {
        this.userGradeNameConcat = userGradeNameConcat;
    }
    public String getUserGradeIdsToStr() {
        return userGradeIdsToStr;
    }
    public void setUserGradeIdsToStr(String userGradeIdsToStr) {
        this.userGradeIdsToStr = userGradeIdsToStr;
    }
    public String getRgstAdminName() {
        return rgstAdminName;
    }
    public void setRgstAdminName(String rgstAdminName) {
        this.rgstAdminName = rgstAdminName;
    }
    public String getLastModAdminName() {
        return lastModAdminName;
    }
    public void setLastModAdminName(String lastModAdminName) {
        this.lastModAdminName = lastModAdminName;
    }
    public String getValidEndDt() {
        return validEndDt;
    }
    public void setValidEndDt(String validEndDt) {
        this.validEndDt = validEndDt;
    }
    public String getPushMesgStat() {
        return pushMesgStat;
    }
    public void setPushMesgStat(String pushMesgStat) {
        this.pushMesgStat = pushMesgStat;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTestYn() {
		return testYn;
	}
	public void setTestYn(String testYn) {
		this.testYn = testYn;
	}
}