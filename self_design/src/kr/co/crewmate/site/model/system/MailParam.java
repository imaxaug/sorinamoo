package kr.co.crewmate.site.model.system;

import java.util.ArrayList;
import java.util.List;

import kr.co.crewmate.site.model.ValidateParam;
import kr.co.crewmate.site.utils.MessageHandler;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

@SuppressWarnings("serial")
public class MailParam extends MailQueue implements ValidateParam {

    private boolean regist = true;
    
    public MailParam() {
    }

    public MailParam(MailQueue mail) {
        this.regist = false;
        BeanUtils.copyProperties(mail, this);
    }

    @Override
    public List<String> validate(MessageHandler messageHandler) {
        List<String> errorMessages = new ArrayList<String>();
        
        if(StringUtils.isEmpty(getTitle())) {
            errorMessages.add(messageHandler.getMessage("validate.required", Utils.getParam("메일제목")));
        }
        
        if(StringUtils.isEmpty(getSenderName())) {
            errorMessages.add(messageHandler.getMessage("validate.required", Utils.getParam("송신자명")));
        }
        
        if(StringUtils.isEmpty(getSenderMailAddress())) {
            errorMessages.add(messageHandler.getMessage("validate.required", Utils.getParam("송신자메일주소")));
        }

        if(StringUtils.isEmpty(getContent())) {
            errorMessages.add(messageHandler.getMessage("validate.required", Utils.getParam("메일내용")));
        }
        
        if(StringUtils.isEmpty(getReceiverName())) {
            errorMessages.add(messageHandler.getMessage("validate.required", Utils.getParam("수신자명")));
        }
        
        if(StringUtils.isEmpty(getReceiverMailAddress())) {
            errorMessages.add(messageHandler.getMessage("validate.required", Utils.getParam("수신자메일주소")));
        }
        
        return errorMessages;
    }

    public boolean isRegist() {
        return regist;
    }

    public void setRegist(boolean regist) {
        this.regist = regist;
    }

}
