package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import kr.co.crewmate.site.config.Config;

import org.apache.commons.lang3.StringUtils;

/**
 * 상품 아이콘
 */
@SuppressWarnings("serial")
public class IconTagGradeLarge extends IconTag {
    @Override
    String getImageTag(String imageName) {
        return String.format("<img src=\""+Config.getImageServerHost()+"/images/shop/common/member/member_grade%s.gif\"/>", imageName);
    }
    @Override
    public int doEndTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            if (StringUtils.isEmpty(super.getIcon())) {
                return EVAL_PAGE;
            }
            
            out.println(getImageTag(super.getIcon()));
            
        } catch (Exception e) {
            throw new JspException(e);
        }

        return EVAL_PAGE;
    }
}
