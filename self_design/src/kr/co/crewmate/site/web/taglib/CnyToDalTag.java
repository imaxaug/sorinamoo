package kr.co.crewmate.site.web.taglib;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import kr.co.crewmate.site.utils.Utils;


/**
 * 클래스명: <code>CnyToDalTag</code>
 *
 * <pre>
 *  위안과 환율을 받았을때 달러를 리턴하는 커스텀테그
 *  
 *  ex) &lt;ui:cnyToDal cny="100" cnyRate="1144.1" format="false" /&gt;
 * </pre>
 *
 * @date 2013. 6. 11.
 *
 */
@SuppressWarnings("serial")
public class CnyToDalTag extends BodyTagSupport {

    /**
     * 위안
     */
    private double cny;
    
    /**
     * 환율
     */
    private double cnyRate;
    
    /**
     * 단위 구분 여부
     */
    private boolean format;
    
    @Override
    public int doEndTag() throws JspException {
        DecimalFormat formatNum;
        BigDecimal saveRate;
        JspWriter out;
        
        try {
            saveRate = new BigDecimal(getCnyRate());
            out = pageContext.getOut();
            
            if(isFormat()) {
                formatNum = new DecimalFormat("#,##0");
                out.print(formatNum.format(Utils.cnyToDal(getCny(), saveRate)));
            } else {
                out.print(Utils.dalToWon(getCny(), saveRate));
            }
        } catch (Exception e) {
            throw new JspException();
        }

        return SKIP_BODY;
    }

    public double getCny() {
        return cny;
    }

    public void setCny(double cny) {
        this.cny = cny;
    }

    public double getCnyRate() {
        return cnyRate;
    }

    public void setCnyRate(double cnyRate) {
        this.cnyRate = cnyRate;
    }

    public boolean isFormat() {
        return format;
    }

    public void setFormat(boolean format) {
        this.format = format;
    }


    
}
