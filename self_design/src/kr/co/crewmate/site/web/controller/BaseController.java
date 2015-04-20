package kr.co.crewmate.site.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.crewmate.site.Constants;
import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.web.common.FlashScope;
import kr.co.crewmate.site.web.common.FlashScopeHandler;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 *
 * 클래스명: <code>BaseController</code>
 * <pre>
 * 기본컨트롤러
 * 모든 컨트롤러의 베이스컨트롤러가 된다.
 * 
 * Request/Session/Flash/Site 의 기본정보를 관장한다.
 * </pre>
 *
 * @date 2010. 8. 19.
 * @author 이경연
 *
 */
public class BaseController {

    protected final String errorMessageKey = Constants.ERROR_MESSAGE;
    
    public HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    public HttpSession getSession() {
        return this.getRequest().getSession();
    }
    
    public FlashScope getFlash() {
        return FlashScopeHandler.getFlash();
    }

//    public FlashMap getFlash() {
//        return RequestContextUtils.getOutputFlashMap(this.getRequest());
//    }
    
    public String getSiteNatnCode() {
        return Config.getSiteNatnCode();
    }
    
    public String getLangCode() {
        return Config.getLangCode();
    }
    
    public String getLocaleCode() {
        return (String) this.getSession().getAttribute(Constants.LOCALE_SESSION_KEY);
    }
}
