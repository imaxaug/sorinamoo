package kr.co.crewmate.site.model;

import java.util.List;

import kr.co.crewmate.site.utils.MessageHandler;

/**
 * 
 * 클래스명: <code>ValidateParam</code>
 *
 * <pre>
 * 파라미터 유효성 검증 인터페이스
 * </pre>
 *
 * @author newstar000
 * @date 2011. 11. 11.
 *
 */
public interface ValidateParam {
    /**
     * 파라미터 유효성 검증
     * @param messageHandler
     * @return
     */
    List<String> validate(MessageHandler messageHandler);
}
