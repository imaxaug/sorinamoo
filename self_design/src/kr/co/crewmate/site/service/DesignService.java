package kr.co.crewmate.site.service;

import java.util.List;

import kr.co.crewmate.site.model.Design;

/**
 *
 * 클래스명 : <code>UserService</code>
 *
 * @author 남세건
 * @date 2013. 5. 23.
 *
 */
public interface DesignService {

    List<Design> getDesignList(Design param);

}