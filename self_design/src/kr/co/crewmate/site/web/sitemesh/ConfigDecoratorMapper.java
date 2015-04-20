package kr.co.crewmate.site.web.sitemesh;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.module.sitemesh.Config;
import com.opensymphony.module.sitemesh.Decorator;
import com.opensymphony.module.sitemesh.DecoratorMapper;
import com.opensymphony.module.sitemesh.Page;
import com.opensymphony.module.sitemesh.mapper.AbstractDecoratorMapper;
import com.opensymphony.module.sitemesh.mapper.ConfigLoader;

/**
 * Default implementation of DecoratorMapper. Reads decorators and mappings from
 * the <code>config</code> property (default '/WEB-INF/decorators.xml').
 * 
 * @author <a href="joe@truemesh.com">Joe Walnes</a>
 * @author <a href="mcannon@internet.com">Mike Cannon-Brookes</a>
 * @version $Revision: 1.1 $
 * 
 * @see com.opensymphony.module.sitemesh.DecoratorMapper
 * @see com.opensymphony.module.sitemesh.mapper.DefaultDecorator
 * @see com.opensymphony.module.sitemesh.mapper.ConfigLoader
 */
public class ConfigDecoratorMapper extends AbstractDecoratorMapper {

    Log log = LogFactory.getLog(this.getClass());

    private ConfigLoader configLoader = null;

    /** Create new ConfigLoader using '/WEB-INF/decorators.xml' file. */
    @Override
    public void init(Config config, Properties properties, DecoratorMapper parent) throws InstantiationException {
        super.init(config, properties, parent);
        try {
            String fileName = properties.getProperty("config", "/WEB-INF/decorators.xml");
            configLoader = new ConfigLoader(fileName, config);
        } catch (Exception e) {
            throw new InstantiationException(e.toString());
        }
    }

    /**
     * Retrieve {@link com.opensymphony.module.sitemesh.Decorator} based on
     * 'pattern' tag.
     */
    @Override
    public Decorator getDecorator(HttpServletRequest request, Page page) {
        String thisPath = null;
        // String requestURI = request.getRequestURI();
        String requestURI = guessPath(request);
        
        if (request.getPathInfo() != null) {
            thisPath = requestURI.substring(0, requestURI.indexOf(request.getPathInfo()));
        } 
        
        if ("".equals(thisPath)) {
            thisPath = request.getPathInfo();
        } else {
            thisPath = requestURI;
        }

        String name = null;
        try {
            name = configLoader.getMappedName(thisPath);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        if (request.getAttribute("decorator") != null) {
            name = (String) request.getAttribute("decorator");
        }
        Decorator result = getNamedDecorator(request, name);
        return result == null ? super.getDecorator(request, page) : result;
    }

    private String guessPath(HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        if (!StringUtils.isEmpty(requestUri)) {
            return requestUri;
        } else {
            StringBuilder buffer = new StringBuilder();
            String servletPath = request.getServletPath();
            String pathInfo = request.getPathInfo();
            String query = request.getQueryString();
            buffer.append(servletPath == null ? "" : servletPath).append(pathInfo == null ? "" : pathInfo);
            if (query != null) {
                buffer.append("?").append(query);
            }

            return buffer.toString();
        }
    }

    /**
     * Retrieve Decorator named in 'name' attribute. Checks the role if
     * specified.
     */
    @Override
    public Decorator getNamedDecorator(HttpServletRequest request, String name) {
        Decorator result = null;
        try {
            result = configLoader.getDecoratorByName(name);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        if (result == null || (result.getRole() != null && !request.isUserInRole(result.getRole()))) {
            return super.getNamedDecorator(request, name);
        } else {
            return result;
        }
    }
}