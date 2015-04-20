package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * 
 * 클래스명: <code></code>
 * <pre>
 *  문자열로된 날짜를 따로 포매팅하는 커스텀태그
 *  꼭 날짜가 아니래도 쉽게 사용가능하다.
 *  
 *  &lt;ui:mask pattern="####-##-##"&gt${promotion.prmnStartDt}&lt;/ui:mask&gt;
 * </pre>
 *
 * @date 2010. 7. 6.
 * @author hardline
 *
 */
public class MaskTag extends BodyTagSupport {
    private static final long serialVersionUID = 7000973688512676544L;

    private String pattern;

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int doAfterBody() throws JspException {
        try {
            JspWriter out = getPreviousOut();
            BodyContent body = getBodyContent();
            String value = body.getString();

            if ((value != null) && !value.equals("") && (pattern != null) && !pattern.equals("")) {
                String tmpStr = "";
                char[] valueChar = value.toCharArray();
                char[] patternChar = pattern.toCharArray();

                if ((valueChar != null) && (valueChar.length > 0) && (patternChar != null) && (patternChar.length > 0)) {
                    int i = 0;
                    int k = 0;

                    while (k < patternChar.length) {
                        if (patternChar[k] == '#') {
                            if (i < valueChar.length) {
                                tmpStr += valueChar[i];
                                i++;
                            }

                            k++;
                        }
                        else {
                            while ((k < patternChar.length) && (patternChar[k] != '#')) {
                                tmpStr += patternChar[k];
                                k++;
                            }
                        }
                    }
                }

                out.print(tmpStr);
            }
        }
        catch (Exception ex) {
            // throw new JspTagException("MaskTag : " + ex.getMessage());
        }

        return SKIP_BODY;
    }
}
