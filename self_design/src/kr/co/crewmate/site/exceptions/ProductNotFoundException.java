package kr.co.crewmate.site.exceptions;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {
    
    public ProductNotFoundException(String message) {
        super(message);
    }
    
    public ProductNotFoundException(Exception e) {
        super(e);
    }    
}
