package kr.co.crewmate.site.web.taglib;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import kr.co.crewmate.site.utils.Utils;


/**
 * 클래스명: <code>DalToWonTag</code>
 *
 * <pre>
 *  달러와 환율을 받았을때 원화을 리턴하는 커스텀테그
 *  
 *  ex) &lt;ui:dalToWon dal="100" rate="1144.1" format="false" /&gt;
 * </pre>
 *
 * @date 2013. 6. 11.
 *
 */
@SuppressWarnings("serial")
public class DalToWonTag extends BodyTagSupport {

    /**
     * 달러
     */
    private double dal;
    
    /**
     * 환율
     */
    private double rate;
    
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
            saveRate = new BigDecimal(getRate());
            out = pageContext.getOut();
            
            if(isFormat()) {
                formatNum = new DecimalFormat("#,##0");
                out.print(formatNum.format(Utils.dalToWon(getDal(), saveRate)));
            } else {
                out.print(Utils.dalToWon(getDal(), saveRate));
            }
        } catch (Exception e) {
            throw new JspException();
        }

        return SKIP_BODY;
    }

    public double getDal() {
        return dal;
    }

    public void setDal(double dal) {
        this.dal = dal;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isFormat() {
        return format;
    }

    public void setFormat(boolean format) {
        this.format = format;
    }
    
}
