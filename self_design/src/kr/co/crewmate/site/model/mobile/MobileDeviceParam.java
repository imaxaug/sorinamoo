package kr.co.crewmate.site.model.mobile;

import java.util.ArrayList;
import java.util.List;

import kr.co.crewmate.site.model.MessageValidator;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ParameterImpl;
import kr.co.crewmate.site.utils.MessageHandler;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

public class MobileDeviceParam extends MobileDevice implements MessageValidator {

    public MobileDeviceParam() {
        
    }
    
    public MobileDeviceParam(MobileDevice mobileDevice) {
        BeanUtils.copyProperties(mobileDevice, this);
    }

    @Override
    public List<Parameter> validate(MessageHandler messageHandler) {
        List<Parameter> errorMessages = new ArrayList<Parameter>();
        
        if(StringUtils.isEmpty(getMblDvcCode())) {
            errorMessages.add(new ParameterImpl("mblDvcCode", messageHandler.getMessage("validate.required", Utils.getParam("모바일디바이스 코드"))));
        }
        
        if(StringUtils.isEmpty(getDvcToken())) {
            errorMessages.add(new ParameterImpl("dvcToken", messageHandler.getMessage("validate.required", Utils.getParam("디바이스 토큰"))));
        }
        
        return errorMessages;
    }
    
    public List<Parameter> updateValidate(MessageHandler messageHandler) {
        List<Parameter> errorMessages = new ArrayList<Parameter>();
        
        if(StringUtils.isEmpty(getMblDvcCode())) {
            errorMessages.add(new ParameterImpl("mblDvcCode", messageHandler.getMessage("validate.required", Utils.getParam("모바일디바이스 코드"))));
        }
        
        if(StringUtils.isEmpty(getDvcToken())) {
            errorMessages.add(new ParameterImpl("dvcToken", messageHandler.getMessage("validate.required", Utils.getParam("디바이스 토큰"))));
        }
        
        if(StringUtils.isEmpty(getUserId())) {
            errorMessages.add(new ParameterImpl("userId", messageHandler.getMessage("validate.required", Utils.getParam("디바이스 토큰"))));
        }
        
        return errorMessages;
    }
}
