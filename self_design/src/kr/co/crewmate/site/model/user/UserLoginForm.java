package kr.co.crewmate.site.model.user;

import java.util.ArrayList;
import java.util.List;

import kr.co.crewmate.site.model.MessageValidator;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ParameterImpl;
import kr.co.crewmate.site.model.ToString;
import kr.co.crewmate.site.utils.MessageHandler;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.lang3.StringUtils;


/**
 * 클래스명: <code>UserLoginForm</code>
 *
 * <pre>
 *  회원 로그인 모델
 * </pre>
 *
 * @author 이경연
 * @date 2013. 5. 22.
 *
 */
public class UserLoginForm extends ToString implements MessageValidator {
    /**
     * 회원 아이디
     */
    private String userId;
    
    /**
     * 비밀번호
     */
    private String password;
    
    /**
     * 저장할 아이디
     */
    private boolean saveId;
    
    /**
     * 리다이렉트할 주소
     */
    private String redirectUrl;
    
    /**
     * 비회원 타입 
     */
    private String nonUserType;
    
    public String getNonUserType() {
        return nonUserType;
    }

    public void setNonUserType(String nonUserType) {
        this.nonUserType = nonUserType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSaveId() {
        return saveId;
    }

    public void setSaveId(boolean saveId) {
        this.saveId = saveId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public List<Parameter> validate(MessageHandler messageHandler) {
        List<Parameter> errorMessages = new ArrayList<Parameter>(2);
        if (StringUtils.isEmpty(this.userId)) {
            errorMessages.add(new ParameterImpl("userId", messageHandler.getMessage("validate.as.required", Utils.getParam("ID"))));
        }

        if (StringUtils.isEmpty(this.password)) {
            errorMessages.add(new ParameterImpl("password", messageHandler.getMessage("validate.as.required", Utils.getParam("Password"))));
        }
        
        return errorMessages;
    }
}
