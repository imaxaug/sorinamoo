package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import kr.co.crewmate.site.config.Config;

/**
 * 상품 아이콘
 */
@SuppressWarnings("serial")
public class IconReviewPoint extends IconTag {
    @Override
    String getImageTag(String onOff) {
        return String.format("<img src=\""+Config.getImageServerHost()+"/images/shop/product/detail/star_%s.gif\"/>", onOff);
    }
    @Override
    public int doEndTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            if (this.getStar() == null) {
                return EVAL_PAGE;
            }
            
            for (int i=0; i< 5; i++) {
                if( i < (this.getStar()/2)){
                    out.println(getImageTag("on"));
                }else{
                    out.println(getImageTag("off"));
                }
            }
        } catch (Exception e) {
            throw new JspException(e);
        }

        return EVAL_PAGE;
    }

}
