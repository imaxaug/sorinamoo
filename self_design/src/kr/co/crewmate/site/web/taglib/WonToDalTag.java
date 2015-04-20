package kr.co.crewmate.site.web.taglib;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang3.StringUtils;

import kr.co.crewmate.site.utils.Utils;


/**
 * 클래스명: <code>WonToDalTag</code>
 *
 * <pre>
 *  원화와 환율을 받았을때 달러을 리턴하는 커스텀테그
 *  
 *  ex) &lt;ui:wonTodal won="10000" rate="1144.1"/&gt;
 * </pre>
 *
 * @date 2013. 6. 19.
 *
 */
@SuppressWarnings("serial")
public class WonToDalTag extends BodyTagSupport {

    /**
     * 원화
     */
    private int won;
    
    /**
     * 환율
     */
    private double rate;
    
    
    /**
     * 단위 표시여부
     */
    private boolean format;
    
    private String pattern;
    
    
    @Override
    public int doEndTag() throws JspException {
        DecimalFormat formatNum;
        BigDecimal saveRate;
        JspWriter out;
        
        try {
            saveRate = new BigDecimal(getRate());
            out = pageContext.getOut();
            
            if(isFormat()) {
            	if(!StringUtils.isEmpty(pattern))
            		formatNum = new DecimalFormat(pattern);
            	else
            		formatNum = new DecimalFormat("#,##0.00");
            		
                out.print(formatNum.format(Utils.wonToDal(getWon(), saveRate)));
            } else {
                out.print(Utils.wonToDal(getWon(), saveRate));
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

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
