package kr.co.crewmate.site.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import kr.co.crewmate.site.dao.UserDao;
import kr.co.crewmate.site.model.ListResult;
import kr.co.crewmate.site.model.LoginUser;
import kr.co.crewmate.site.model.user.User;
import kr.co.crewmate.site.model.user.UserCriteria;
import kr.co.crewmate.site.model.user.UserLoginForm;
import kr.co.crewmate.site.model.user.UserLoginHistory;
import kr.co.crewmate.site.service.UserService;

import org.springframework.stereotype.Service;

import com.ibatis.common.logging.Log;
import com.ibatis.common.logging.LogFactory;

/**
 *
 * 클래스명 : <code>UserSeviceImpl</code>
 *
 * @author 남세건
 * @date 2013. 5. 22.
 *
 */
@Service
public class UserServiceImpl implements UserService {

    final Log log = LogFactory.getLog(this.getClass());

    @Inject
    private UserDao userDao;

    private final Map<String, User> ssgdfsMap = new HashMap<String, User>();
    /** 회원리스트 START */

    /**
     * 회원 리스트
     */
    @Override
    public ListResult<User> getUserList(UserCriteria criteria) {
        ListResult<User> listResult = new ListResult<User>();
        listResult.setList(this.userDao.getUserList(criteria));
//        listResult.setListCount(this.userDao.getUserListCount(criteria));
        return listResult;
    }

	@Override
	public LoginUser getUserById(String userId) {
        User user = this.userDao.getUserInfoDetail(userId);
//        if (user == null) {
//            throw new UserNotFoundException(this.messageService.getMessageHandler().getMessage("validate.not.exist", Utils.getParam(userId, "회원")));
//        }
//
//        UserPassport passport = this.getUserPsprt(userId);
//        UserGrade grade = this.userGradeService.getUserGradeByUserGradeId(user.getUserGradeId());
//        UserGroup userGroup = this.getStandardUserGroupByUserId(userId);
//
//        return new LoginUser(user, passport, grade, userGroup);
        return new LoginUser(user);
	}

	@Override
	public void logout(String userId) {
        this.userDao.logout(userId);
	}

	@Override
	public String getCompPswdYn(UserLoginForm userLoginForm) {
        return this.userDao.getCompPswdYn(userLoginForm);
	}

	@Override
	public void saveUserLoginHistory(UserLoginHistory userLoginHistory) {
        this.userDao.saveUserLoginHistory(userLoginHistory);
	}

	@Override
	public void saveUserForm(User user) {
		this.userDao.saveUserForm(user);
	}
}