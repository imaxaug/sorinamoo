package kr.co.crewmate.site.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ToString;
import kr.co.crewmate.site.utils.MessageHandler;

/**
 * 클래스명: <code>User</code>
 *
 * <pre>
 *  회원 정보를 저장하는 모델 클래스
 * </pre>
 *
 * @author 이경연
 * @date 2013. 5. 22.
 *
 */
public class User extends ToString {
    private String userId;
    private String password;
    private Date createDate;
    private Date lastUpdate;
    private String hpNum;
    private String birthDate;
    private boolean recvEmailYn;
    private boolean recvSmsYn;
    private String recvDate;
    private boolean accessTermsYn;
    private boolean personalTermsYn;
    private int aliasId;
    private String nickName;
    private boolean newPswdYn;
    private String pswd;
    private String email;
    private String mobile;
    private String mobile01;
    private String mobile02;
    private String mobile03;
    private String birthYear;
    private String birthMonth;
    private String birthDay;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobile01() {
		return mobile01;
	}
	public void setMobile01(String mobile01) {
		this.mobile01 = mobile01;
	}
	public String getMobile02() {
		return mobile02;
	}
	public void setMobile02(String mobile02) {
		this.mobile02 = mobile02;
	}
	public String getMobile03() {
		return mobile03;
	}
	public void setMobile03(String mobile03) {
		this.mobile03 = mobile03;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getHpNum() {
		return hpNum;
	}
	public void setHpNum(String hpNum) {
		this.hpNum = hpNum;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getRecvDate() {
		return recvDate;
	}
	public void setRecvDate(String recvDate) {
		this.recvDate = recvDate;
	}
	public int getAliasId() {
		return aliasId;
	}
	public void setAliasId(int aliasId) {
		this.aliasId = aliasId;
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
    public boolean isNewPswdYn() {
        return newPswdYn;
    }
    public void setNewPswdYn(boolean newPswdYn) {
        this.newPswdYn = newPswdYn;
    }
	public boolean isRecvEmailYn() {
		return recvEmailYn;
	}
	public void setRecvEmailYn(boolean recvEmailYn) {
		this.recvEmailYn = recvEmailYn;
	}
	public boolean isRecvSmsYn() {
		return recvSmsYn;
	}
	public void setRecvSmsYn(boolean recvSmsYn) {
		this.recvSmsYn = recvSmsYn;
	}
	public boolean isAccessTermsYn() {
		return accessTermsYn;
	}
	public void setAccessTermsYn(boolean accessTermsYn) {
		this.accessTermsYn = accessTermsYn;
	}
	public boolean isPersonalTermsYn() {
		return personalTermsYn;
	}
	public void setPersonalTermsYn(boolean personalTermsYn) {
		this.personalTermsYn = personalTermsYn;
	}

	public List<Parameter> validate(MessageHandler messageHandler, String create) {
        List<Parameter> errorMessages = new ArrayList<Parameter>();

        /*
        1. 이메일 형식 체크
        String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";

    	2. 숫자만 입력 체크
        String regex = "^[0-9]+$";  // 정수형만 체크
       	String regex = "^[+-]?\\d*(\\.?\\d*)$";  //실수형까지 체크

    	3. 아이디 형식 체크
        String regex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
          예) 시작은 영문으로만, '_'를 제외한 특수문자 안되며 영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하
        */

        Pattern p = Pattern.compile("[0-9a-zA-Z]*");
//        Matcher m = p.matcher(getUserId());
        Matcher m = p.matcher(getEmail());
        boolean b = m.matches();

//        if(StringUtils.isEmpty(getUserId())) {
//            errorMessages.add(new ParameterImpl("userId", messageHandler.getMessage("validate.required", Utils.getParam("회원아이디"))));
//        } else if (getUserId().length() < 5) {
//            errorMessages.add(new ParameterImpl("userId", messageHandler.getMessage("validate.larger.then", Utils.getParam("회원아이디", "5자"))));
//        } else if (getUserId().length() > 15) {
//            errorMessages.add(new ParameterImpl("userId", messageHandler.getMessage("validate.less.then", Utils.getParam("회원아이디", "15자"))));
//        } else if (!b) {
//            errorMessages.add(new ParameterImpl("userId", messageHandler.getMessage("validate.userid.only.eng.num")));
//        }
//
//        m = p.matcher(getPswd());
//        b = m.matches();
//
//        if(StringUtils.isEmpty(getPswd())) {
//            errorMessages.add(new ParameterImpl("pswd", messageHandler.getMessage("validate.required", Utils.getParam("비밀번호"))));
//        } else if (getPswd().length() < 8) {
//            errorMessages.add(new ParameterImpl("pswd", messageHandler.getMessage("validate.larger.then", Utils.getParam("비밀번호", "8자"))));
////        } else if (getPswd().length() > 15) {
////            errorMessages.add(new ParameterImpl("pswd", messageHandler.getMessage("validate.less.then", Utils.getParam("비밀번호", "15자"))));
//        } else if (!b) {
//            errorMessages.add(new ParameterImpl("pswd", messageHandler.getMessage("error.regex.password")));
//        }
//
//        if (StringUtils.isEmpty(getBirthDt())) {
//            errorMessages.add(new ParameterImpl("brithDt", messageHandler.getMessage("validate.required", Utils.getParam("생년월일"))));
//        }
//
//        if (isLocalYn()) {
//            if (StringUtils.isEmpty(getHpTelNum())) {
//                errorMessages.add(new ParameterImpl("hpTelNum", messageHandler.getMessage("validate.required", Utils.getParam("휴대폰"))));
//            }
//        }
//
//        if (StringUtils.isEmpty(getMailAddr())) {
//            errorMessages.add(new ParameterImpl("mailAddr", messageHandler.getMessage("validate.required", Utils.getParam("이메일"))));
//        }

        return errorMessages;
    }
}