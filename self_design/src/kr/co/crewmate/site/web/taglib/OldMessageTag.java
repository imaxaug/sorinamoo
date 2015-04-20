package kr.co.crewmate.site.web.taglib;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;

import kr.co.crewmate.site.model.Parameter;

/**
 * 클래스명: <code>MessageTag</code>
 *
 * <pre>
 *  설명을 기입하세요
 * </pre>
 *
 * @author 이경연
 * @date 2013. 6. 4.
 *
 */
@SuppressWarnings("serial")
public class OldMessageTag extends TagSupport  {
    
    private List<Parameter> messages;
    
    private String message;
    
    private String key;
    
    public int doEndTag() throws JspException {
        try {
            List<String> results = new ArrayList<String>();
            if (messages != null) {
                for (Parameter item: messages) {
                    if (StringUtils.equals(item.getKey(), this.key)) {
                        results.add(item.getValue());
                    }
                }
            }
            
            if (StringUtils.isNotEmpty(this.message)) {
                results.add(message);
            }
            
            JspWriter out = pageContext.getOut();
            out.println(getBufferString(results));
        } catch (Exception e) {
            e.printStackTrace();
            throw new JspException();
        }

        return EVAL_PAGE;
    }

    private String getBufferString(List<String> results) {
        StringBuilder buffer = null;
        for (String str: results) {
            if (buffer != null) {
                buffer.append(", ");
            } else {
                buffer = new StringBuilder();
            }
            buffer.append(str);
        }
        
        return buffer == null ? "" : buffer.toString(); 
    }

    @SuppressWarnings("unused")
    private String getLineMessage(String message, String color) {
        StringBuilder buffer = new StringBuilder(256);
        buffer.append(String.format("<strong style='color:%s'>%s</strong>", color, message));
        return buffer.toString();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Parameter> getMessages() {
        return messages;
    }

    public void setMessages(List<Parameter> messages) {
        this.messages = messages;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
