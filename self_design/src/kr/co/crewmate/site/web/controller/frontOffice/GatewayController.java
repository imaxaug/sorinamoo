package kr.co.crewmate.site.web.controller.frontOffice;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.mobile.UAgentInfo;
//import kr.co.crewmate.site.service.MessageService;
import kr.co.crewmate.site.service.UserService;
import kr.co.crewmate.site.utils.UserAgentUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 클래스명: <code></code>
 *
 * <pre>
 *  설명을 기입하세요
 * </pre>
 *
 * @author smuft76
 * @date 2013. 11. 12.
 *
 */
@Controller
public class GatewayController {

    final Log log = LogFactory.getLog(this.getClass());

    @Inject
    private UserService userService;

    public HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    /**
     * <pre>
     * 이벤트 상세
     * </pre>
     * @param model
     * @param eventId
     * @return
     */
    @RequestMapping("/gw/findEvent")
    public ModelAndView findEvent(Model model, String eventId) {
        String host = null;
        if (UserAgentUtils.isMobile(this.getRequest())) {
            host = String.format("%s/shop/promotion/event?eventId=%s", Config.getMServerHost(), eventId);
        } else {
            host = String.format("%s/shop/promotion/goDetailEventById?eventId=%s", Config.getWWWServerHost(), eventId);
        }

        return new ModelAndView(String.format("redirect:%s", host));
    }

    private String findValidHost() {
        String host = Config.getWWWServerHost();
        UAgentInfo userAgent = (UAgentInfo) this.getRequest().getAttribute("userAgent");
        if (userAgent != null) {
            if (UserAgentUtils.isMobile(userAgent)) {
                host = Config.getMServerHost();
            }
        }

        return host;
    }
}
