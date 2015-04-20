package kr.co.crewmate.site.model;

import java.util.List;

import kr.co.crewmate.site.utils.MessageHandler;

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
public interface MessageValidator {
    List<Parameter> validate(MessageHandler messageHandler);
}
