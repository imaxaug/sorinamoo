package kr.co.crewmate.site.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.crewmate.site.Constants;
import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.naver.NaverCode;
import kr.co.crewmate.utils.Closer;
import kr.co.crewmate.utils.FileHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * 클래스명: <code>SiteUtils</code>
 * <pre>
 *  파일다운로드에 관련된 유틸
 *  파일명은 ISO-8859-1 로 인코딩하게 되면 각 브라우져가 
 *  브라우져의 인코딩으로 파일명을 변환하게된다. 
 * </pre>
 *
 * @date 2010. 7. 21.
 * @author 이경연
 *
 */
public class SiteUtils {

    public final static String HTTP_CONTENT_DISPOSITION = "Content-Disposition";

    public final static String HTTP_CONTENT_DISPOSITION_UP = HTTP_CONTENT_DISPOSITION.toUpperCase();

    public final static String DOWNLOAD_CONTENT_TYPE = "application/octet-stream";

    public final static String DOWNLOAD_CHARSET = "ISO-8859-1";
    
    public final static String ALNC_SESSION_KEY = "naver_code";

    /**
     * 파일 다운로드
     *
     * @param response
     * @param f
     */
    public static void download(HttpServletResponse response, File f) {
        String fileName = f.getName();
        InputStream is = null;

        try {
            is = new FileInputStream(f);
            download(response, is, fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            Closer.close(is);
        }
    }

    /**
     * inputstream 다운로드
     *
     * @param response
     * @param input
     * @param fileName
     */
    public static void download(HttpServletResponse response, InputStream input, String fileName) {
        String headerValue = "attachment; filename=\""+ fileName +"\";";
        try {
            headerValue = new String(headerValue.getBytes(Config.getString("server.charset")), DOWNLOAD_CHARSET);
        } catch (UnsupportedEncodingException ignore) {
            // 아 시바 어쩌라고
        }

        response.setContentType(DOWNLOAD_CONTENT_TYPE);
        response.setCharacterEncoding(DOWNLOAD_CHARSET);
        response.setHeader(HTTP_CONTENT_DISPOSITION, headerValue);

        try {
            FileHelper.copy(input, response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <pre>
     * </pre>
     * @param request
     * @return
     */
    public static String getRequestUri(HttpServletRequest request) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(request.getScheme());
        buffer.append("://");
        buffer.append(request.getServerName());
        if (request.getRemotePort() != 80) {
            buffer.append(":");
            buffer.append(request.getServerPort());
        }
        
        buffer.append(request.getRequestURI());
        String queryString = request.getQueryString();
        if (StringUtils.isNotEmpty(queryString)) {
            buffer.append("?");
            buffer.append(queryString);
        }
        return buffer.toString();
    }

    /**
     * <pre>
     * </pre>
     * @param request
     * @return
     */
    public static String getRequestUriForSSL(HttpServletRequest request) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("https");
        buffer.append("://");
        buffer.append(request.getServerName());
        buffer.append(request.getRequestURI());
        String queryString = request.getQueryString();
        if (StringUtils.isNotEmpty(queryString)) {
            buffer.append("?");
            buffer.append(queryString);
        }
        
        return buffer.toString();
    }

    /**
     * <pre>
     * 다운로드이전까지 로직처리를 한다.
     * </pre>
     * @param response
     * @param fileName
     */
    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        String headerValue = "attachment; filename=\""+ fileName +"\";";
        try {
            headerValue = new String(headerValue.getBytes(Config.getString("server.charset")), DOWNLOAD_CHARSET);
        } catch (UnsupportedEncodingException ignore) {
            // 아 시바 어쩌라고
        }

        response.setContentType(DOWNLOAD_CONTENT_TYPE);
        response.setCharacterEncoding(DOWNLOAD_CHARSET);
        response.setHeader(HTTP_CONTENT_DISPOSITION, headerValue);
    }
    
    /**
     * <pre>
     * 1. 세션의 언어코드를 가져온다.
     * 2. 세션에 없다면 시스템의 언어코드를 가져온다.
     * </pre>
     * @return
     */
    public static String getLocale() {
        String locale = Config.getSiteNatnCode();
        try {
            RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            
            if (request != null) {
                locale = (String) request.getSession().getAttribute(Constants.LOCALE_SESSION_KEY);
            }
        } catch (Exception e) {
            // do notthing
        }
        
        return locale;
    }
    
    public static HttpSession getSession() {
        try {
            RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            return request.getSession();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void saveNaverProduct(String prdtCode) {
        NaverCode naverCode = getNaverCodeBySession();
        if (naverCode == null) {
            HttpSession session = SiteUtils.getSession();
            naverCode = new NaverCode();
            session.setAttribute(ALNC_SESSION_KEY, naverCode);
        }
        
        naverCode.add(prdtCode);
    }
    
    public static String getNaverCode() {
        NaverCode naverCode = getNaverCodeBySession();
        return naverCode == null ? null : naverCode.getNaverCode();
    }
    
    public static void saveNaverCode(String code) {
        NaverCode naverCode = getNaverCodeBySession();
        if (naverCode == null) {
            HttpSession session = SiteUtils.getSession();
            naverCode = new NaverCode();
            session.setAttribute(ALNC_SESSION_KEY, naverCode);
        }
        
        naverCode.setNaverCode(code);
    }
    
    private static NaverCode getNaverCodeBySession() {
        HttpSession session = SiteUtils.getSession();
        return (NaverCode) session.getAttribute(ALNC_SESSION_KEY);
    }

    public static boolean isExistNaverProduct(String prdtCode) {
        NaverCode naverCode = getNaverCodeBySession();
        if (naverCode == null) {
            return false;
        }
        
        return naverCode.contains(prdtCode);
    }

    
}
