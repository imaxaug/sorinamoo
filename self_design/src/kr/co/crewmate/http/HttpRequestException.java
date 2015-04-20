package kr.co.crewmate.http;

/**
 * 
 * 클래스명: <code>HttpRequestException</code>
 * 
 * <pre>
 *  http패키지에서 사용하기위한 Exception
 * </pre>
 *
 * @author 이경연
 * @date 2008-04-11
 *
 */
public class HttpRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HttpRequestException() {
        super();
    }

    public HttpRequestException(Exception e) {
        super(e);
    }

    public HttpRequestException(String string) {
        super(string);
    }
}