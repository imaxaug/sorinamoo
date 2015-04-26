package kr.co.crewmate.site.model.batch;

import java.util.Date;

import kr.co.crewmate.site.model.ToString;


/**
 * 클래스명: <code>OrderNextParam</code>
 *
 * <pre>
 *  
 * </pre>
 *
 * @author 
 * @date 
 *
 */
public class OrderNextParam extends ToString {
    
    private int userCnt;
    private int orderCnt;
    
    public int getUserCnt() {
        return userCnt;
    }
    
    public void setUserCnt(int userCnt) {
        this.userCnt = userCnt;
    }
    
    public int getOrderCnt() {
        return orderCnt;
    }
    
    public void setOrderCnt(int orderCnt) {
        this.orderCnt = orderCnt;
    }
    
    
    
}
