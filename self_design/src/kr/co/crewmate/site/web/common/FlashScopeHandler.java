package kr.co.crewmate.site.web.common;

/**
 * 
 * 클래스명: <code>FlashScopeHandler</code>
 *
 * <pre>
 *  
 * </pre>
 *
 * @author 이경연
 * @date 2011. 12. 16.
 *
 */
public class FlashScopeHandler {

    public final static String PREVIOUS_FLASH_SCOPE = "previousFlashScope";

    public final static String FLASH_SCOPE = "flash";

    public static FlashScope getFlash() {
        return new FlashScope(PREVIOUS_FLASH_SCOPE);
    }

    public static FlashScope getCurrent() {
        return new CurrentFlashScope();
    }

    public static void move() {
        new FlashScope(PREVIOUS_FLASH_SCOPE).move();
    }
}
