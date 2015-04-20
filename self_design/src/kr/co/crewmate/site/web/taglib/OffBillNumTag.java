package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import kr.co.crewmate.site.utils.Utils;


/**
 * 클래스명: <code>OffBillNumTag</code>
 *
 * <pre>
 *  교환권 포맷
 *  
 *  ex) &lt;ui:changeNum offBillDate="20130913" offPosNo="0391B" offBillCnt="3"  /&gt;
 * </pre>
 *
 * @date 2013. 6. 19.
 *
 */
@SuppressWarnings("serial")
public class OffBillNumTag extends BodyTagSupport {

    /**
     * 교환권 일시
     */
    private String offBillDate;
    
    /**
     * 오프라인 포스번호
     */
    private String offPosNo;
    
    /**
     * 교환권 갯수
     */
    private int offBillCnt;
    
    
    @Override
    public int doEndTag() throws JspException {
        JspWriter out;
        
        try {
            out = pageContext.getOut();
            if(getOffBillDate() == null || getOffBillDate().equals("")) {
                out.print("");
            } else {
                out.print(getOffPosNo() + getOffBillDate() + Utils.returnNumber(getOffBillCnt()));
            }
        } catch (Exception e) {
            throw new JspException();
        }

        return SKIP_BODY;
    }

    public String getOffBillDate() {
        return offBillDate;
    }

    public void setOffBillDate(String offBillDate) {
        this.offBillDate = offBillDate;
    }

    public String getOffPosNo() {
        return offPosNo;
    }

    public void setOffPosNo(String offPosNo) {
        this.offPosNo = offPosNo;
    }

    public int getOffBillCnt() {
        return offBillCnt;
    }

    public void setOffBillCnt(int offBillCnt) {
        this.offBillCnt = offBillCnt;
    }

}
