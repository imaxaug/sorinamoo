package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * 클래스명: <code>DecoratorTag</code>
 * <pre>
 * SiteMesh 데코레이터 태그
 * 
 * 강제로 데코레이터를 바꾸어야 할때 사용된다.
 * </pre>
 *
 * @date 2010. 8. 19.
 * @author 이경연
 *
 */
@SuppressWarnings("serial")
public class DecoratorTag extends TagSupport {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doEndTag() throws JspException {
        if (StringUtils.isNotEmpty(this.name)) {
            pageContext.getRequest().setAttribute("decorator", this.name);
        }
        return super.doEndTag();
    }
}
