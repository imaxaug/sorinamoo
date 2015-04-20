package kr.co.crewmate.site.exceptions;

@SuppressWarnings("serial")
public class CnrCodeNotFoundException extends RuntimeException  {
    public CnrCodeNotFoundException(String e) {
        super(e);
    }
    
    public CnrCodeNotFoundException(Exception e) {
        super(e);
    }
}
