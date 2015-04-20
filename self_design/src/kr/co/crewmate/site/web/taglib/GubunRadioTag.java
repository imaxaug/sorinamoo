package kr.co.crewmate.site.web.taglib;

/**
 * 
 * 클래스명: <code>GubunRadioTag</code>
 *
 * <pre>
 *  구분리스트를 라디오태그로 변경하여 출력하는 커스텀태그
 * </pre>
 *
 * @author newstar000
 * @date 2011. 11. 25.
 *
 */
@SuppressWarnings("serial")
public class GubunRadioTag extends RadioTag {

    @Override
    public Object getOptionData() {
        return getGubunOptionData();
    }
}
