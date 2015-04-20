package kr.co.crewmate.site.web.taglib;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.GubunTagNote;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ParameterImpl;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 클래스명: <code>GubunTag</code>
 * 
 * <pre>
 *  구분리스트에 값을 출력하는 태그
 * </pre>
 * 
 * @author newstar000
 * @date 2011. 11. 28.
 * 
 */
@SuppressWarnings("serial")
public class GubunTag extends TagSupport {

    private String key;

    private String value;

    private String keyName;
    
    private String langCode;

    @Override
    public int doEndTag() throws JspException {
        try {
            List<Parameter> gubuns = this.getGubunOptionData();
            JspWriter out = pageContext.getOut();
            if (isEmpty(gubuns)) {
                return EVAL_PAGE;
            } else {
                for (Parameter parameter : gubuns) {
                    if (StringUtils.equals(value, parameter.getKey())) {
                        out.print(parameter.getValue());
                        out.flush();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new JspException();
        }

        return EVAL_PAGE;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private List<Parameter> getGubunOptionData() {
        GubunTagNote note = GubunTagNote.getInstance();
        String methodName = this.getKey();

        if (!StringUtils.isEmpty(methodName)) {
            try {
                char ch = methodName.charAt(0);
                String getMethod = "get" + methodName.replaceFirst(String.valueOf(ch), String.valueOf(Character.toUpperCase(ch)));
                
                if(StringUtils.isEmpty(langCode)){
                    langCode = Config.getSiteNatnCode();
                }
                Method method = note.getClass().getMethod(getMethod, String.class);
                Object o = method.invoke(note, langCode);

                if (o instanceof List) {
                    if (((List) o).size() > 0 && ((List) o).get(0) instanceof Parameter) {
                        return this.setNewGubun((List<Parameter>) o);
                    }
                }
            } catch (Exception e) {
                // ignore
            }
        }

        return null;
    }

    private boolean isEmpty(List<Parameter> objs) {
        return objs == null || objs.isEmpty();
    }

    private List<Parameter> setNewGubun(List<Parameter> gubuns) {
        List<Parameter> newGubuns = new ArrayList<Parameter>();
        newGubuns.addAll(gubuns);

        if (!StringUtils.isEmpty(keyName)) {
            String[] keyNames = keyName.split(",");

            if (keyNames != null) {
                for (int i = 0; i < keyNames.length; i++) {
                    String value = keyNames[i].replaceAll(" ", "");
                    newGubuns.set(i, new ParameterImpl(gubuns.get(i).getKey(), value));
                }
            }
        }

        return newGubuns;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
