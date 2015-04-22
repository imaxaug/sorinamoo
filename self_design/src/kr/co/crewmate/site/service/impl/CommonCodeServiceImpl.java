package kr.co.crewmate.site.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import kr.co.crewmate.site.dao.CommonCodeDao;
import kr.co.crewmate.site.dao.UserDao;
import kr.co.crewmate.site.model.CommonCode;
import kr.co.crewmate.site.model.ListResult;
import kr.co.crewmate.site.model.LoginUser;
import kr.co.crewmate.site.model.user.User;
import kr.co.crewmate.site.model.user.UserCriteria;
import kr.co.crewmate.site.model.user.UserLoginForm;
import kr.co.crewmate.site.model.user.UserLoginHistory;
import kr.co.crewmate.site.service.CommonCodeService;
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
public class CommonCodeServiceImpl implements CommonCodeService {

    final Log log = LogFactory.getLog(this.getClass());

    @Inject
    private CommonCodeDao commonCodeDao;

	@Override
	public List<CommonCode> getCommonCode(CommonCode codeClass) {
		return this.commonCodeDao.getCommonCode(codeClass);
	}
}