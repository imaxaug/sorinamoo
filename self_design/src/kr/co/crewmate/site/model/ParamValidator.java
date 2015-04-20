package kr.co.crewmate.site.model;

import java.util.List;

import org.springframework.context.support.MessageSourceAccessor;

/**
 * 클래스명: <code>ParamValidator</code>
 *
 * <pre>
 *  ParamValidator
 * </pre>
 *
 * @author 이경연
 * @date 2013. 5. 11.
 *
 */
@Deprecated
public interface ParamValidator {
    List<Parameter> validate(MessageSourceAccessor messageSourceAccessor);
}
