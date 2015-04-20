package kr.co.crewmate.site.utils.excel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import kr.co.crewmate.site.model.common.Code;
import kr.co.crewmate.site.model.user.User;


/**
 * 
 * 클래스명: <code>UserExcelParser</code>
 *
 * <pre>
 *  회원 엑셀 일괄등록
 *  CodeExcelParser 에서 수정
 * </pre>
 *
 * @author eyetui
 * @date 2011. 11. 30.
 *
 */
public class UserExcelParser extends ExcelParser<User> {
    
    @SuppressWarnings("serial")
    private static final List<String> HEADERS = new ArrayList<String>() {
        {
            add("userId");
        }
    };
    
    private static final int HEADER_START_ROW = 0;
    
    private static final int DATA_START_ROW = 1;
    
    private static final int MAX_INSERT_COUNT = 1000;

    public UserExcelParser() {
        super(HEADERS , HEADER_START_ROW, DATA_START_ROW, MAX_INSERT_COUNT);
    }

    @Override
    public Method[] getMethods() {
        return User.class.getMethods();
    }

    @Override
    public User getNewObject() {
        return new User();
    }
}
