package kr.co.crewmate.site.service.impl;

import java.util.List;

import javax.inject.Inject;

import kr.co.crewmate.site.dao.MessageDao;
import kr.co.crewmate.site.model.common.Message;
import kr.co.crewmate.site.service.MessageService;
import kr.co.crewmate.site.utils.MessageHandler;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Inject
    private MessageDao messageDao;
    
    private MessageHandler messageHandler;
    
    @Override
    public void deleteMessage() {
        this.messageDao.deleteMessage();
    }

    @Override
    public void saveMessage(Message mesgList) {
        this.messageDao.saveMessage(mesgList);
    }

    @Override
    public List<Message> getListMessage() {
        return this.messageDao.getListMessage(null);
    }

    @Override
    public MessageHandler getMessageHandler() {
        if (this.messageHandler == null) {
            synchronized (this) {
                this.messageHandler = new MessageHandler(this.getMessageListForMessageHandler("KR"),
                                                         this.getMessageListForMessageHandler("CN"),
                                                         this.getMessageListForMessageHandler("JP"),
                                                         this.getMessageListForMessageHandler("EN")
                                                         );
            }
        }
        return messageHandler;
    }

    @Override
    public List<Message> getMessageListForMessageHandler(String langCode) {
        return this.messageDao.getListMessage(langCode);
    }

    @Override
    public void reloadMessage() {
        synchronized (this) {
            this.messageHandler = new MessageHandler(this.getMessageListForMessageHandler("KR"),
                                                     this.getMessageListForMessageHandler("CN"),
                                                     this.getMessageListForMessageHandler("JP"),
                                                     this.getMessageListForMessageHandler("EN")
                                                     );
        }
    }
    

}
