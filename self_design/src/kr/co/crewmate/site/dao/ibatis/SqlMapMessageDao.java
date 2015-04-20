package kr.co.crewmate.site.dao.ibatis;

import java.util.List;

import kr.co.crewmate.site.dao.MessageDao;
import kr.co.crewmate.site.model.common.Message;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SqlMapMessageDao extends SqlMapClientDaoSupport implements MessageDao {

    @Override
    public void deleteMessage() {
        super.getSqlMapClientTemplate().delete("MessageSQL.deleteMessage");
    }

    @Override
    public void saveMessage(Message mesgList) {
        super.getSqlMapClientTemplate().insert("MessageSQL.saveMessage", mesgList);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Message> getListMessage(String langCode) {
        return super.getSqlMapClientTemplate().queryForList("MessageSQL.getListMessage", langCode);
    }


}
