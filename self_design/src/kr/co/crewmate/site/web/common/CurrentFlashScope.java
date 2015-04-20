package kr.co.crewmate.site.web.common;

import java.util.Collection;
import java.util.Map;

import org.springframework.ui.ModelMap;

/**
 * 클래스명: <code>CurrentFlashScope</code>
 *
 * <pre>
 *  플래시 스쿠프 
 *  3.1부터 스프링이 지원하지만 용도문제로 사용하지않는다.
 *  import가 있을때 스프링용은 문제가있다
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 21.
 *
 */
@SuppressWarnings("serial")
public class CurrentFlashScope extends FlashScope {

    public CurrentFlashScope(String sessionKey) {
        super(sessionKey);
    }

    public CurrentFlashScope() {
        super(FlashScopeHandler.FLASH_SCOPE);
    }

    @Override
    public ModelMap addAllAttributes(Collection<?> attributeValues) {
        throw new IllegalStateException();
    }

    @Override
    public ModelMap addAllAttributes(Map<String, ?> attributes) {
        throw new IllegalStateException();
    }

    @Override
    public ModelMap addAttribute(Object attributeValue) {
        throw new IllegalStateException();
    }

    @Override
    public ModelMap addAttribute(String attributeName, Object attributeValue) {
        throw new IllegalStateException();
    }

    @Override
    public void clear() {
        throw new IllegalStateException();
    }

    @Override
    public ModelMap mergeAttributes(Map<String, ?> attributes) {
        throw new IllegalStateException();
    }

    @Override
    public Object put(String key, Object value) {
        throw new IllegalStateException();
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> m) {
        throw new IllegalStateException();
    }

    @Override
    public Object remove(Object key) {
        throw new IllegalStateException();
    }
}