package kr.co.crewmate.site.utils.excel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import kr.co.crewmate.site.model.common.Message;


public class MessageExcelParser extends ExcelParser<Message> {
    
    @SuppressWarnings("serial")
    private static final List<String> HEADERS = new ArrayList<String>() {
        {
            add("mesgKey");
            add("langCode");
            add("mesgCont");
        }
    };
    
    private static final int HEADER_START_ROW = 0;
    
    private static final int DATA_START_ROW = 1;
    
    private static final int MAX_INSERT_COUNT = 10000;

    public MessageExcelParser() {
        super(HEADERS , HEADER_START_ROW, DATA_START_ROW, MAX_INSERT_COUNT);
    }

    @Override
    public Method[] getMethods() {
        return Message.class.getMethods();
    }

    @Override
    public Message getNewObject() {
        return new Message();
    }
}
