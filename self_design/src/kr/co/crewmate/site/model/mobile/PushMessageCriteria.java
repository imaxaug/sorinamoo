package kr.co.crewmate.site.model.mobile;

import java.util.List;

import kr.co.crewmate.site.model.PageParam;

public class PushMessageCriteria extends PageParam {
    private boolean timeAttack;
    private String siteNatnCode;
    private int pushMesgSeq;
    private List<String> userIds;

    public PushMessageCriteria() {
        super();
    }
    
    public PushMessageCriteria(boolean timeAttack) {
        super();
        this.timeAttack = timeAttack;
    }

    public boolean isTimeAttack() {
        return timeAttack;
    }

    public void setTimeAttack(boolean timeAttack) {
        this.timeAttack = timeAttack;
    }

	public String getSiteNatnCode() {
		return siteNatnCode;
	}

	public void setSiteNatnCode(String siteNatnCode) {
		this.siteNatnCode = siteNatnCode;
	}

	public int getPushMesgSeq() {
		return pushMesgSeq;
	}

	public void setPushMesgSeq(int pushMesgSeq) {
		this.pushMesgSeq = pushMesgSeq;
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

}
