package kr.co.crewmate.site.model.common;

import java.util.ArrayList;
import java.util.List;

import kr.co.crewmate.site.model.MessageValidator;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ParameterImpl;
import kr.co.crewmate.site.utils.MessageHandler;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;


/**
 * 
 * 클래스명: <code>CodeParam</code>
 *
 * <pre>
 *   코드 조회/등록/수정 처리를 위한 모델 클래스
 * </pre>
 *
 * @author smuft76
 * @date 2013. 3. 25.
 *
 */
@SuppressWarnings("serial")
public class CodeParam extends Code implements MessageValidator {
    
    private boolean regist = true;
    
    public CodeParam() {
        
    }

    public CodeParam(boolean b) {
        super(b);
    }

    public CodeParam(Code code) {
        this.regist = false;
        BeanUtils.copyProperties(code, this);
    }

    public boolean isRegist() {
        return regist;
    }

    public void setRegist(boolean regist) {
        this.regist = regist;
    }

    @Override
    public List<Parameter> validate(MessageHandler messageHandler) {
        List<Parameter> errorMessages = new ArrayList<Parameter>();
        
        if(StringUtils.isEmpty(getCodeClass())) {
            errorMessages.add(new ParameterImpl("codeClass", messageHandler.getMessage("validate.required", Utils.getParam("코드클래스"))));
        }
        
        if(StringUtils.isEmpty(getCodeName())) {
            errorMessages.add(new ParameterImpl("codeName", messageHandler.getMessage("validate.required", Utils.getParam("코드이름"))));
        }
        
        if(StringUtils.isEmpty(getCodeValue())) {
            errorMessages.add(new ParameterImpl("codeValue", messageHandler.getMessage("validate.required", Utils.getParam("코드값"))));
        }
        
        return errorMessages;
    }

}
