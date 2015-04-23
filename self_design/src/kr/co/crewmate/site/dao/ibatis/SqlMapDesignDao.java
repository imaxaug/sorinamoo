package kr.co.crewmate.site.dao.ibatis;

import java.util.List;

import kr.co.crewmate.site.dao.DesignDao;
import kr.co.crewmate.site.model.CommonCode;
import kr.co.crewmate.site.model.Design;

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
public class SqlMapDesignDao extends SqlMapClientDaoSupport implements DesignDao {

	@Override
	public List<Design> getDesignList(Design param) {
		return super.getSqlMapClientTemplate().queryForList("DesignSQL.getDesignList", param);
	}

}