package kr.co.crewmate.site.web.taglib;

/**
 * 
 * 클래스명: <code>GubunSelectTag</code>
 *
 * <pre>
 *  구분리스트를 콤보박스로 변경하여 출력하는 커스텀태그
 * </pre>
 *
 * @author newstar000
 * @date 2011. 11. 28.
 *
 */
@SuppressWarnings("serial")
public class GubunSelectTag extends SelectTag {

    @Override
    public Object getOptionData() {
        return getGubunOptionData();
    }
}
