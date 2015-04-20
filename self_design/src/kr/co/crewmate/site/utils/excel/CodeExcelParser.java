package kr.co.crewmate.site.utils.excel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import kr.co.crewmate.site.model.common.Code;


/**
 * 
 * 클래스명: <code>CodeExcelParser</code>
 *
 * <pre>
 *  코드데이터 엑셀 일괄등록
 * </pre>
 *
 * @author newstar000
 * @date 2011. 11. 30.
 *
 */
public class CodeExcelParser extends ExcelParser<Code> {
    
    @SuppressWarnings("serial")
    private static final List<String> HEADERS = new ArrayList<String>() {
        {
            add("codeClass");
            add("codeName");
            add("codeValue");
            add("codeOrder");
            add("codeDescription");
            add("codeUserYn");
        }
    };
    
    private static final int HEADER_START_ROW = 1;
    
    private static final int DATA_START_ROW = 2;
    
    private static final int MAX_INSERT_COUNT = 1000;

    public CodeExcelParser() {
        super(HEADERS , HEADER_START_ROW, DATA_START_ROW, MAX_INSERT_COUNT);
    }

    @Override
    public Method[] getMethods() {
        return Code.class.getMethods();
    }

    @Override
    public Code getNewObject() {
        return new Code();
    }
}
