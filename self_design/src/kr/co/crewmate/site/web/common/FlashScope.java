package kr.co.crewmate.site.web.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.crewmate.site.model.ToString;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 클래스명: <code>FlashScope</code>
 *
 * <pre>
 *  플래시스쿠프 모델
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 21.
 *
 */
@SuppressWarnings("serial")
public class FlashScope extends ToString implements Serializable {

    private ModelMap model;

    private static final String messageKey = "message";

    private final HttpSession session;

    private final String sessionKey;

    public HttpServletRequest getRequest(RequestAttributes requestAttributes) {
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    public FlashScope(String sessionKey) {
        HttpServletRequest request = this.getRequest(RequestContextHolder.currentRequestAttributes());
        this.session = request.getSession(true);
        this.sessionKey = sessionKey;
        this.model = (ModelMap) session.getAttribute(this.sessionKey);
        if (this.model == null) {
            this.model = new ModelMap();
            session.setAttribute(this.sessionKey, this.model);
        }
    }

    public void setMessage(String message) {
        this.model.put(messageKey, message);
    }

    public void move() {
        if (FlashScopeHandler.PREVIOUS_FLASH_SCOPE.equals(this.sessionKey)) {
            session.setAttribute(FlashScopeHandler.FLASH_SCOPE, this.model);
            session.removeAttribute(FlashScopeHandler.PREVIOUS_FLASH_SCOPE);
        } else {
            throw new IllegalStateException();
        }
    }

    public ModelMap addAllAttributes(Collection<?> attributeValues) {
        return model.addAllAttributes(attributeValues);
    }

    public ModelMap addAllAttributes(Map<String, ?> attributes) {
        return model.addAllAttributes(attributes);
    }

    public ModelMap addAttribute(Object attributeValue) {
        return model.addAttribute(attributeValue);
    }

    public ModelMap addAttribute(String attributeName, Object attributeValue) {
        return model.addAttribute(attributeName, attributeValue);
    }

    public void clear() {
        model.clear();
    }

    public boolean containsAttribute(String attributeName) {
        return model.containsAttribute(attributeName);
    }

    public boolean containsKey(Object key) {
        return model.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return model.containsValue(value);
    }

    public Set<Entry<String, Object>> entrySet() {
        return model.entrySet();
    }

    public Object get(Object key) {
        return model.get(key);
    }

    public boolean isEmpty() {
        return model.isEmpty();
    }

    public Set<String> keySet() {
        return model.keySet();
    }

    public ModelMap mergeAttributes(Map<String, ?> attributes) {
        return model.mergeAttributes(attributes);
    }

    public Object put(String key, Object value) {
        return model.put(key, value);
    }

    public void putAll(Map<? extends String, ? extends Object> m) {
        model.putAll(m);
    }

    public Object remove(Object key) {
        return model.remove(key);
    }

    public int size() {
        return model.size();
    }

    public Collection<Object> values() {
        return model.values();
    }

}
