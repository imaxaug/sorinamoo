package kr.co.crewmate.site.model.user;

import java.util.List;

import kr.co.crewmate.site.model.PageParam;

/**
 * 
 * 클래스명: <code>UserCriteria</code>
 *
 * <pre>
 *  회원 리스트를 검색 및 페이지 처리를 위한 모델 클래스
 * </pre>
 * 
 * @author 남세건
 * @date 2013.5.24
 *
 */
public class UserCriteria extends PageParam {
 
    private String userId;
    
    private String sexGbn;
    
    private String userNameKor;
    
    private String engFirstName;
    
    private String hpTelNum;
    
    private String email1;
    
    private String email2;
    
    private String mailAddr;
    
    private boolean offLineJoinYn;
    
    private String vipNum;
    
    private String natnCode;
    
    private String psprtNum;
    
    private String leaveStatCode;
    
    private String userLevelCode;
    
    private boolean allUserGradeId;
    
    private boolean firstSearch = true;
    
    private String[] userGradeId;
    
    private String userGradeIdStr;
    
    private String startUserUpDtm;
    
    private String endUserUpDtm;
    
    private String startJoinDtm;
    
    private String endJoinDtm;
    
    private Boolean buyYn;
    
    private Boolean smsRecvYn;
    
    private Boolean mailRecvYn;
    
    private String birthDt;
    
    private Boolean joinDtmDesc;
    
    private String decorator;
    
    private String multiYn;
    
    private String[] checkedUserIds;
    
    private boolean allUserGroupId;
    
    private String userGroupIdStr;
    
    private String[] userGroupId;
    
    private boolean reJoinYn; 
    
    private String startRgstDtm;
    
    private String endRgstDtm;
    
    private String leaveReqRsnCode;
    
    private String leaveReqStatCode;
    
    private String selectUserGradeId;
    
    private List<String> userIds;
    
    private List<String> exceptUserIds;
    
    private Boolean exiter;
    
    private String ssgStaffEmplNum;
    
    private String siteNatnCode;
    
    private String linkSiteGbnCode;
    
    private boolean btnSearchYn;
    
    public String getSsgStaffEmplNum() {
        return ssgStaffEmplNum;
    }

    public void setSsgStaffEmplNum(String ssgStaffEmplNum) {
        this.ssgStaffEmplNum = ssgStaffEmplNum;
    }

    public Boolean getExiter() {
        return exiter;
    }

    public void setExiter(Boolean exiter) {
        this.exiter = exiter;
    }

    public String getSelectUserGradeId() {
        return selectUserGradeId;
    }

    public void setSelectUserGradeId(String selectUserGradeId) {
        this.selectUserGradeId = selectUserGradeId;
    }

    public String getLeaveReqStatCode() {
        return leaveReqStatCode;
    }

    public void setLeaveReqStatCode(String leaveReqStatCode) {
        this.leaveReqStatCode = leaveReqStatCode;
    }

    public String getLeaveReqRsnCode() {
        return leaveReqRsnCode;
    }

    public void setLeaveReqRsnCode(String leaveReqRsnCode) {
        this.leaveReqRsnCode = leaveReqRsnCode;
    }

    public String getStartRgstDtm() {
        return startRgstDtm;
    }

    public void setStartRgstDtm(String startRgstDtm) {
        this.startRgstDtm = startRgstDtm;
    }

    public String getEndRgstDtm() {
        return endRgstDtm;
    }

    public void setEndRgstDtm(String endRgstDtm) {
        this.endRgstDtm = endRgstDtm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSexGbn() {
        return sexGbn;
    }

    public void setSexGbn(String sexGbn) {
        this.sexGbn = sexGbn;
    }

    public String getUserNameKor() {
        return userNameKor;
    }

    public void setUserNameKor(String userNameKor) {
        this.userNameKor = userNameKor;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

    public String getEngFirstName() {
        return engFirstName;
    }

    public void setEngFirstName(String engFirstName) {
        this.engFirstName = engFirstName;
    }

    public boolean isOffLineJoinYn() {
        return offLineJoinYn;
    }

    public void setOffLineJoinYn(boolean offLineJoinYn) {
        this.offLineJoinYn = offLineJoinYn;
    }

    public String getVipNum() {
        return vipNum;
    }

    public void setVipNum(String vipNum) {
        this.vipNum = vipNum;
    }

    public String getNatnCode() {
        return natnCode;
    }

    public void setNatnCode(String natnCode) {
        this.natnCode = natnCode;
    }

    public String getPsprtNum() {
        return psprtNum;
    }

    public void setPsprtNum(String psprtNum) {
        this.psprtNum = psprtNum;
    }

    public String getLeaveStatCode() {
        return leaveStatCode;
    }

    public void setLeaveStatCode(String leaveStatCode) {
        this.leaveStatCode = leaveStatCode;
    }

    public String getUserLevelCode() {
        return userLevelCode;
    }

    public void setUserLevelCode(String userLevelCode) {
        this.userLevelCode = userLevelCode;
    }

    public String getHpTelNum() {
        return hpTelNum;
    }

    public void setHpTelNum(String hpTelNum) {
        this.hpTelNum = hpTelNum;
    }

    public String[] getUserGradeId() {
        return userGradeId;
    }

    public void setUserGradeId(String[] userGradeId) {
        this.userGradeId = userGradeId;
    }

    public boolean isAllUserGradeId() {
        return allUserGradeId;
    }

    public void setAllUserGradeId(boolean allUserGradeId) {
        this.allUserGradeId = allUserGradeId;
    }

    public boolean isFirstSearch() {
        return firstSearch;
    }

    public void setFirstSearch(boolean firstSearch) {
        this.firstSearch = firstSearch;
    }

    public String getUserGradeIdStr() {
        return userGradeIdStr;
    }

    public void setUserGradeIdStr(String userGradeIdStr) {
        this.userGradeIdStr = userGradeIdStr;
    }

    public String getStartUserUpDtm() {
        return startUserUpDtm;
    }

    public void setStartUserUpDtm(String startUserUpDtm) {
        this.startUserUpDtm = startUserUpDtm;
    }

    public String getEndUserUpDtm() {
        return endUserUpDtm;
    }

    public void setEndUserUpDtm(String endUserUpDtm) {
        this.endUserUpDtm = endUserUpDtm;
    }

    public String getStartJoinDtm() {
        return startJoinDtm;
    }

    public void setStartJoinDtm(String startJoinDtm) {
        this.startJoinDtm = startJoinDtm;
    }

    public String getEndJoinDtm() {
        return endJoinDtm;
    }

    public void setEndJoinDtm(String endJoinDtm) {
        this.endJoinDtm = endJoinDtm;
    }

    public Boolean getBuyYn() {
        return buyYn;
    }

    public void setBuyYn(Boolean buyYn) {
        this.buyYn = buyYn;
    }

    public Boolean getSmsRecvYn() {
        return smsRecvYn;
    }

    public void setSmsRecvYn(Boolean smsRecvYn) {
        this.smsRecvYn = smsRecvYn;
    }

    public Boolean getMailRecvYn() {
        return mailRecvYn;
    }

    public void setMailRecvYn(Boolean mailRecvYn) {
        this.mailRecvYn = mailRecvYn;
    }

    public String getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }

    public Boolean getJoinDtmDesc() {
        return joinDtmDesc;
    }

    public void setJoinDtmDesc(Boolean joinDtmDesc) {
        this.joinDtmDesc = joinDtmDesc;
    }

    public String getDecorator() {
        return decorator;
    }

    public void setDecorator(String decorator) {
        this.decorator = decorator;
    }

    public String getMultiYn() {
        return multiYn;
    }

    public void setMultiYn(String multiYn) {
        this.multiYn = multiYn;
    }

    public String[] getCheckedUserIds() {
        return checkedUserIds;
    }

    public void setCheckedUserIds(String[] checkedUserIds) {
        this.checkedUserIds = checkedUserIds;
    }

    public boolean getAllUserGroupId() {
        return allUserGroupId;
    }

    public void setAllUserGroupId(boolean allUserGroupId) {
        this.allUserGroupId = allUserGroupId;
    }

    public String getUserGroupIdStr() {
        return userGroupIdStr;
    }

    public void setUserGroupIdStr(String userGroupIdStr) {
        this.userGroupIdStr = userGroupIdStr;
    }

    public String[] getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String[] userGroupId) {
        this.userGroupId = userGroupId;
    }

    public boolean getReJoinYn() {
        return reJoinYn;
    }

    public void setReJoinYn(boolean reJoinYn) {
        this.reJoinYn = reJoinYn;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public List<String> getExceptUserIds() {
        return exceptUserIds;
    }

    public void setExceptUserIds(List<String> exceptUserIds) {
        this.exceptUserIds = exceptUserIds;
    }

    public String getSiteNatnCode() {
        return siteNatnCode;
    }

    public void setSiteNatnCode(String siteNatnCode) {
        this.siteNatnCode = siteNatnCode;
    }

    public String getLinkSiteGbnCode() {
        return linkSiteGbnCode;
    }

    public void setLinkSiteGbnCode(String linkSiteGbnCode) {
        this.linkSiteGbnCode = linkSiteGbnCode;
    }

    public boolean isBtnSearchYn() {
        return btnSearchYn;
    }

    public void setBtnSearchYn(boolean btnSearchYn) {
        this.btnSearchYn = btnSearchYn;
    }
    
}
