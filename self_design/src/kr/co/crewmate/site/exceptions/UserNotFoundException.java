package kr.co.crewmate.site.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(String message) {
        super(message);
    }
    
    public UserNotFoundException(Exception e) {
        super(e);
    }
}
