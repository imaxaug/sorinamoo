package kr.co.crewmate.site.utils;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.Velocity;

/**
 * 클래스명: <code>VelocityWebConfigure</code>
 *
 * <pre>
 *  벨로시티 WebConfigure
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 21.
 *
 */
public class VelocityWebConfigure {
    private static Log log = LogFactory.getLog(VelocityWebConfigure.class);

    static void init(ServletContext context) {
        String config = context.getRealPath(context.getInitParameter("velocityConfigLocation"));
        
        context.log(config);

        try {
            Properties properties = new Properties();

            properties.load(new FileInputStream(config));

            String loaderPath = properties.getProperty("file.resource.loader.path");
            String realPath = context.getRealPath(loaderPath);

            context.log(realPath);
            properties.setProperty("file.resource.loader.path", realPath);
            Velocity.init(properties);
        }
        catch (Exception e) {
            context.log(e.getMessage());
        }
    }

    static void shutdown(ServletContext context) {
        log.debug("shutdown");
    }
}
