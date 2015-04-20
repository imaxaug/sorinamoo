package kr.co.crewmate.site.web.taglib;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import kr.co.crewmate.site.CodeName;
import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.GubunTagNote;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ParameterImpl;
import kr.co.crewmate.site.model.common.Code;
//import kr.co.crewmate.site.service.SystemService;
import kr.co.crewmate.site.utils.Utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * 클래스명: <code>CustomTagSupport</code>
 *
 * <pre>
 *  설명을 기입하세요
 *  
 *  공통 커스텀태그
 *  체크박스/select박스/라디오박스
 *  에 해당하는 커스텀태그
 *  
 *  기본으로는 사용자가 입력한 input에서 찾는다
 *  없으면 코드에서 뒤진다.
 *  
 *  label추가 
 *  모바일만 쓰세요 
 * </pre>
 *
 * @author newstar000
 * @date 2011. 11. 9.
 *
 */
@SuppressWarnings("serial")
public class CustomTagSupport extends BodyTagSupport {

    final Log log = LogFactory.getLog(this.getClass());
    
    /**
     * 템플릿파일명
     */
    private String tagFileName;

    /**
     * 파라매터명
     */
    private String name;
    
    /**
     * id
     */
    private String iD;

    /**
     * key(리퀘스트 변수명)
     */
    private String key;

    /**
     * 선택되어지는 값
     */
    private String value;

    /**
     * 클래스
     */
    private String clazz;

    /**
     * 줄바뀌는 라인카운트(몇개가 나오고 줄이바뀌는지)
     */
    private int line = 0;

    /**
     * disabled
     */
    private String disabled;

    /**
     * 키이름 (,로 구분)
     */
    private String keyName;
    
    /**
     * style(하드코딩시에)
     */
    private String style;
    
    /**
     * 제외값
     */
    private String except;
    
    /**
     * default값
     */
    private String defaultValue;
    
    private String langCode;
    
    /**
     * label추가
     */
    private String useLabel = "N";
    
    private String prefix = "Z";
    
    @Override
    public int doEndTag() throws JspException {

        Object optionData = getOptionData();
        Template template = null;
        VelocityContext context = null;

        try {
            if (optionData == null) {
                return SKIP_BODY;
            } else if (optionData instanceof List<?>) {

                @SuppressWarnings("unchecked")
                List<Parameter> options = (List<Parameter>) optionData;
                template = Velocity.getTemplate(this.tagFileName);
                context = new VelocityContext();

                if(options.size() > 0){
                    context.put("options", options);
                }
                context.put("name", this.name);
                context.put("value", this.value);
                context.put("clazz", this.clazz);
                context.put("line", this.line);
                context.put("disabled", this.disabled);
                context.put("id", this.iD);
                context.put("style", this.style);
                context.put("defaultValue", this.defaultValue);
                context.put("useLabel", this.useLabel);
                context.put("prefix", this.prefix);
                setExcept(context);
                context = setMoreContextData(context);
                
                template.merge(context, pageContext.getOut());
                
            } else {
                return SKIP_BODY;
            }

        } catch (Exception e) {
            throw new JspException();
        }

        return SKIP_BODY;
    }
    
    public Object getUserInput() {
        return pageContext.getAttribute(this.key, PageContext.REQUEST_SCOPE);
    }
    
    public Object getOptionData() {
        Object optionData = getUserInput();
        if (optionData == null) {
            optionData = getCode();
        }
        
        return optionData;
    }
    
    public Object getCode() {
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(super.pageContext.getServletContext());
//        SystemService systemService = applicationContext.getBean(SystemService.class);
//        List<Code> codes = systemService.getCodeHandler().getCodes(Utils.javaVariableNamingToDbNaming(this.key));
//        if (codes != null) {
//            List<Parameter> result = new ArrayList<Parameter>(codes.size());
//            if (CodeName.SITE_NATN_CODE_CN.equals(this.langCode)) {
//                for (Code code: codes) {
//                    result.add(new ParameterImpl(code.getCodeName(), code.getCodeValueCn()));
//                }
//                return (Object)result;
//            } else {
//                return (Object)codes;
//            }
//        } else{
            return null;
//        }
    }

    
    public VelocityContext setMoreContextData(VelocityContext context) {
        return context;
    }
    
    public void setExcept(VelocityContext context) {
        if(!StringUtils.isEmpty(except)) {
            String[] excepts = except.split(",");
            Map<String, String> exceptMap = new HashMap<String, String>();
            for (String key : excepts) {
                exceptMap.put(key.trim(), "except");
            }

            context.put("except", exceptMap);
        }
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Object getGubunOptionData() {
        GubunTagNote note = GubunTagNote.getInstance();
        String methodName = this.getKey();
        
        if(!StringUtils.isEmpty(methodName)) {
            try {
                char ch = methodName.charAt(0);
                String getMethod = "get" + methodName.replaceFirst(String.valueOf(ch), String.valueOf(Character.toUpperCase(ch)));
                if(StringUtils.isEmpty(langCode)){
                    langCode = Config.getSiteNatnCode();
                }
                Method method = note.getClass().getMethod(getMethod, String.class);
                Object o = method.invoke(note, langCode);
                
                if(o instanceof List) {
                    if(((List) o).size() > 0 && ((List) o).get(0) instanceof Parameter) {
                        return this.setNewGubun((List<Parameter>) o);
                    }
                }
                
                return o;
            } catch (Exception e) {
                // ignore
            }
        }
        
        return null;
    }
    
    private List<Parameter> setNewGubun(List<Parameter> gubuns) {
        List<Parameter> newGubuns = new ArrayList<Parameter>();
        newGubuns.addAll(gubuns);

        if(!StringUtils.isEmpty(keyName)){
            String[] keyNames = keyName.split(",");

            if(keyNames != null) {
                for (int i=0 ; i<keyNames.length ; i++) {
                    String value = keyNames[i].replaceAll(" ", "");
                    newGubuns.set(i, new ParameterImpl(gubuns.get(i).getKey(), value));
                }
            }
        }

        return newGubuns;
    }

    public String getTagFileName() {
        return tagFileName;
    }

    public void setTagFileName(String tagFileName) {
        this.tagFileName = tagFileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getExcept() {
        return except;
    }

    public void setExcept(String except) {
        this.except = except;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getUseLabel() {
        return useLabel;
    }

    public void setUseLabel(String useLabel) {
        this.useLabel = useLabel;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
