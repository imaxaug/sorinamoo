package kr.co.crewmate.site.exceptions;

/**
 * 
 * 클래스명: <code>OrderException</code>
 *
 * <pre>
 *  주문관련 exception
 * </pre>
 *
 * @author lionjk
 * @date 2013. 6. 19.
 *
 */
@SuppressWarnings("serial")
public class OrderException extends RuntimeException {

    public OrderException(String message) {
        super(message);
    }
    
    public OrderException(Exception e) {
        super(e);
    }
}
