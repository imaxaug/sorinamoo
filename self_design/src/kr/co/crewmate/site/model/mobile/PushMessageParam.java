package kr.co.crewmate.site.model.mobile;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import kr.co.crewmate.site.model.MessageValidator;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ParameterImpl;
import kr.co.crewmate.site.utils.MessageHandler;
import kr.co.crewmate.site.utils.Utils;

public class PushMessageParam extends PushMessage implements MessageValidator {
    

    @Override
    public List<Parameter> validate(MessageHandler messageHandler) {
        List<Parameter> errorMessages = new ArrayList<Parameter>();
        
        if(StringUtils.isEmpty(getSendStartDt())) {
            errorMessages.add(new ParameterImpl("sendStartDt", messageHandler.getMessage("validate.as.required", Utils.getParam("발송시작일자"))));
        }
        
        if(StringUtils.isEmpty(getSendEndDt())) {
            errorMessages.add(new ParameterImpl("sendEndDt", messageHandler.getMessage("validate.as.required", Utils.getParam("발송종료일자"))));
        }
        
//        if(StringUtils.isEmpty(getValidEndDt())) {
//            errorMessages.add(new ParameterImpl("vaildEndDt", messageHandler.getMessage("validate.as.required", Utils.getParam("유효종료일자"))));
//        }
        if(!StringUtils.equals(getTestYn(), "Y")){
        	if(getUserGradeIds() == null){
        		errorMessages.add(new ParameterImpl("userGradeIds", messageHandler.getMessage("validate.no.seleted.required", Utils.getParam("발송대상"))));
        	}
        }
        
        if(StringUtils.equals(getWeekId(), "00000000")){
            errorMessages.add(new ParameterImpl("weekId", messageHandler.getMessage("validate.no.seleted.required", Utils.getParam("요일"))));
        }
        
        if(StringUtils.isEmpty(getMesgDsc())) {
            errorMessages.add(new ParameterImpl("mesgDsc", messageHandler.getMessage("validate.as.required", Utils.getParam("메세지 내용"))));
        }
        
        if(!StringUtils.isEmpty(getSendStartDt()) && !StringUtils.isEmpty(getSendEndDt())){
            if(Integer.parseInt(getSendStartDt().replace("-", "")) > Integer.parseInt(getSendEndDt().replace("-", ""))){
                errorMessages.add(new ParameterImpl("alert", messageHandler.getMessage("validate.larger.then", Utils.getParam("발송시작일시", "발송종료일시"))));
            }
        }
        
        if(!StringUtils.isEmpty(getSendEndDt()) && !StringUtils.isEmpty(getValidEndDt())){
            if(Integer.parseInt(getSendEndDt().replace("-", "")) > Integer.parseInt(getValidEndDt().replace("-", ""))){
                errorMessages.add(new ParameterImpl("alert", messageHandler.getMessage("validate.larger.then", Utils.getParam("유효종료일자", "발송종료일시"))));
            }
        }
        
        return errorMessages;
    }

}
