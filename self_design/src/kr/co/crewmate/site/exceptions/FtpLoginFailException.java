package kr.co.crewmate.site.exceptions;

/**
 * 
 * 클래스명: <code>FtpLoginFailException</code>
 * 
 * <pre>
 * FTP 로그인 실패 Exception
 * </pre>
 *
 * @author 이경연
 * @date 2011. 3. 29.
 *
 */
@SuppressWarnings("serial")
public class FtpLoginFailException extends RuntimeException {

    public FtpLoginFailException(String message) {
        super(message);
    }

    public FtpLoginFailException(Exception e) {
        super(e);
    }
}