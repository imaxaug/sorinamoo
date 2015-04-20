package kr.co.crewmate.site.utils;

import javax.servlet.http.HttpServletRequest;

import kr.co.crewmate.site.model.mobile.UAgentInfo;

public class UserAgentUtils {

    public static boolean isMobile(UAgentInfo userAgent) {
        return userAgent == null ? false : userAgent.detectMobileLong() 
                || userAgent.detectSmartphone() 
                || userAgent.detectTierIphone() 
                || userAgent.detectAndroidWebKit() 
                || userAgent.detectIos();
    }

    public static boolean isMobile(HttpServletRequest request) {
        return isMobile((UAgentInfo) request.getAttribute("userAgent"));
    }

}
