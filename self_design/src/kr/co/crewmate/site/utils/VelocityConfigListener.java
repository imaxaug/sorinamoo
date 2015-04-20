package kr.co.crewmate.site.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 클래스명: <code>VelocityConfigListener</code>
 *
 * <pre>
 *  벨로시티를 로딩하는 리스너
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 21.
 *
 */
public class VelocityConfigListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().log("[VelocityConfigListener] Initializing velocity");
        VelocityWebConfigure.init(event.getServletContext());
    }

    public void contextDestroyed(ServletContextEvent event) {
        event.getServletContext().log("[VelocityConfigListener] Shutdown velocity");
        VelocityWebConfigure.shutdown(event.getServletContext());
    } 
}