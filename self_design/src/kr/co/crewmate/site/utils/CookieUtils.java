package kr.co.crewmate.site.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.crewmate.site.config.Config;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * 클래스명: <code>CookieUtils</code>
 *
 * <pre>
 *  쿠키를 처리하는 유틸
 * </pre>
 *
 * @date 2010. 8. 24.
 * @author 이경연
 *
 */
public class CookieUtils {

    /**
     * 쿠키도메인범위
     */
//    public static String domainName = Config.getString("cookie.domain", ".crewmate.co.kr");
    public static String domainName = Config.getString("cookie.domain", ".happymarket.co.kr");

    /**
     * 쿠키생성도우미
     *
     * @param name
     * @param value
     * @param maxAge
     * @param response
     */
    public static void setCookie(String name, String value, int maxAge, HttpServletResponse response) {
        if (value != null) {
            String path = "/";
            Cookie cookie;

            try {
                cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                cookie = new Cookie(name, value);
            }

            cookie.setPath(path);
//            cookie.setDomain(domainName);//TODO 도메인이 생기면 도메인으로 setting
            cookie.setMaxAge(maxAge);
            response.addCookie(cookie);
        }
    }

    /**
     * 쿠키생성도우미
     *
     * @param name
     * @param value
     * @param response
     */
    public static void setCookie(String name, String value, javax.servlet.http.HttpServletResponse response) {
        setCookie(name, value, -1, response);
    }

    /**
     * 키값에 해당하는 쿠키
     *
     * @param name
     * @param request
     * @return
     */
    public static String getCookie(String name, javax.servlet.http.HttpServletRequest request) {
        String value = null;
        Cookie cookies[] = request.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];

                if (cookie.getName().equals(name)) {
                    try {
                        value = URLDecoder.decode(cookie.getValue(), "MS949");
                    } catch (UnsupportedEncodingException e) {
                        value = cookie.getValue();
                    }

                    break;
                }
            }
        }

        return value;
    }

    /**
     * 쿠키전부삭제
     *
     * @param request
     * @param response
     */
    public static void expireCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookies[] = request.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            Cookie thisCookie = cookies[i];
            String _cName = thisCookie.getName();
            setCookie(_cName, "", 0, response);
        }
    }

    /**
     * Key 에 해당하는 쿠기 삭제
     *
     * @param request
     * @param response
     */
    public static void expireCookie(String keyName, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookies[] = request.getCookies();

        if(cookies != null){
            for (Cookie thisCookie : cookies) {
                String _cName = thisCookie.getName();
                if (StringUtils.equals(_cName, keyName)) {
                    setCookie(_cName, "", 0, response);
                }
            }
        }
    }
}
