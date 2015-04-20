package kr.co.crewmate.site.web.taglib;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import kr.co.crewmate.site.utils.Utils;


/**
 * 클래스명: <code>WonToCnyTag</code>
 *
 * <pre>
 *  원화와 달러환율, 위안환율 받았을때 위안을 반환하는 태그
 *  
 *  ex) &lt;ui:wonToCny won="10000" dalRate="1144.1" cnyRate="6.21" /&gt;
 * </pre>
 *
 * @date 2013. 6. 19.
 *
 */
@SuppressWarnings("serial")
public class WonToCnyTag extends BodyTagSupport {

    /**
     * 원화
     */
    private int won;
    
    /**
     * 달러-환율
     */
    private double dalRate;
    
    /**
     * 위안-환율
     */
    private double cnyRate;
    
    /**
     * 단위 표시여부
     */
    private boolean format;
    
    @Override
    public int doEndTag() throws JspException {
        DecimalFormat formatNum;
        BigDecimal saveDalRate;
        BigDecimal saveCnyRate;
        JspWriter out;
        
        try {
            saveDalRate = new BigDecimal(getDalRate());
            saveCnyRate = new BigDecimal(getCnyRate());
            out = pageContext.getOut();
            
            if(isFormat()) {
                formatNum = new DecimalFormat("#,##0.00");
                out.print(formatNum.format(Utils.wonToCny(getWon(), saveDalRate, saveCnyRate)));
            } else {
                out.print(Utils.wonToCny(getWon(), saveDalRate, saveCnyRate));
            }
        } catch (Exception e) {
            // throw new JspException();
        }

        return SKIP_BODY;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public double getDalRate() {
        return dalRate;
    }

    public void setDalRate(double dalRate) {
        this.dalRate = dalRate;
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
