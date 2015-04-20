package kr.co.crewmate.site.model;

import kr.co.crewmate.site.CodeName;
import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.user.User;

@SuppressWarnings("serial")
public class LoginUser extends ToString {

    private User user;

//    private UserPassport passport;
//
//    private UserGrade grade;
//
//    private int addDiscountRate;
//
//    private int addSavedRate;
//
//    private UserGroup userGroup;

    private String userGradeId;

    private String linkSiteGbnCode;

    private int sessionHashKey;

    private String gradeSmryWord;

    public LoginUser() {

    }

//    public LoginUser(User user, UserPassport passport, UserGrade grade, UserGroup userGroup) {
//        if (false == "E".equals(user.getLeaveStatCode())) {
//            this.user = user;
//            this.passport = passport;
//            this.grade = grade;
//            this.userGroup = userGroup;
//            if (this.userGroup == null) {
//                this.userGradeId = this.grade.getUserGradeId();
//            } else {
//                if (CodeName.GROUP_DSCNT_CLASS_CODE_TYPE_B.equals(userGroup.getGroupDscntClassCode())) {
//                    if (userGroup.getApplyUserGradeId() != null) {
//                        if (userGroup.getApplyUserGradeId().compareTo(this.grade.getUserGradeId()) < 0) {
//                            this.userGradeId = userGroup.getApplyUserGradeId();
//                        } else {
//                            this.userGradeId = this.grade.getUserGradeId();
//                        }
//                    } else {
//                        this.userGradeId = this.grade.getUserGradeId();
//                    }
//                } else {
//                    this.userGradeId = this.grade.getUserGradeId();
//                    this.addDiscountRate = userGroup.getDscntRate();
//                    this.addSavedRate = userGroup.getSavedRate();
//                }
//            }
//        }
//    }
    public LoginUser(User user) {
    	this.user = user;
    }

    public LoginUser(int sessionHashKey) {
        this.sessionHashKey = sessionHashKey;
//        this.userGradeId = Config.getDefaultGroupId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public UserPassport getPassport() {
//        return passport;
//    }
//
//    public void setPassport(UserPassport passport) {
//        this.passport = passport;
//    }
//
//    public UserGrade getGrade() {
//        return grade;
//    }
//
//    public void setGrade(UserGrade grade) {
//        this.grade = grade;
//    }
//
//    public int getAddDiscountRate() {
//        return addDiscountRate;
//    }
//
//    public void setAddDiscountRate(int addDiscountRate) {
//        this.addDiscountRate = addDiscountRate;
//    }
//
//    public UserGroup getUserGroup() {
//        return userGroup;
//    }
//
//    public void setUserGroup(UserGroup userGroup) {
//        this.userGroup = userGroup;
//    }

    public String getUserGradeId() {
        return userGradeId;
    }

    public void setUserGradeId(String userGradeId) {
        this.userGradeId = userGradeId;
    }

//    public String getUserGroupId() {
//        return this.getUserGroup() == null ? null : this.getUserGroup().getUserGroupId();
//    }

    public String getLinkSiteGbnCode() {
        return linkSiteGbnCode;
    }

    public void setLinkSiteGbnCode(String linkSiteGbnCode) {
        this.linkSiteGbnCode = linkSiteGbnCode;
    }

    public int getSessionHashKey() {
        return sessionHashKey;
    }

    public void setSessionHashKey(int sessionHashKey) {
        this.sessionHashKey = sessionHashKey;
    }

//    public int getAddSavedRate() {
//        return addSavedRate;
//    }
//
//    public void setAddSavedRate(int addSavedRate) {
//        this.addSavedRate = addSavedRate;
//    }

    public String getGradeSmryWord() {
        return gradeSmryWord;
    }

    public void setGradeSmryWord(String gradeSmryWord) {
        this.gradeSmryWord = gradeSmryWord;
    }
}
