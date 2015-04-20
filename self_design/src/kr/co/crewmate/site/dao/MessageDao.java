package kr.co.crewmate.site.dao;

import java.util.List;

import kr.co.crewmate.site.model.common.Message;


public interface MessageDao {

    void deleteMessage();

    void saveMessage(Message mesgList);

    List<Message> getListMessage(String langCode);

}
