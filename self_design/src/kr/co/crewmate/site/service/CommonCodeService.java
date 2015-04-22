package kr.co.crewmate.site.service;

import java.util.List;

import kr.co.crewmate.site.model.CommonCode;
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
public interface CommonCodeService {

    List<CommonCode> getCommonCode(CommonCode codeClass);

}