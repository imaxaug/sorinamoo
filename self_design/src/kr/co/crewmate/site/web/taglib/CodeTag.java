package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.common.Code;
//import kr.co.crewmate.site.service.SystemService;
import kr.co.crewmate.site.utils.CodeHandler;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * 클래스명: <code>CodeTag</code>
 *
 * <pre>
 *  코드클래스와 코드이름을 받았을때 코드명을 리턴하는 커스텀테그
 *  
 *  ex) &lt;ui:code codeName="08" codeClass="orderStatCode"/&gt;
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 21.
 *
 */
@SuppressWarnings("serial")
public class CodeTag extends BodyTagSupport {

    /**
     * 코드클래스 
     */
    private String codeClass;
    
    /**
     * 코드이름
     */
    private String codeName;
    
    /**
     * 언어코드
     */
    private String langCode;
    
    @Override
    public int doEndTag() throws JspException {

        try {
            JspWriter out = pageContext.getOut();
//            Code code = getCode();
//            if (code != null) {
//                
//                if(StringUtils.isEmpty(langCode)){
//                    langCode = Config.getSiteNatnCode();
//                }
//                
//                if(StringUtils.equals(langCode, "KR")){
//                    out.print(code.getCodeValue());
//                }else{
//                    out.print(code.getCodeValueCn());
//                }
//            }

        } catch (Exception e) {
            throw new JspException();
        }

        return SKIP_BODY;
    }

//    private Code getCode() {
//        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(super.pageContext.getServletContext());
//        SystemService systemService = applicationContext.getBean(SystemService.class);
//        CodeHandler codeHandler = systemService.getCodeHandler();
//        Code code = codeHandler.getCode(Utils.javaVariableNamingToDbNaming(this.codeClass), this.codeName);
//        return code;
//    }

    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
