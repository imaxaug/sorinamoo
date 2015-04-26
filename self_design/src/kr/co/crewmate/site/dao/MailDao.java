package kr.co.crewmate.site.dao;

import java.util.List;

import kr.co.crewmate.site.model.system.MailCriteria;
import kr.co.crewmate.site.model.system.MailQueue;

public interface MailDao {

    void saveMailQueue(MailQueue queue);

    List<MailQueue> getMailQueueByNoSend();

    void updateSendMailAfterSend(MailQueue queue);

    List<MailQueue> getMailQueueList(MailCriteria criteria);

    int getMailQueueListCount(MailCriteria criteria);

    MailQueue getMailQueueBySequence(int sequence);

    void saveMailQueueOtherTransaction(MailQueue queue);

    void sendEmsMailqueue(MailQueue mail);

}
