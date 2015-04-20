package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.config.ConfigValueNotFoundException;


import org.apache.commons.lang3.StringUtils;

/**
 *
 * 클래스명: <code>VariableTag</code>
 * <pre>
 * 환경변수태그
 * abcmart.xml
 * </pre>
 *
 * @date 2010. 10. 25.
 * @author 이경연
 *
 */
@SuppressWarnings("serial")
public class VariableTag extends TagSupport {

    /**
     * 키값
     */
    private String key;

    /**
     * prefix
     */
    private String prepare;

    /**
     * postfix
     */
    private String postfix;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPrepare() {
        return prepare;
    }

    public void setPrepare(String prepare) {
        this.prepare = prepare;
    }

    public String getPostfix() {
        return postfix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    @Override
    public int doEndTag() throws JspException {
        StringBuilder buffer = new StringBuilder();
        String[] keys = this.key.split(",");

        try {
            if (StringUtils.isNotEmpty(this.prepare)) {
                buffer.append(prepare);
            }

            for (String key: keys) {
                try {
                    String value = Config.getString(key);
                    buffer.append(value);
                } catch (ConfigValueNotFoundException e) {

                }
            }

            if (StringUtils.isNotEmpty(this.postfix)) {
                buffer.append(postfix);
            }

            JspWriter out = pageContext.getOut();
            out.print(buffer.toString());

        } catch (Exception e) {
            throw new JspException();
        }

        return EVAL_PAGE;
    }
}
