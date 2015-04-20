package kr.co.crewmate.site.web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class BoolTag extends BodyTagSupport {
    
    final Log log = LogFactory.getLog(this.getClass());
    
    private String name;
    
    private String value;
    
    @Override
    public int doEndTag() throws JspException {
        StringBuilder checkbox = new StringBuilder();
        checkbox.append("<input type='checkbox' ");
        checkbox.append(String.format("name='%s' ", this.name));
        checkbox.append("value='true'");
        if (Utils.stringToBoolean(this.value)) {
            checkbox.append(" checked");
        }
        checkbox.append("/> ");
        BodyContent body = super.getBodyContent();
        if (body != null) {
            checkbox.append(body.getString());
        }

        JspWriter out = pageContext.getOut();
        try {
            out.print(checkbox.toString());
        } catch (IOException e) {
            throw new JspException();
        }
        
        return SKIP_BODY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
