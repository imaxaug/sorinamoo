package kr.co.crewmate.site.exceptions;

@SuppressWarnings("serial")
public class CategoryNotFoundException extends RuntimeException {
    
    public CategoryNotFoundException(String message) {
        super(message);
    }
    
    public CategoryNotFoundException(Exception e) {
        super(e);
    }    
}
