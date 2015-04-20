package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
abstract public class IconTag extends TagSupport {
    
    /**
     * 아이콘문자열
     */
    private String icon;
    
    /**
     * 별점
     */
    private Integer star;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * <pre>
     * 아이콘에 해당하는 이미지태그
     * </pre>
     * @param imageName
     * @return
     */
    abstract String getImageTag(String imageName);
    
    @Override
    public int doEndTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            if (StringUtils.isEmpty(this.icon)) {
                return EVAL_PAGE;
            }
            
            for (int i=0; i< this.getIcon().length(); i++) {
                if(this.getIcon().charAt(i) == '1'){
                    out.println(getImageTag("0" + (i + 1)));
                }
            }
        } catch (Exception e) {
            throw new JspException(e);
        }

        return EVAL_PAGE;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

}
