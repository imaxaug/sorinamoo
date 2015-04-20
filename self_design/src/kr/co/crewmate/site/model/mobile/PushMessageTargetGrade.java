package kr.co.crewmate.site.model.mobile;

import kr.co.crewmate.site.model.ToString;

public class PushMessageTargetGrade extends ToString {
    private int pushMesgSeq;
    private String userGradeId;
    
    public PushMessageTargetGrade() {
        super();
    }
    
    public PushMessageTargetGrade(int pushMesgSeq, String userGradeId) {
        super();
        this.pushMesgSeq = pushMesgSeq;
        this.userGradeId = userGradeId;
    }
    public int getPushMesgSeq() {
        return pushMesgSeq;
    }
    public void setPushMesgSeq(int pushMesgSeq) {
        this.pushMesgSeq = pushMesgSeq;
    }
    public String getUserGradeId() {
        return userGradeId;
    }
    public void setUserGradeId(String userGradeId) {
        this.userGradeId = userGradeId;
    }
}
