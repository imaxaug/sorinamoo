package kr.co.crewmate.site.service.impl;

import java.util.List;

import javax.inject.Inject;

import kr.co.crewmate.site.dao.DesignDao;
import kr.co.crewmate.site.model.Design;
import kr.co.crewmate.site.service.DesignService;

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
public class DesignServiceImpl implements DesignService {

    final Log log = LogFactory.getLog(this.getClass());

    @Inject
    private DesignDao designDao;

	@Override
	public List<Design> getDesignList(Design param) {
		return this.designDao.getDesignList(param);
	}
}