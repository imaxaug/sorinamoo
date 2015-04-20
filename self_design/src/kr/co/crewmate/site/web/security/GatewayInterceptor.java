package kr.co.crewmate.site.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.crewmate.site.model.mobile.UAgentInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * 클래스명: <code>GatewayInterceptor</code>
 *
 * <pre>
 * </pre>
 *
 * @author 이경연
 * @date 2011. 12. 26.
 *
 */
public class GatewayInterceptor extends BaseInterceptor {
    
    final Log log = LogFactory.getLog(this.getClass()); 
 
    /**
     * <pre>
     *  시스템이 시작전에 체크하는부분
     * </pre>
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UAgentInfo userAgent = new UAgentInfo(request);
        request.setAttribute("userAgent", userAgent);
        super.saveVariable(request, response);
        return true;
    }
}
