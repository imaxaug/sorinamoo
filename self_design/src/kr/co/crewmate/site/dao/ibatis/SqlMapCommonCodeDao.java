package kr.co.crewmate.site.dao.ibatis;

import java.util.List;

import kr.co.crewmate.site.dao.CommonCodeDao;
import kr.co.crewmate.site.dao.UserDao;
import kr.co.crewmate.site.model.CommonCode;
import kr.co.crewmate.site.model.ListResult;
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
public class SqlMapCommonCodeDao extends SqlMapClientDaoSupport implements CommonCodeDao {

	@Override
	public List<CommonCode> getCommonCode(CommonCode codeClass) {
		return super.getSqlMapClientTemplate().queryForList("CommonCodeSQL.getCommonCode", codeClass);
	}

}