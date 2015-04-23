package kr.co.crewmate.site.model.system;

import kr.co.crewmate.site.model.ToString;


/**
 * 클래스명: <code></code>
 *
 * <pre>
 *  설명을 기입하세요
 * </pre>
 *
 * @author smuft76
 * @date 2013. 3. 21.
 *
 */
public class ErrorData extends ToString {
    private Exception error;
    
    private String errorString;

    public ErrorData(Exception e, String line) {
        this.error = e;
        this.errorString = line;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }
}
