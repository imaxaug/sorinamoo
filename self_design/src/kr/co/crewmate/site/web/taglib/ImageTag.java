package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import kr.co.crewmate.site.config.Config;

import org.apache.commons.lang3.StringUtils;


/**
 * 클래스명: <code>ImageTag</code>
 *
 * <pre>
 *  이미지 태그
 *  ex) &lt;ui:image src="/nexti/images/abcmart/1356/1322642040715_1.jpg" width="150" height="100" alt="hello" id="wow" clazz="class" /&gt;
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 21.
 *
 */
@SuppressWarnings("serial")
public class ImageTag extends TagSupport {

    /**
     * 이미지 경로 
     */
    private String src;

    /**
     * alt
     */
    private String alt;

    /**
     * id
     */
    private String id;

    /**
     * class
     */
    private String clazz;

    /**
     * with
     */
    private String width;

    /**
     * height
     */
    private String height;

    /**
     * style
     */
    private String style;

    /**
     * error시에 스크립트 
     */
    private String onerror;

    /**
     * 사용안함 
     */
    private String server;

    /**
     * width, height
     */
    private String size;

    /**
     * usemap
     */
    private String usemap;

    /**
     * title
     */
    private String title;
    
    /**
     * 브랜드이미지 여부
     */
    private boolean brandYn;    
    
    @Override
    public int doEndTag() throws JspException {
        StringBuilder buffer = new StringBuilder();
        try {
            // String host = Config.getImageServerHost();
            String host = Config.getUploadServerHost();
            buffer.append("<img src=\"");
            buffer.append(host);
            buffer.append(src);
            buffer.append("\"");
            
            if (StringUtils.isEmpty(this.alt) == false) {
                buffer.append(" alt=\"");
                buffer.append(this.alt);
                buffer.append("\"");
            }

            if (StringUtils.isEmpty(this.id) == false) {
                buffer.append(" id=\"");
                buffer.append(this.id);
                buffer.append("\"");
            }

            if (StringUtils.isEmpty(this.clazz) == false) {
                buffer.append(" class=\"");
                buffer.append(this.clazz);
                buffer.append("\"");
            }
            
            if (StringUtils.isEmpty(this.size)) {
                if (StringUtils.isEmpty(this.width) == false) {
                    buffer.append(" width=\"");
                    buffer.append(this.width);
                    buffer.append("\"");
                }

                if (StringUtils.isEmpty(this.height) == false) {
                    buffer.append(" height=\"");
                    buffer.append(this.height);
                    buffer.append("\"");
                }
            } else {
                buffer.append(" width=\"");
                buffer.append(this.size);
                buffer.append("\"");

                buffer.append(" height=\"");
                buffer.append(this.size);
                buffer.append("\"");
            }

            if (StringUtils.isEmpty(this.style) == false) {
                buffer.append(" style=\"");
                buffer.append(this.style);
                buffer.append("\"");
            }

            if (StringUtils.isEmpty(this.usemap) == false) {
                buffer.append(" usemap=\"");
                buffer.append(this.usemap);
                buffer.append("\"");
            }

            if (StringUtils.isEmpty(this.title) == false) {
                buffer.append(" title=\"");
                buffer.append(this.title);
                buffer.append("\"");
            }

            if (StringUtils.isNotEmpty(this.onerror)) {
                if (this.onerror.equals("N")) {
                } else {
                    appendOnError(buffer, isBrandYn());
                }
            } else {
                appendOnError(buffer, isBrandYn());
            }

            buffer.append("/>");

            JspWriter out = pageContext.getOut();
            out.print(buffer.toString());
        } catch (Exception e) {
            throw new JspException();
        }

        return EVAL_PAGE;
    }
    
    private void appendOnError(StringBuilder buffer, boolean brandYn) {
        if(brandYn) {
            buffer.append(" onerror=\"brandImageError(this)\"");
        }else{
            buffer.append(" onerror=\"imageError(this)\"");
        }
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getOnerror() {
        return onerror;
    }

    public void setOnerror(String onerror) {
        this.onerror = onerror;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUsemap() {
        return usemap;
    }

    public void setUsemap(String usemap) {
        this.usemap = usemap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBrandYn() {
        return brandYn;
    }

    public void setBrandYn(boolean brandYn) {
        this.brandYn = brandYn;
    }
    
    
}