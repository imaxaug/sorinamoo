package kr.co.crewmate.site.service;

import java.util.List;

import kr.co.crewmate.site.model.Color;
import kr.co.crewmate.site.model.CommonCode;

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

    List<Color> getColorCode(String codeKey);

}