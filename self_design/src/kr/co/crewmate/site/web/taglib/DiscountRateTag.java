package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import kr.co.crewmate.site.utils.Utils;


/**
 * 클래스명: <code>DiscountRateTag</code>
 *
 * <pre>
 *  할인율 역추적 커스텀테그
 *  
 *  ex) &lt;ui:discountRate sellprice="876000" dscntSellPrice="590400"/&gt;
 * </pre>
 *
 * @date 2013. 6. 11.
 *
 */
@SuppressWarnings("serial")
public class DiscountRateTag extends BodyTagSupport {
    
    /**
     * 원가
     */
    private int sellprice;
    
    /**
     * 할인된 가격
     */
    private int dscntSellPrice;
    
    @Override
    public int doEndTag() throws JspException {
        
        try {
           JspWriter out = pageContext.getOut();
           out.print(Utils.discountRate(getSellprice(), getDscntSellPrice()));
        } catch (Exception e) {
            throw new JspException();
        }

        return SKIP_BODY;
    }

    public int getSellprice() {
        return sellprice;
    }

    public void setSellprice(int sellprice) {
        this.sellprice = sellprice;
    }

    public int getDscntSellPrice() {
        return dscntSellPrice;
    }

    public void setDscntSellPrice(int dscntSellPrice) {
        this.dscntSellPrice = dscntSellPrice;
    }

}
