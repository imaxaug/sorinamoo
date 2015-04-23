package kr.co.crewmate.site.service;

import java.util.List;

import kr.co.crewmate.site.model.ListResult;
import kr.co.crewmate.site.model.system.MailCriteria;
import kr.co.crewmate.site.model.system.MailQueue;

public interface MailService {

    void saveMailQueue(MailQueue queue);

    List<MailQueue> getMailQueueByNoSend();

    void updateSendMailAfterSend(MailQueue queue);

    ListResult<MailQueue> getMailQueueList(MailCriteria criteria);

    MailQueue getMailQueueBySequence(int sequence);

    void sendDirect(MailQueue mail);

    void saveMailQueueOtherTransaction(MailQueue queue);

    void sendEmsMailqueue(MailQueue mail);

    void save(MailQueue mail);

}
