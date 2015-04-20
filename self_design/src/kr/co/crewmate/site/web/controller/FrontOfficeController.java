package kr.co.crewmate.site.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.crewmate.site.Constants;
import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.LoginUser;
import kr.co.crewmate.site.model.Order;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ParameterImpl;
//import kr.co.crewmate.site.model.order.Order;
import kr.co.crewmate.site.service.UserService;
import kr.co.crewmate.site.utils.CookieUtils;
import kr.co.crewmate.site.utils.Encryption;


/**
 * 클래스명: <code>FrontOfficeController</code>
 *
 * <pre>
 *  백오피스 컨트롤러
 *  모든 백오피스 컨트롤러는 해당컨트롤러의 상속을 받는다.
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 21.
 *
 */
public class FrontOfficeController extends BaseController {

    /**
     * 관리자 세션키
     */
    public final static String USER_SESSION_KEY = "userSessionKey";

    /**
     * 회원 쿠키키
     */
    public final static String USER_COOKIE_KEY = "memberCookieKey";

    /**
     * 비회원 주문 정보
     */
    public final static String NON_USER_ORDER_KEY = "nonUserOrderKey";

    /**
     * PC보기용 세션키
     */
    public final static String SET_PC_KEY = "setPcKey";

    /**
     * 공통 리스트스케일
     */
    @SuppressWarnings("serial")
    private final List<Parameter> listScales = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("20", "20개 보기"));
            add(new ParameterImpl("40", "40개 보기"));
            add(new ParameterImpl("60", "60개 보기"));
            add(new ParameterImpl("100", "100개 보기"));
            add(new ParameterImpl("200", "200개 보기"));
        }
    };

    /**
     * 공통 년도
     * 현재 년도 -100년 ~ 현재년
     */
    @SuppressWarnings("serial")
    private final List<Parameter> birthYears = new ArrayList<Parameter>(13) {
        {
            int nowYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
            for (int i = -100; i <= 0; i++) {
                String v = String.format("%d", nowYear+i);
                add(new ParameterImpl(v, v));
            }
        }
    };

    /**
     * 공통 년도
     * 현재 년도 -2년 ~ +10년
     */
    @SuppressWarnings("serial")
    private final List<Parameter> years = new ArrayList<Parameter>(13) {
        {
            int nowYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
            for (int i = -2; i <= 10; i++) {
                String v = String.format("%d", nowYear+i);
                add(new ParameterImpl(v, v + "년"));
            }
        }
    };

    /**
     * 공통 월
     */
    @SuppressWarnings("serial")
    private final List<Parameter> months = new ArrayList<Parameter>(12) {
        {
            for (int i = 1; i <= 12; i++) {
                String v = String.format("%02d", i);
                add(new ParameterImpl(v, v + "월"));
            }
        }
    };

    /**
     * 공통 일
     */
    @SuppressWarnings("serial")
    private final List<Parameter> days = new ArrayList<Parameter>(31) {
        {
            for (int i = 1; i <= 31; i++) {
                String v = String.format("%02d", i);
                add(new ParameterImpl(v, v + "일"));
            }
        }
    };

    /**
     * 공통 년도
     * 현재 년도 ~ +10년
     */
    @SuppressWarnings("serial")
    private final List<Parameter> yearN = new ArrayList<Parameter>(13) {
        {
            int nowYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
            for (int i = 0; i <= 10; i++) {
                String v = String.format("%d", nowYear+i);
                add(new ParameterImpl(v, v));
            }
        }
    };

    /**
     * 공통 월
     */
    @SuppressWarnings("serial")
    private final List<Parameter> monthN = new ArrayList<Parameter>(12) {
        {
            for (int i = 1; i <= 12; i++) {
                String v = String.format("%02d", i);
                add(new ParameterImpl(v, v));
            }
        }
    };

    /**
     * 공통 일
     */
    @SuppressWarnings("serial")
    private final List<Parameter> dayN = new ArrayList<Parameter>(31) {
        {
            for (int i = 1; i <= 31; i++) {
                String v = String.format("%02d", i);
                add(new ParameterImpl(v, v));
            }
        }
    };

    /**
     * 공통 시간
     */
    @SuppressWarnings("serial")
    private final List<Parameter> hours = new ArrayList<Parameter>(24) {
        {
            for (int i = 0; i < 24; i++) {
                String v = String.format("%02d", i);
                add(new ParameterImpl(v, v + "시"));
            }
        }
    };

    /**
     * 공통 분(10분)
     */
    @SuppressWarnings("serial")
    private final List<Parameter> minute = new ArrayList<Parameter>(60) {
        {
            for (int m = 0; m < 60; m += 10) {
                String s = String.format("%02d", m);
                add(new ParameterImpl(s, s + "분"));
            }
        }
    };

    /**
     * 공통 시간
     */
    @SuppressWarnings("serial")
    private final List<Parameter> hourN = new ArrayList<Parameter>(24) {
        {
            for (int i = 0; i < 24; i++) {
                String v = String.format("%02d", i);
                add(new ParameterImpl(v, v));
            }
        }
    };

    /**
     * 공통 분(10분)
     */
    @SuppressWarnings("serial")
    private final List<Parameter> minuteN = new ArrayList<Parameter>(60) {
        {
            for (int m = 0; m < 60; m += 10) {
                String s = String.format("%02d", m);
                add(new ParameterImpl(s, s));
            }
        }
    };

    /**
     * 공통 분(1분)
     */
    @SuppressWarnings("serial")
    private final List<Parameter> minuteLittle = new ArrayList<Parameter>(60) {
        {
            for (int m = 0; m < 60; m++) {
                String s = String.format("%02d", m);
                add(new ParameterImpl(s, s + "분"));
            }
        }
    };

    /**
     * 공통 분(5분)
     */
    @SuppressWarnings("serial")
    private final List<Parameter> minuteFive = new ArrayList<Parameter>() {
        {
            for (int m = 0; m <60; m += 5) {
                String s = String.format("%02d", m);
                add(new ParameterImpl(s, s + "분"));
            }
        }
    };

    /**
     * 공통 분(5분)
     */
    @SuppressWarnings("serial")
    private final List<Parameter> minuteFiveN = new ArrayList<Parameter>() {
        {
            for (int m = 0; m <60; m += 5) {
                String s = String.format("%02d", m);
                add(new ParameterImpl(s, s));
            }
        }
    };

    /**
     * 브랜드 - 국문초성
     */
    @SuppressWarnings("serial")
    private final List<Parameter> korIntl = new ArrayList<Parameter>(15) {
        {
            add(new ParameterImpl("","=선택="));
            add(new ParameterImpl("ㄱ", "ㄱ"));
            add(new ParameterImpl("ㄴ", "ㄴ"));
            add(new ParameterImpl("ㄷ", "ㄷ"));
            add(new ParameterImpl("ㄹ", "ㄹ"));
            add(new ParameterImpl("ㅁ", "ㅁ"));
            add(new ParameterImpl("ㅂ", "ㅂ"));
            add(new ParameterImpl("ㅅ", "ㅅ"));
            add(new ParameterImpl("ㅇ", "ㅇ"));
            add(new ParameterImpl("ㅈ", "ㅈ"));
            add(new ParameterImpl("ㅊ", "ㅊ"));
            add(new ParameterImpl("ㅋ", "ㅋ"));
            add(new ParameterImpl("ㅌ", "ㅌ"));
            add(new ParameterImpl("ㅍ", "ㅍ"));
            add(new ParameterImpl("ㅎ", "ㅎ"));
        }
    };

    /**
     * 브랜드 - 영문초성
     */
    @SuppressWarnings("serial")
    private final List<Parameter> engIntl = new ArrayList<Parameter>(27) {
        {
            add(new ParameterImpl("","=선택="));
            add(new ParameterImpl("A", "A"));
            add(new ParameterImpl("B", "B"));
            add(new ParameterImpl("C", "C"));
            add(new ParameterImpl("D", "D"));
            add(new ParameterImpl("E", "E"));
            add(new ParameterImpl("F", "F"));
            add(new ParameterImpl("G", "G"));
            add(new ParameterImpl("H", "H"));
            add(new ParameterImpl("I", "I"));
            add(new ParameterImpl("J", "J"));
            add(new ParameterImpl("K", "K"));
            add(new ParameterImpl("L", "L"));
            add(new ParameterImpl("M", "M"));
            add(new ParameterImpl("N", "N"));
            add(new ParameterImpl("O", "O"));
            add(new ParameterImpl("P", "P"));
            add(new ParameterImpl("Q", "Q"));
            add(new ParameterImpl("R", "R"));
            add(new ParameterImpl("S", "S"));
            add(new ParameterImpl("T", "T"));
            add(new ParameterImpl("U", "U"));
            add(new ParameterImpl("V", "V"));
            add(new ParameterImpl("W", "W"));
            add(new ParameterImpl("X", "X"));
            add(new ParameterImpl("Y", "Y"));
            add(new ParameterImpl("Z", "Z"));
        }
    };

    public List<Parameter> getMinuteFive() {
        return minuteFive;
    }

    public List<Parameter> getBirthYears() {
        return birthYears;
    }
    public List<Parameter> getYears() {
        return years;
    }

    public List<Parameter> getMonths() {
        return months;
    }

    public List<Parameter> getDays() {
        return days;
    }

    public List<Parameter> getYearN() {
        return yearN;
    }

    public List<Parameter> getMonthN() {
        return monthN;
    }

    public List<Parameter> getDayN() {
        return dayN;
    }

    public List<Parameter> getListScales() {
        return listScales;
    }

    public List<Parameter> getHours() {
        return hours;
    }

    public List<Parameter> getMinute() {
        return minute;
    }

    public List<Parameter> getHourN() {
        return hourN;
    }

    public List<Parameter> getMinuteN() {
        return minuteN;
    }

    public List<Parameter> getMinuteLittle() {
        return minuteLittle;
    }

    public List<Parameter> getKorIntl() {
        return korIntl;
    }
    public List<Parameter> getEngIntl() {
        return engIntl;
    }

    public void saveUser(LoginUser loginUser, HttpServletResponse response) {
        HttpServletRequest request = this.getRequest();
        HttpSession session = request.getSession();
//        session.removeAttribute(Constants.ORDER_SESSION_ID);
        session.setAttribute(USER_SESSION_KEY, loginUser);
        CookieUtils.setCookie(USER_COOKIE_KEY, Encryption.encode(loginUser.getUser().getUserId()), response);
    }

    /**
     * <pre>
     * 관리자정보를 세션에 저장
     * </pre>
     * @param admin
     */
    public void saveUser(LoginUser loginUser) {
        HttpServletRequest request = this.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(USER_SESSION_KEY, loginUser);
    }

    public void removeUser(HttpServletResponse response) {
        HttpSession session = this.getSession();
        session.removeAttribute(USER_SESSION_KEY);
        session.removeAttribute(NON_USER_ORDER_KEY);
        CookieUtils.expireCookie(USER_COOKIE_KEY, this.getRequest(), response);
    }

    /**
     * <pre>
     * 회원정보를 가져온다.
     * </pre>
     * @return
     */
    public LoginUser getLoginUser() {
        HttpServletRequest request = this.getRequest();
        return getLoginUser(request);
    }

    /**
     * <pre>
     * 회원정보를 가져온다.
     * </pre>
     * @param request
     * @return
     */
    public LoginUser getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (LoginUser) session.getAttribute(USER_SESSION_KEY);
    }

    /**
     * <pre>
     * 회원정보를 리셋한다.
     * </pre>
     * @param userService
     * @param userId
     */
    public void resetUser(UserService userService) {
        LoginUser asis = this.getLoginUser();
        LoginUser loginUser = userService.getUserById(asis.getUser().getUserId());
        loginUser.setLinkSiteGbnCode(this.getLinkSiteGbnCode());
        HttpSession session = this.getSession();
        session.removeAttribute(USER_SESSION_KEY);
        session.setAttribute(USER_SESSION_KEY, loginUser);
    }

    public String getLinkSiteGbnCode() {
        return "01";
    }

    public String getDefaultGradeId() {
        return Config.getDefaultGroupId();
    }


    /**
     * 비회원 로그인
     */
    public void saveOrder(Order order){
        HttpServletRequest request = this.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(NON_USER_ORDER_KEY, order);
    }

    public Order getOrder() {
        HttpServletRequest request = this.getRequest();
        return getOrder(request);
    }

    public Order getOrder(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Order)session.getAttribute(NON_USER_ORDER_KEY);
    }

    public List<Parameter> getMinuteFiveN() {
        return minuteFiveN;
    }

    public String getOrderId() {
        return getOrderId(this.getSession());
    }

    public String getOrderId(HttpSession session) {
        Object o = this.getSession().getAttribute(Constants.ORDER_SESSION_ID);
        return o != null ? o.toString() : null;
    }

}
