package kr.co.crewmate.site.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import kr.co.crewmate.site.dao.MailDao;
import kr.co.crewmate.site.model.ListResult;
import kr.co.crewmate.site.model.system.MailCriteria;
import kr.co.crewmate.site.model.system.MailQueue;
import kr.co.crewmate.site.service.MailService;
import kr.co.crewmate.site.service.MessageService;
import kr.co.crewmate.site.service.SequenceService;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MailServiceImpl implements MailService {
    
    final Log log = LogFactory.getLog(this.getClass());
    
    @Inject
    private MailDao mailDao;
    
   /* @Inject
    JavaMailSender mailSender;*/

    @Inject
    SequenceService sequenceService;
    
    @Inject
    MessageService messageService;

    @Override
    public void saveMailQueue(MailQueue queue) {
        this.mailDao.saveMailQueue(queue);
    }
    
    @Override
    public void saveMailQueueOtherTransaction(MailQueue queue) {
        this.mailDao.saveMailQueueOtherTransaction(queue);
    }


    @Override
    public List<MailQueue> getMailQueueByNoSend() {
        return this.mailDao.getMailQueueByNoSend();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateSendMailAfterSend(MailQueue queue) {
        this.mailDao.updateSendMailAfterSend(queue);
    }

    @Override
    public ListResult<MailQueue> getMailQueueList(MailCriteria criteria) {
        ListResult<MailQueue> result = new ListResult<MailQueue>();
        result.setList(this.mailDao.getMailQueueList(criteria));
        result.setListCount(this.mailDao.getMailQueueListCount(criteria));
        return result;
    }

    @Override
    public MailQueue getMailQueueBySequence(int sequence) {
        MailQueue mailQueue = this.mailDao.getMailQueueBySequence(sequence);
        if (mailQueue == null) {
            throw new RuntimeException(this.messageService.getMessageHandler().getMessage("validate.not.exist", Utils.getParam(sequence, "관리자아이디")));
        }
        
        return mailQueue;
    }

    @Override
    public void sendDirect(MailQueue mail) {
        Date now = new Date();
        mail.setSendDatetime(now);
        mail.setSendGbn(null);
        this.saveMailQueueOtherTransaction(mail);
        this.updateSendMailAfterSend(mail);
        
        sendEmsMailqueue(mail);
        
      /*  try {
            mail.send(this.mailSender);
        } catch (Exception e) {
            mail.setSendGbn(MailQueue.FAILURE);
            mail.setSendFailureReason(Utils.getExceptionTraceToString(e));
        } finally {
            this.updateSendMailAfterSend(mail);
        }*/
    }

    @Override
    public void sendEmsMailqueue(MailQueue mail) {
        this.mailDao.sendEmsMailqueue(mail);
    }

    @Override
    public void save(MailQueue mail) {
        this.saveMailQueueOtherTransaction(mail);
    }
}
