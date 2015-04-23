package kr.co.crewmate.site.dao.ibatis;

import java.util.List;

import kr.co.crewmate.site.dao.MailDao;
import kr.co.crewmate.site.model.system.MailCriteria;
import kr.co.crewmate.site.model.system.MailQueue;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SqlMapMailDao extends SqlMapClientDaoSupport implements MailDao {

    @Override
    public void saveMailQueue(MailQueue queue) {
        super.getSqlMapClientTemplate().insert("MailSQL.saveMailQueue", queue);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveMailQueueOtherTransaction(MailQueue queue) {
        super.getSqlMapClientTemplate().insert("MailSQL.saveMailQueue", queue);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<MailQueue> getMailQueueByNoSend() {
        return super.getSqlMapClientTemplate().queryForList("MailSQL.getMailQueueByNoSend");
    }

    @Override
    public void updateSendMailAfterSend(MailQueue queue) {
        super.getSqlMapClientTemplate().update("MailSQL.updateSendMailAfterSend", queue);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MailQueue> getMailQueueList(MailCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("MailSQL.getMailQueueList", criteria, criteria.getFetchScale(), criteria.getListSize());
    }

    @Override
    public int getMailQueueListCount(MailCriteria criteria) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("MailSQL.getMailQueueListCount", criteria);
    }

    @Override
    public MailQueue getMailQueueBySequence(int sequence) {
        return (MailQueue) super.getSqlMapClientTemplate().queryForObject("MailSQL.getMailQueueBySequence", sequence);
    }

    @Override
    public void sendEmsMailqueue(MailQueue mail) {
        super.getSqlMapClientTemplate().insert("MailSQL.sendEmsMailqueue", mail);
    }

}
