package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;


@SuppressWarnings("serial")
public class SubstringTag extends BodyTagSupport {
    
    private String string;
    
    private int begin = 0;
    
    private Integer end;
    
    private String postfix="";
    
    @Override
    public int doEndTag() throws JspException {
        
        try {
           JspWriter out = pageContext.getOut();
           
           if(end <= string.length()){
               out.print(string.substring(begin, end)+postfix);
           }else{
               out.print(string);
           }
        } catch (Exception e) {
            throw new JspException();
        }

        return SKIP_BODY;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getPostfix() {
        return postfix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

}
