package kr.co.crewmate.site.utils;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.common.Message;

/**
 * 클래스명: <code>MessageHandler</code>
 * 
 * <pre>
 *  설명을 기입하세요
 * </pre>
 * 
 * @author 최홍석
 * @date 2013. 7. 26.
 * 
 */
public class MessageHandler {

    final Log log = LogFactory.getLog(this.getClass());
    
    final Map<String, MessageMap> locales = new HashMap<String, MessageMap>(4);

    @SuppressWarnings("serial")
    static class MessageMap extends HashMap<String, String> {

    }

    private List<Message> MessageKR;

    private List<Message> MessageCN;

    private List<Message> MessageJP;

    private List<Message> MessageEN;

    private MessageMap messagesIndexKR = new MessageMap();

    private MessageMap messagesIndexCN = new MessageMap();

    private MessageMap messagesIndexJP = new MessageMap();

    private MessageMap messagesIndexEN = new MessageMap();

    private String defaltLocaleCode = Config.getSiteNatnCode();

    public MessageHandler() {

    }

    public MessageHandler(List<Message> MessageK, List<Message> MessageC, List<Message> MessageJ, List<Message> MessageE) {
        this.locales.put("KR", this.messagesIndexKR);
        this.locales.put("CN", this.messagesIndexCN);
        this.locales.put("EN", this.messagesIndexEN);
        this.locales.put("JP", this.messagesIndexJP);

        this.MessageKR = MessageK;
        this.MessageCN = MessageC;
        this.MessageJP = MessageJ;
        this.MessageEN = MessageE;
        
        init();
    }

    private void init() {
        
        for (Message mesg : MessageKR) {
            messagesIndexKR.put(mesg.getMesgKey(), mesg.getMesgCont());
        }
        for (Message mesg : MessageCN) {
            messagesIndexCN.put(mesg.getMesgKey(), mesg.getMesgCont());
        }
        for (Message mesg : MessageJP) {
            messagesIndexJP.put(mesg.getMesgKey(), mesg.getMesgCont());
        }
        for (Message mesg : MessageEN) {
            messagesIndexEN.put(mesg.getMesgKey(), mesg.getMesgCont());
        }
    }

    public String getMessage(String mesgKey, String langCode) {
        String locale = StringUtils.isEmpty(langCode) ? Config.getSiteNatnCode(): langCode;
        return getMessage(mesgKey, locale, null);
    }
    
    public String getMessage(String mesgKey) {
        return getMessage(mesgKey, Config.getSiteNatnCode(), null);
    }

    public String getMessage(String mesgKey, Object[] objects) {
        return getMessage(mesgKey, Config.getSiteNatnCode(), objects);
    }

    public String getMessage(String mesgKey, String langCode, Object[] objects) {
        String resultMessageKey = null;
        MessageMap messageMap = this.locales.get(langCode);
        if (messageMap == null) {
            messageMap = this.locales.get(this.defaltLocaleCode);
        }

        resultMessageKey = messageMap.get(mesgKey);
        if (resultMessageKey == null) {
            messageMap = this.locales.get(this.defaltLocaleCode);
            resultMessageKey = messageMap.get(mesgKey);
        }

        if (resultMessageKey == null) {
            resultMessageKey = String.format("No Message[%s:%s]", mesgKey, langCode);
        }

        return MessageFormat.format(resultMessageKey, objects);
    }

}
