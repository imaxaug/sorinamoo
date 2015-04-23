package kr.co.crewmate.site.model.batch;

import java.util.ArrayList;
import java.util.List;

import kr.co.crewmate.site.model.ValidateParam;
import kr.co.crewmate.site.utils.MessageHandler;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

/**
 * 
 * 클래스명: <code>BatchParam</code>
 *
 * <pre>
 *   배치 조회/등록/수정 처리를 위한 모델 클래스
 * </pre>
 *
 * @author sist818
 * @date 2013. 3. 26.
 *
 */

@SuppressWarnings("serial")
public class BatchParam extends BatchMaster implements ValidateParam {

    private boolean regist = true;
    
    public BatchParam() {
        
    }

    public BatchParam(BatchMaster batch) {
        this.regist = false;
        BeanUtils.copyProperties(batch, this);
    }

    @Override
    public List<String> validate(MessageHandler messageHandler) {
        List<String> errorMessages = new ArrayList<String>();
        
        if(StringUtils.isEmpty(getId())) {
            errorMessages.add(messageHandler.getMessage("validate.required", Utils.getParam("배치아이디")));
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
