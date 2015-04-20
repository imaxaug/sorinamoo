package kr.co.crewmate.site.web.security;

import java.util.HashSet;
import java.util.Set;
import java.util.UnknownFormatConversionException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.crewmate.http.HttpRequestException;
import kr.co.crewmate.http.RequestSender;
import kr.co.crewmate.site.Constants;
import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.exceptions.UserNotFoundException;
import kr.co.crewmate.site.model.LoginUser;
import kr.co.crewmate.site.model.mobile.UAgentInfo;
import kr.co.crewmate.site.service.UserService;
import kr.co.crewmate.site.utils.CookieUtils;
import kr.co.crewmate.site.utils.Encryption;
import kr.co.crewmate.site.web.controller.FrontOfficeController;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

/**
 *
 * 클래스명: <code>FrontOfficeInterceptor</code>
 *
 * <pre>
 * </pre>
 *
 * @author 이경연
 * @date 2011. 12. 26.
 *
 */
public class FrontOfficeInterceptor extends BaseInterceptor {

    final Log log = LogFactory.getLog(this.getClass());

    @Inject
    private UserService userService;

//    @Inject
//    private UserGradeService userGradeService;

    /**
     * 메인 리다이랙트 유알엘은 UserAgent체크를 하지않는다.
     */
    @SuppressWarnings("serial")
    private Set<String> exceptUrls = new HashSet<String>() {
        {
            add("/shop/mainHtml");
            add("/");
        }
    };

//    @SuppressWarnings("serial")
//    private Set<String> allowIds = new HashSet<String>() {
//        {
//            add("SAKHU");
//            add("JOLDAN23");
//            add("JAY0421");
//            add("MINA3004");
//            add("PURESERAPH");
//
//            add("COMMI05");
//            add("SOKHU");
//            add("HYWON0718");
//            add("WORLDONLY23");
//            add("KJWW");
//            add("PINKMONG");
//            add("POWERWEB");
//
//        }
//    };

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

    	String servletUrl = request.getRequestURI();
        //시스템점검
    	if(Constants.SYSTEM_JOB){
	        if(!StringUtils.equals("/shop/parking", servletUrl) ){
	            throw new ModelAndViewDefiningException(new ModelAndView("redirect:/shop/parking"));
	        }
    	}
        //end 시스템점검

    	if(!Constants.BRAND_SHOP_USE_YN){
    		if(servletUrl.indexOf("/brandShop")>-1 ){
	            throw new ModelAndViewDefiningException(new ModelAndView("redirect:/shop/main"));
	        }
    	}else{
    		if(servletUrl.startsWith("/mac")){
    			throw new ModelAndViewDefiningException(new ModelAndView("redirect:/brandShop/mac/home"));
    		}
    		if(servletUrl.startsWith("/dior")){
    			throw new ModelAndViewDefiningException(new ModelAndView("redirect:/brandShop/dior/home"));
    		}
    	}


        UAgentInfo userAgent = new UAgentInfo(request);
        if (userAgent.detectMobileLong()
                || userAgent.detectSmartphone()
                || userAgent.detectTierIphone()
                || userAgent.detectAndroidWebKit()
                || userAgent.detectIos()) {
            if (exceptUrls.contains(request.getRequestURI())) {
            } else {
                String pcKey = (String) request.getSession().getAttribute(FrontOfficeController.SET_PC_KEY);
                if (StringUtils.equals("pc", pcKey)) {
                    request.setAttribute("userAgent", userAgent);
                } else {
                    String redirectUrl = Config.getMServerHost();
                    RequestSender sender = new RequestSender(redirectUrl);
                    /**
                     * 웹스피어가 무한루프 돌아서
                     */
                    try {
                        sender.send();
                        throw new ModelAndViewDefiningException(new ModelAndView(String.format("redirect:%s", redirectUrl)));
                    } catch (HttpRequestException e) {
                        return false;
                    }
                }
            }
        } else {
            request.setAttribute("userAgent", userAgent);
        }

        if(request.getRequestURI().indexOf("/brandShop") > -1){
            request.setAttribute("mid", request.getParameter("mid"));
        }

        super.saveVariable(request, response);
        if (handler instanceof HandlerMethod) {
            super.escapeParameter(request);
            flashScopeProcess();
            resetSession(request, response, (HandlerMethod)handler);
            boolean acceptable = checkUserLogin(request, response, (HandlerMethod)handler);
            if (false == acceptable) {
                throw new ModelAndViewDefiningException(new ModelAndView("redirect:/shop/main"));
            }

            boolean nonUserAcceptable = nonUserCheckLogin(request, response, (HandlerMethod)handler);
            if (false == nonUserAcceptable) {
                throw new ModelAndViewDefiningException(new ModelAndView("redirect:/shop/main"));
            }
        }

        return true;
    }

    private boolean checkUserLogin(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) {
        Access access = handler.getMethod().getAnnotation(Access.class);
        boolean acceptable = false;
        if (access == null) {
            acceptable = true;
        } else {
            Object object = handler.getBean();
            if (object instanceof FrontOfficeController) {
                FrontOfficeController controller = (FrontOfficeController) object;
//                LoginUser user = controller.getLoginUser();
//                if (user != null) {
//                    acceptable = true;
//                }
            }
        }

        return acceptable;
    }

    private void resetSession(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) {
        String encryptId = CookieUtils.getCookie(FrontOfficeController.USER_COOKIE_KEY, request);
        request.setAttribute("isLogin", new Boolean(false));
        if (encryptId != null) {
            String id = Encryption.decode(encryptId);

            Object controller = handler.getBean();
            if (false == controller instanceof FrontOfficeController) {
                if (log.isDebugEnabled()) {
                    log.debug("Not FrontOfficeController:" + controller);
                }
            } else {
                try {
                    loadUserVariable(request, (FrontOfficeController)controller, id);
                } catch (UnknownFormatConversionException e) {
                    CookieUtils.expireCookie(FrontOfficeController.USER_COOKIE_KEY, request, response);
                } catch (UserNotFoundException e) {
                    CookieUtils.expireCookie(FrontOfficeController.USER_COOKIE_KEY, request, response);
                    if (log.isErrorEnabled()) {
                        log.error(e.getMessage());
                    }
                }
            }
        }
    }

    private void loadUserVariable(HttpServletRequest request, FrontOfficeController handler, String id) {
        LoginUser user = handler.getLoginUser();

        // TODO 쿠키가 존재하면 쿠키의 아이디로 자동 로그인이 됨.
        if (user == null) {
        	//TODO 쿠키로 저장된 아이디를 조회만 하지 않으면 세션만으로 로그인 여부를 알 수 있슴.
//            user = this.userService.getUserById(id);
            if (user == null) {
                throw new UserNotFoundException(String.format("[%id]에 해당하는 유저가 존재하지않음", id));
//            } else {
//                user.setGradeSmryWord(this.userGradeService.getUserGradeByUserGradeId(user.getUserGradeId()).getGradeSmryWord());
//                handler.saveUser(user);
            }
        }

        request.setAttribute("isLogin", user == null ? new Boolean(false) : new Boolean(true));
//        System.out.println(">>>>>>>isLogin:" + user == null ? new Boolean(false) : new Boolean(true));
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA" + user == null ? "false" : "true");
        request.setAttribute("loginUser", handler.getLoginUser());
    }

    /**
     * 비회원 로그인 체크
     */
    private boolean nonUserCheckLogin(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) {
        NonUserAccess access = handler.getMethod().getAnnotation(NonUserAccess.class);
        boolean acceptable = false;
        if (access == null) {
            acceptable = true;
        } else {
            Object object = handler.getBean();
            if (object instanceof FrontOfficeController) {
                FrontOfficeController controller = (FrontOfficeController) object;
//                Order order = controller.getOrder();
//                if (order != null) {
//                    acceptable = true;
//                    request.setAttribute("nonUserAcceptable", Boolean.TRUE);
//                }
            }
        }

        return acceptable;
    }
}
