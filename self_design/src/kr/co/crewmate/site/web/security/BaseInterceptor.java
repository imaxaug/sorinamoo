package kr.co.crewmate.site.web.security;

import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.crewmate.site.Constants;
import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.web.common.FlashScopeHandler;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * 클래스명: <code>BaseInterceptor</code>
 *
 * <pre>
 *  기본인터셉터
 *  인터셉터의 공통영역을 가지고있다
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 21.
 *
 */
public abstract class BaseInterceptor extends HandlerInterceptorAdapter {

    final Log log = LogFactory.getLog(this.getClass());
    
    private final String matchPattern = "\\<\\/?([s,S][c,C][r,R][i,I][p,P][t,T][^>]*)\\>";
    
    private final Pattern pattern = Pattern.compile(matchPattern);

    /**
     * 스크립트 escape
     * @param request
     * @throws IOException
     */
    public void escapeParameter(HttpServletRequest request) throws IOException {
        Enumeration<?> em = request.getParameterNames();
        while (em.hasMoreElements()) {
            Object o = em.nextElement();
            String[] values = request.getParameterValues(o.toString());
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    Matcher matcher = pattern.matcher(values[i]);

                    while (matcher.find()) {
                        if (log.isErrorEnabled()) {
                            log.error(String.format("Xss시도 발견=%s", request.getRemoteAddr()));
                        }
                        
                        throw new RuntimeException("잘못된 접근입니다.");
                    }
                }
            }
        }
    }

    public void flashScopeProcess() {
        FlashScopeHandler.move();
    }

    public void saveVariable(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("requestMapping", request.getRequestURI());
        request.setAttribute("imageServer", Config.getImageServerHost());
        request.setAttribute("uploadServer", Config.getUploadServerHost());
        request.setAttribute("serverHost", Config.getServerHost());
        request.setAttribute("serverHostForSSL", Config.getServerHostForSSL());
        request.setAttribute("netAddress", Config.getString("server.ip", "public"));
        request.setAttribute("onlyServerHost", Config.getOnlyServerHost());
        
        HttpSession session = request.getSession();
        if(request.getRequestURI().indexOf("/shop/store") > -1){
        	String langCode = request.getParameter("langCode");
        	if(StringUtils.isNotEmpty(langCode) && (StringUtils.equalsIgnoreCase(langCode, "KR") || StringUtils.equalsIgnoreCase(langCode, "CN")
        			|| StringUtils.equalsIgnoreCase(langCode, "EN") || StringUtils.equalsIgnoreCase(langCode, "JP"))){
                LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
                localeResolver.setLocale(request, response, org.springframework.util.StringUtils.parseLocaleString(langCode));

                request.getSession().setAttribute(Constants.LOCALE_SESSION_STORE_KEY, langCode);
        	}else{
        		if (session.getAttribute(Constants.LOCALE_SESSION_STORE_KEY) == null) {
        			LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        			localeResolver.setLocale(request, response, org.springframework.util.StringUtils.parseLocaleString(Config.getSiteNatnCode()));
        			
        			request.getSession().setAttribute(Constants.LOCALE_SESSION_STORE_KEY, Config.getSiteNatnCode());
        		} 
        	}
        }
        
        
        
        if (session.getAttribute(Constants.LOCALE_SESSION_KEY) == null) {
            request.getSession().setAttribute(Constants.LOCALE_SESSION_KEY, Config.getSiteNatnCode());
        }
    }
}
