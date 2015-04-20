package kr.co.crewmate.site.web.controller.frontOffice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import kr.co.crewmate.site.Constants;
import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.exceptions.UserNotFoundException;
import kr.co.crewmate.site.model.ListResult;
import kr.co.crewmate.site.model.LoginUser;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ParameterImpl;
import kr.co.crewmate.site.model.user.User;
import kr.co.crewmate.site.model.user.UserCriteria;
import kr.co.crewmate.site.model.user.UserLoginForm;
import kr.co.crewmate.site.model.user.UserLoginHistory;
import kr.co.crewmate.site.service.MessageService;
import kr.co.crewmate.site.service.UserService;
import kr.co.crewmate.site.utils.CookieUtils;
import kr.co.crewmate.site.utils.Encryption;
import kr.co.crewmate.site.utils.Utils;
import kr.co.crewmate.site.web.controller.FrontOfficeController;
import kr.co.crewmate.site.web.security.Access;
import kr.co.crewmate.site.web.taglib.PageHolder;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * 클래스명: <code>UserController</code>
 *
 * <pre>
 *  회원가입 담당 컨트롤러
 * </pre>
 *
 * @author 남세건
 * @date 2013. 6. 21.
 *
 */
@Controller("FrontUserController")
public class UserController extends FrontOfficeController {

    final Log log = LogFactory.getLog(this.getClass());

    /** 내국인 여부 */
    public final static String USER_LOCAL_YN = "userLocalYn";

    /** 외국인 인증 */
    public final static String FOREIGNER_AUTH = "foreignerAuth";

    /** KMC 인증 */
    public final static String KMC_AUTH = "kmcertAuth";

    /** 재가입 여부 */
    public final static String USER_RE_JOIN_YN = "userReJoinyn";

    /** 가입된 회원의 아이디 */
    public final static String JOIN_USER_ID = "joinUserId";

    /** IPIN 인증 */
    public final static String IPIN_AUTH = "ipinAuth";

    /** 이메일 주소 */
    public final static String JOIN_MAIL_ADDR = "joinMailAddr";

    /** 휴대폰 번호 */
    public final static String JOIN_HP_TEL_NUM = "joinHpTelNum";

    /** 외국인 가입시 인증코드 */
    public final static String FOREIGNER_AUTH_CODE = "foreignerAuthCode";

    /** 신세계 간편가입 */
    public final static String SINSEGAE_JOIN = "sinsegaeJoin";

    public final static String SINSEGAE_XML = "sinsegaeXml";

    /** 여권번호 여부 */
    public final static String PASSPORT_YN = "passportYn";


    private final String saveIdCookieKey = "SAVED_ID_KEY";

    /**
     * 쿠키저장일
     */
    private final int maxAge = 60 * 60 * 24 * 30; // 30일

    @Inject
    private MessageService messageService;

    @Inject
    private UserService userService;

//    @Inject
//    private OrderService orderService;


    /**
     * session 삭제
     */
    private void removeSession() {
        this.getSession().removeAttribute(USER_LOCAL_YN);
        this.getSession().removeAttribute(USER_RE_JOIN_YN);
        this.getSession().removeAttribute(JOIN_USER_ID);
        this.getSession().removeAttribute(FOREIGNER_AUTH);
        this.getSession().removeAttribute(KMC_AUTH);
        this.getSession().removeAttribute(IPIN_AUTH);
        this.getSession().removeAttribute(JOIN_MAIL_ADDR);
        this.getSession().removeAttribute(JOIN_HP_TEL_NUM);
        this.getSession().removeAttribute(SINSEGAE_JOIN);
        this.getSession().removeAttribute(PASSPORT_YN);
    }

    /**
     * 회원가입 폼
     * @param model
     * @return
     */
    @RequestMapping("/shop/join")
    public ModelAndView join(ModelMap model) {
        return new ModelAndView("frontoffice/join");
    }

    /**
     * 회원 가입 프로세스
     * 회원 인증 메일 발송, 가입 인증 메일 발송
     * @param model
     * @return
     */
    @RequestMapping("/shop/subscribe")
    public View subscribe(ModelMap model, HttpServletResponse response, User form) {
     	boolean save = true;
        List<Parameter> errorMessages = form.validate(this.messageService.getMessageHandler(), "create");

        if (!errorMessages.isEmpty()) {
            save = false;
        } else {
            try {
            	form.setUserId(form.getEmail());
                this.userService.saveUserForm(form);
                this.getSession().setAttribute(JOIN_USER_ID, form.getUserId());

            } catch (DataIntegrityViolationException e) {
                save = false;
                errorMessages.add(new ParameterImpl("top", this.messageService.getMessageHandler().getMessage("validate.already.exist", Utils.getParam("회원아이디"))));
            }
        }

    	model.addAttribute("save", save);
        model.addAttribute(this.errorMessageKey, errorMessages);
    	return new MappingJacksonJsonView();
    }

    /**
     * <pre>
     * 임시페이지 삭제예정
     * </pre>
     * @param model
     * @return
     */
    @Access
    @RequestMapping("/shop/loginArea")
    public ModelAndView loginArea(Model model) {
        String refererUrl = this.getRequest().getHeader("Referer");
        if (log.isDebugEnabled()) {
            log.debug(String.format("refererUrl=[%s]", refererUrl));
        }

        return new ModelAndView("frontoffice/login/loginArea");
    }

    /**
     * <pre>
     * 로그인 폼
     * </pre>
     * @param model
     * @param userLoginForm
     * @return
     */
    @RequestMapping("/shop/login")
    public ModelAndView login(ModelMap model, UserLoginForm userLoginForm) {

        if (StringUtils.isEmpty(userLoginForm.getUserId())) {
            String userId = CookieUtils.getCookie(saveIdCookieKey, this.getRequest());
            if (StringUtils.isNotEmpty(userId)) {
                userLoginForm.setUserId(userId);
                userLoginForm.setSaveId(true);
            }
        }

        model.addAttribute("userLoginForm", userLoginForm);
        return new ModelAndView("frontoffice/login");
    }


    /**
     * 로그인 팝업
     */
    @RequestMapping("/shop/login/loginPopupForm")
    public ModelAndView loginPopupForm(ModelMap model, UserLoginForm userLoginForm) {

        if (StringUtils.isEmpty(userLoginForm.getUserId())) {
            String userId = CookieUtils.getCookie(saveIdCookieKey, this.getRequest());
            if (StringUtils.isNotEmpty(userId)) {
                userLoginForm.setUserId(userId);
                userLoginForm.setSaveId(true);
            }
        }

        model.addAttribute("decorator", "popup");
        model.addAttribute("userLoginForm", userLoginForm);
        model.addAttribute("nonUserType", userLoginForm.getNonUserType());
        /*
        model.addAttribute("isLoginLock",false);
        model.addAttribute("isfailYn",false);
        model.addAttribute("failCnt",0);
        */
        return new ModelAndView("frontoffice/login/loginPopupForm");
    }


    /**
     * 비 회원 로그인 팝업
     */
    @RequestMapping("/shop/login/nonUserOrderLogin")
    public ModelAndView nonUserOrderLogin(ModelMap model, String returnUrl) {
        model.addAttribute("decorator", "popup");
        model.addAttribute("returnUrl", returnUrl);
        return new ModelAndView("frontoffice/login/nonUserOrderLogin");
    }

    /**
     * 비회원 로그인
     */
//    @RequestMapping("/shop/login/nonUserLogin")
//    public ModelAndView nonUserLogin(ModelMap model, NonUserLogin nonUserLogin, HttpServletResponse response) {
//        List<String> errorMessages = nonUserLogin.validate(this.messageService.getMessageHandler());
//        model.addAttribute("nonUserLogin", nonUserLogin);
//
//        if (errorMessages.isEmpty()) {
//            Order order = this.orderService.getOrderByNonUserLogin(nonUserLogin);
//            if (order == null) {
//                errorMessages.add(this.messageService.getMessageHandler().getMessage("validate.not.exist", Utils.getParam(nonUserLogin.getOrderNum(), "주문번호")));
//            } else {
//                this.removeUser(response);
//                super.saveOrder(order);
//            }
//        }
//
//        String returnUrl = "/";
//        if (errorMessages.isEmpty()) {
//            if (StringUtils.equals(nonUserLogin.getReturnUrl(),"myPage")) {
//                returnUrl = Config.getServerHost() + "/shop/mypage/nonUser";
//            }
//            return new ModelAndView(String.format("redirect:%s/shop/login/movePage?returnUrl=%s", Config.getServerHost(), Utils.encode(returnUrl)));
//        } else {
//            model.addAttribute(this.errorMessageKey, errorMessages.isEmpty() ? "" : errorMessages.get(0));
//            return new ModelAndView("forward:/shop/login/nonUserOrderLogin");
//        }
//    }

    /**
     * 팝업 로그인
     */
    @RequestMapping("/shop/login/loginPopup")
    public ModelAndView loginPopup(HttpServletResponse response, ModelMap model, UserLoginForm userLoginForm) {
        List<Parameter> errorMessages = userLoginForm.validate(this.messageService.getMessageHandler());
        model.addAttribute("userLoginForm", userLoginForm);

        String returnUrl = Config.getServerHost() + "/";
        if (errorMessages.isEmpty()) {
            @SuppressWarnings("unused")
            LoginUser loginUser = loginProcess(errorMessages, userLoginForm, response);

            if (errorMessages.isEmpty()) {
                returnUrl = String.format("%s", StringUtils.isEmpty(userLoginForm.getRedirectUrl()) ? Config.getServerHost() + "/" : (StringUtils.equals(userLoginForm.getNonUserType(), "order") ? Config.getServerHostForSSL()+"/shop/order/orderSheet" : userLoginForm.getRedirectUrl()));

                if(StringUtils.isEmpty(userLoginForm.getRedirectUrl())) {
                    returnUrl = Config.getServerHost() + "/";
                } else {
                    if(StringUtils.equals(userLoginForm.getNonUserType(), "order")) {
                        returnUrl = Config.getServerHostForSSL()+"/shop/order/orderSheet";
                    } else if(StringUtils.equals(userLoginForm.getNonUserType(), "myPage")) {
                        returnUrl = Config.getServerHostForSSL()+"/shop/mypage/main";
                        returnUrl = Config.getServerHost()+"/shop/mypage/main";
                    } else if(StringUtils.equals(userLoginForm.getNonUserType(), "wishList")) {
                        returnUrl = Config.getServerHost()+"/shop/mypage/wish/listWish";
                    }else {
                        returnUrl = userLoginForm.getRedirectUrl();
                    }
                }
            }
        }

        model.addAttribute(this.errorMessageKey, errorMessages.isEmpty() ? "" : errorMessages.get(0).getValue());

        if (false == errorMessages.isEmpty()) {//오류메세지가 있을시 다시 로그인 화면으로 이동
            return new ModelAndView("forward:/shop/login/loginPopupForm");
        } else {
            return new ModelAndView(String.format("redirect:%s/shop/login/movePage?returnUrl=%s", Config.getServerHost(), Utils.encode(returnUrl)));
        }
    }

    /**
     * 로그인 후 화면 전환
     * @param model
     * @param returnUrl
     * @return
     */
    @RequestMapping("/shop/login/movePage")
    public ModelAndView movePage(ModelMap model, String returnUrl) {
        String isCookie = CookieUtils.getCookie("introduceChinaSite", this.getRequest());
        model.addAttribute("returnUrl", returnUrl);
        model.addAttribute("isCookie", isCookie);
        return new ModelAndView("frontoffice/login/movePage");
    }

    /**
     * <pre>
     * 로그인
     * </pre>
     * @param response
     * @param model
     * @param userLoginForm
     * @return
     */
    @RequestMapping("/shop/process")
    public ModelAndView process(HttpServletResponse response, ModelMap model, UserLoginForm userLoginForm) {
        List<Parameter> errorMessages = userLoginForm.validate(this.messageService.getMessageHandler());
        model.addAttribute(this.errorMessageKey, errorMessages);
        model.addAttribute("userLoginForm", userLoginForm);

        String returnUrl = "forward:/shop/login";
        if (errorMessages.isEmpty()) {
            @SuppressWarnings("unused")
            LoginUser loginUser = loginProcess(errorMessages, userLoginForm, response);
            if (errorMessages.isEmpty()) {
                returnUrl = String.format("redirect:%s", StringUtils.isEmpty(userLoginForm.getRedirectUrl()) ? "/" : (StringUtils.equals(userLoginForm.getNonUserType(), "order") ? "/shop/order/orderSheet" : userLoginForm.getRedirectUrl()));
            }
        }

        return new ModelAndView(returnUrl);
    }

    /**
     * <pre>
     * 로그인 프로세스
     * </pre>
     * @param errorMessages
     * @param userLoginForm
     * @param response
     * @return
     */
    private LoginUser loginProcess(List<Parameter> errorMessages, UserLoginForm userLoginForm, HttpServletResponse response) {
        LoginUser loginUser = null;

        try {
            loginUser = this.userService.getUserById(userLoginForm.getUserId());

            if(loginUser.getUser() == null) {
            	errorMessages.add(new ParameterImpl("top", this.messageService.getMessageHandler().getMessage("validate.user.not.login")));
//            if (loginUser.getUser() == null || StringUtils.equals(loginUser.getUser().getLeaveStatCode(), CodeName.USER_LEAVE)) {
//                errorMessages.add(new ParameterImpl("top", this.messageService.getMessageHandler().getMessage("validate.user.not.login")));
//            } else if (false == loginUser.getUser().isNewPswdYn() && false == StringUtils.equals(loginUser.getUser().getPswd(), Encryption.password(userLoginForm.getPassword()))) {
//                errorMessages.add(new ParameterImpl("top", this.messageService.getMessageHandler().getMessage("validate.user.not.login")));
//            } else if (loginUser.getUser().isNewPswdYn() && StringUtils.equals(this.userService.getCompPswdYn(userLoginForm), "N")) {
//                errorMessages.add(new ParameterImpl("top", this.messageService.getMessageHandler().getMessage("validate.user.not.login")));
            } else {
                /**
                 * 쿠키처리
                 */
                saveCookieById(userLoginForm, response);
                super.saveUser(loginUser, response);
//                this.userService.moveToUserCart(this.getSession(), loginUser.getUser().getUserId(), true);
                try {
                	UserLoginHistory userLoginHistory = new UserLoginHistory();
                	userLoginHistory.setUserId(loginUser.getUser().getUserId());
                	userLoginHistory.setCntrIpAddr(this.getRequest().getRemoteHost());
                	this.userService.saveUserLoginHistory(userLoginHistory);
                } catch (Exception e) {
                	if (log.isErrorEnabled()) {
                		log.error("로그인 히스토리 저장하다가 실패", e);
                	}
                }
            }

            return loginUser;

        } catch (UserNotFoundException e) {
            if (log.isDebugEnabled()) {
                log.debug(String.format("%s[%s]", e.getMessage(), this.getRequest().getRemoteAddr()));
            }

            errorMessages.add(new ParameterImpl("top", this.messageService.getMessageHandler().getMessage("validate.user.not.login")));
        }

        return loginUser;
    }

    /**
     * <pre>
     * 쿠키처리로직
     * </pre>
     * @param userLoginForm
     * @param response
     */
    private void saveCookieById(UserLoginForm userLoginForm, HttpServletResponse response) {
        if (userLoginForm.isSaveId()) {
            CookieUtils.setCookie(this.saveIdCookieKey, userLoginForm.getUserId(), maxAge, response);
        } else {
            CookieUtils.expireCookie(this.saveIdCookieKey, this.getRequest(), response);
        }
    }

    @RequestMapping("/shop/logout")
    public ModelAndView logout(HttpServletResponse response) {
        LoginUser loginUser = this.getLoginUser();
        if (loginUser != null) {
            try {
                this.userService.logout(loginUser.getUser().getUserId());
            } catch (Exception e) {
                if (log.isErrorEnabled()) {
                    log.error("로그인 히스토리 저장하다가 실패", e);
                }
            }
        }
        this.removeUser(response);
        return new ModelAndView("redirect:/");
    }

    /**
     * <pre>
     * 비밀번호 체크 로직
     * </pre>
     */
    private boolean getPwdCheckYn(LoginUser loginUser, UserLoginForm userLoginForm){
        boolean isOk = true;
        if(loginUser.getUser().isNewPswdYn()){
            if(StringUtils.equals(this.userService.getCompPswdYn(userLoginForm), "N")){
                isOk = false;
            }
        } else {
            if(!StringUtils.equals(loginUser.getUser().getPswd(), Encryption.password(userLoginForm.getPassword()))){
                isOk = false;
            }
        }

        return isOk;
    }

}
