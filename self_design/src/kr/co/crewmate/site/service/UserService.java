package kr.co.crewmate.site.service;

import kr.co.crewmate.site.model.ListResult;
import kr.co.crewmate.site.model.LoginUser;
import kr.co.crewmate.site.model.user.User;
import kr.co.crewmate.site.model.user.UserCriteria;
import kr.co.crewmate.site.model.user.UserLoginForm;
import kr.co.crewmate.site.model.user.UserLoginHistory;

/**
 *
 * 클래스명 : <code>UserService</code>
 *
 * @author 남세건
 * @date 2013. 5. 23.
 *
 */
public interface UserService {

    /** 회원리스트 START */
    ListResult<User> getUserList(UserCriteria criteria);

    LoginUser getUserById(String userId);

    void logout(String userId);

    String getCompPswdYn(UserLoginForm userLoginForm);

    void saveUserLoginHistory(UserLoginHistory userLoginHistory);

    void saveUserForm(User user);
}