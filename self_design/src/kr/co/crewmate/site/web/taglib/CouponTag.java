/**
 * 
 */
package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import kr.co.crewmate.site.config.Config;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;


@SuppressWarnings("serial")
public class CouponTag extends TagSupport {
    /**
     * 템플릿 파일
     */
    private static final String PRINT_COUPON_TEMPLATE_NAME = "printCouponTag.vm";
    
    /**
     * 이미지 서버 호스트
     */
    private String imageServer;
    
    /**
     * 쿠폰종류 코드
     * t_code(cpnImageCode)
     */
    private String cpnImageCode;
    
    /**
     * 쿠폰분류
     * Y : 정률쿠폰
     * N : 정액쿠폰
     */
    private boolean fixRateYn;
    
    
    /**
     * 할인율 또는 할인금액
     */
    private String amount;
    
    private String rate;
    
    /**
     * 쿠폰이름
     */
    private String cpnName;
    
    /**
     * constructor
     */
    public CouponTag() {
    }
    
    @Override
    public int doEndTag() throws JspException {
        try {
            if (StringUtils.isEmpty(cpnImageCode)) {
                return EVAL_PAGE;
            }
            
            Template template = Velocity.getTemplate(PRINT_COUPON_TEMPLATE_NAME);
            
            VelocityContext context = new VelocityContext();
            context.put("imageServer", Config.getImageServerHost());
            context.put("cpnImageCode", cpnImageCode);
            context.put("fixRateYn", fixRateYn);
            context.put("amount", amount);
            context.put("rate", rate);
            context.put("cpnName", cpnName);
            template.merge(context, pageContext.getOut());
        } catch (Exception e) {
            e.printStackTrace();
            throw new JspException(e);
        }

        return EVAL_PAGE;
    }

    public String getImageServer() {
        return imageServer;
    }

    public void setImageServer(String imageServer) {
        this.imageServer = imageServer;
    }

    public String getCpnImageCode() {
        return cpnImageCode;
    }

    public void setCpnImageCode(String cpnImageCode) {
        this.cpnImageCode = cpnImageCode;
    }

    public boolean isFixRateYn() {
        return fixRateYn;
    }

    public void setFixRateYn(boolean fixRateYn) {
        this.fixRateYn = fixRateYn;
    }

    public String getCpnName() {
        return cpnName;
    }

    public void setCpnName(String cpnName) {
        this.cpnName = cpnName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

}
