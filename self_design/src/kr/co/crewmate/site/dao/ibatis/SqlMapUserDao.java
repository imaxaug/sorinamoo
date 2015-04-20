package kr.co.crewmate.site.dao.ibatis;

import java.util.List;

import kr.co.crewmate.site.dao.UserDao;
import kr.co.crewmate.site.model.user.User;
import kr.co.crewmate.site.model.user.UserCriteria;
import kr.co.crewmate.site.model.user.UserLoginForm;
import kr.co.crewmate.site.model.user.UserLoginHistory;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * 클래스명 : <code>SqlMapUserDao</code>
 *
 * @author 남세건
 * @date 2013. 5. 23.
 *
 */
@Repository
public class SqlMapUserDao extends SqlMapClientDaoSupport implements UserDao {

    /** 회원리스트 START */

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUserList(UserCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("UserSQL.getUserList" , criteria , criteria.getFetchScale() , criteria.getListSize());
    }

    @Override
    public User getUserInfoDetail(String userId) {
        return (User) super.getSqlMapClientTemplate().queryForObject("UserSQL.getUserInfo", userId);
    }

	@Override
	public void logout(String userId) {
        super.getSqlMapClientTemplate().update("UserSQL.logout", userId);
	}

	@Override
	public String getCompPswdYn(UserLoginForm userLoginForm) {
        return (String) super.getSqlMapClientTemplate().queryForObject("UserSQL.getCompPswdYn", userLoginForm);
	}

	@Override
	public void saveUserLoginHistory(UserLoginHistory userLoginHistory) {
        this.getSqlMapClientTemplate().insert("UserSQL.saveUserLoginHistory", userLoginHistory);
	}

	@Override
	public void saveUserForm(User user) {
		this.getSqlMapClientTemplate().insert("UserSQL.saveUserForm", user);
	}
}