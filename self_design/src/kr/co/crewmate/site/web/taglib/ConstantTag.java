package kr.co.crewmate.site.web.taglib;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;

import kr.co.crewmate.site.Constants;

/**
*
* 클래스명: <code>ConstantTag</code>
* <pre>
* 상수태그
* ex) &lt;ui:constant key="ERROR_MESSAGE"/&gt;
* </pre>
*
* @date 2010. 10. 25.
* @author 이경연
*
*/
@SuppressWarnings("serial")
public class ConstantTag extends TagSupport {

    private static Map<String, Field> fieldMap;

    /**
     * 키
     */
    private String key;

    /**
     * prefix
     */
    private String prepare;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPrepare() {
        return prepare;
    }

    public void setPrepare(String prepare) {
        this.prepare = prepare;
    }

    @Override
    public int doEndTag() throws JspException {
        StringBuilder buffer = new StringBuilder();
        String[] keys = this.key.split(",");
        Class<Constants> source = Constants.class;

        try {
            if (StringUtils.isNotEmpty(this.prepare)) {
                buffer.append(prepare);
            }

            for (String key: keys) {
                String value = findConstantByKey(source, key);
                buffer.append(value);
            }

            JspWriter out = pageContext.getOut();
            out.print(buffer.toString());

        } catch (Exception e) {
            throw new JspException();
        }

        return EVAL_PAGE;
    }

    private String findConstantByKey(Class<Constants> source, String key) {
        String localKey = null;
        if (key == null) {
            return null;
        } else {
            localKey = key.toUpperCase();
        }

        Map<String, Field> fm = getFieldMap(source);
        if (fm.containsKey(localKey)) {
            Field f = fm.get(localKey);
            try {
                return f.get(localKey).toString();
            } catch (Exception e) {
                // 다음과 같은 상황은 무시한다.
                return null;
            }
        } else {
            return null;
        }
    }

    private Map<String, Field> getFieldMap(Class<Constants> source) {
        if (fieldMap == null) {
            Field[] fields = source.getDeclaredFields();
            fieldMap = new HashMap<String, Field>(fields.length);
            for (Field f: fields) {
                fieldMap.put(f.getName().toUpperCase(), f);
            }
        }

        return fieldMap;
    }
}