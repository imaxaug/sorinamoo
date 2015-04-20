package kr.co.crewmate.site.exceptions;

/**
 * 
 * 클래스명: <code>PaymentException</code>
 *
 * <pre>
 *  결제관련 exception
 * </pre>
 *
 * @author lionjk
 * @date 2013. 6. 19.
 *
 */
@SuppressWarnings("serial")
public class PaymentException extends RuntimeException {

    public PaymentException(String message) {
        super(message);
    }
    
    public PaymentException(Exception e) {
        super(e);
    }
}
