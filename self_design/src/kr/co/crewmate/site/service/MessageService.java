package kr.co.crewmate.site.service;

import java.util.List;

import kr.co.crewmate.site.model.common.Message;
import kr.co.crewmate.site.utils.MessageHandler;


public interface MessageService {

    void deleteMessage();

    void saveMessage(Message mesgList);

    List<Message> getListMessage();
    
    public MessageHandler getMessageHandler();

    List<Message> getMessageListForMessageHandler(String langCode);
    
    void reloadMessage();

}
