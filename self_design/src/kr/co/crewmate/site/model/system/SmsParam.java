package kr.co.crewmate.site.model.system;

import java.util.ArrayList;
import java.util.List;

import kr.co.crewmate.site.model.MessageValidator;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ParameterImpl;
import kr.co.crewmate.site.utils.MessageHandler;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
public class SmsParam extends Sms implements MessageValidator {
    
    private String userId;
    
    private String userPswd;
    
    private String hpTelNum;
    
    public SmsParam() {
        this.setSmsSendCode("SMS");
    }

    @Override
    public List<Parameter> validate(MessageHandler messageHandler) {
        List<Parameter> errorMessages = new ArrayList<Parameter>();
        
        
        if(StringUtils.isEmpty(getRecvTelNum())) {
            errorMessages.add(new ParameterImpl("recvTelNum", messageHandler.getMessage("validate.required", Utils.getParam("받는 번호"))));
        }
        
        if(StringUtils.isEmpty(getSendTelNum())) {
            errorMessages.add(new ParameterImpl("sendTelNum", messageHandler.getMessage("validate.required", Utils.getParam("보내는 번호"))));
        }
        
        if(!"SMS".equals(getSmsSendCode())){
            if(StringUtils.isEmpty(getSmsTitle())) {
                errorMessages.add(new ParameterImpl("smsTitle", messageHandler.getMessage("validate.required", Utils.getParam("SMS 제목"))));
            }
        }
        if(StringUtils.isEmpty(getSmsCont()) || "".equals(getSmsCont().trim())) {
            errorMessages.add(new ParameterImpl("smsCont", messageHandler.getMessage("validate.required", Utils.getParam("SMS 내용"))));
        }
        
        return errorMessages;
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHpTelNum() {
        return hpTelNum;
    }

    public void setHpTelNum(String hpTelNum) {
        this.hpTelNum = hpTelNum;
    }
    
}
