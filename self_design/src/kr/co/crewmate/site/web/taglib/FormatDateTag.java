package kr.co.crewmate.site.web.taglib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import kr.co.crewmate.site.utils.Utils;


/**
 * 클래스명: <code>DateFormatTag</code>
 *
 * <pre>
 *  문자나 날짜 데이터를 원하는 포멧에 맞게 날짜형태로 변환
 *  
 *  ex) &lt;ui:formatDate value="20130629" pattern="yyyy.MM.dd"/&gt; 
 *  
 *  srcpattern는 value=의 포맷이 yyyyMMdd가 아닐때 설정 
 *  ex) value="2013-06-29" 일때 
 *  &lt;ui:formatDate value="2013-06-29" srcpattern="yyyy-MM-dd" pattern="yyyy.MM.dd"/&gt; 
 *  
 * </pre>
 *
 * @date 2013. 6. 11.
 *
 */
@SuppressWarnings("serial")
public class FormatDateTag extends BodyTagSupport {
    
    /**
     * Stirng , Date 
     */
    private Object value;
    
    /**
     * pattern
     */
    private String pattern;
    
    private String srcpattern;
    
    @Override
    public int doEndTag() throws JspException {
        
        try {
           JspWriter out = pageContext.getOut();
           
           Object v = getValue() ;
           String f = getPattern() ;
           
           if(v ==null){
               out.print(""); 
           }
           else{ 
               if(v instanceof String){ //String
                   String p = getSrcpattern() ;
                   if(p==null){     //문자열 소스 패턴이 없을때 기본 패턴 적용
                       p="yyyyMMdd" ; 
                   } 
                   
                   SimpleDateFormat sdf = new SimpleDateFormat(p);
                   try {
                       Date d = sdf.parse((String)v) ; 
                       sdf = new SimpleDateFormat(f);
                       out.print(sdf.format(d));
                   } catch (Exception e) {
                       out.print(v); 
                   } 
               }
               else if(v instanceof Date){  //Date 
                   SimpleDateFormat sf = new SimpleDateFormat(f);
                   out.print(sf.format((Date)v));
               }
           }
            
        } catch (Exception e) {
            throw new JspException(); 
        }

        return SKIP_BODY;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getSrcpattern() {
        return srcpattern;
    }

    public void setSrcpattern(String srcpattern) {
        this.srcpattern = srcpattern;
    } 
    
    
    

}
