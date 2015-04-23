package kr.co.crewmate.site.dao.ibatis;

import java.util.Date;
import java.util.List;

import kr.co.crewmate.site.dao.SystemDao;
import kr.co.crewmate.site.model.SystemVariable;
//import kr.co.crewmate.site.model.admin.AdminLogin;
//import kr.co.crewmate.site.model.admin.AdminPowerParam;
//import kr.co.crewmate.site.model.admin.Menu;
import kr.co.crewmate.site.model.batch.BatchCriteria;
import kr.co.crewmate.site.model.batch.BatchHistory;
import kr.co.crewmate.site.model.batch.BatchMaster;
import kr.co.crewmate.site.model.batch.OrderFailureProcessor;
import kr.co.crewmate.site.model.common.Code;
import kr.co.crewmate.site.model.common.CodeCriteria;
import kr.co.crewmate.site.model.common.ExchangeRate;
import kr.co.crewmate.site.model.common.ExchangeRateCriteria;
import kr.co.crewmate.site.model.common.NewPostNum;
import kr.co.crewmate.site.model.common.PostBoxPostNum;
import kr.co.crewmate.site.model.common.PostNum;
import kr.co.crewmate.site.model.common.PostNumCriteria;
import kr.co.crewmate.site.model.common.Sequence;
import kr.co.crewmate.site.model.common.Work;
import kr.co.crewmate.site.model.common.WorkHistory;
import kr.co.crewmate.site.model.system.AdminChangeLog;
import kr.co.crewmate.site.model.system.AdminWorkHistory;
import kr.co.crewmate.site.model.system.History;
import kr.co.crewmate.site.model.system.HistoryCriteria;
import kr.co.crewmate.site.model.system.ShinsegaeMember;
import kr.co.crewmate.site.model.system.Table;
//import kr.co.crewmate.site.model.user.UserSaved;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SqlMapSystemDao extends SqlMapClientDaoSupport implements SystemDao {

    @Override
    public Date getDate() {
        return (Date) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getDate");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void savePostNum(NewPostNum postNum) {
        super.getSqlMapClientTemplate().insert("SystemSQL.savePostNum", postNum);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Code> getCodeList(CodeCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getCodeList", criteria, criteria.getFetchScale(), criteria.getListSize());
    }

    @Override
    public int getCodeListCount(CodeCriteria criteria) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getCodeListCount", criteria);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Code> getCodeListByCodeClass(String codeClass) {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getCodeListByCodeClass", codeClass);
    }

    @Override
    public void updateCode(Code code) {
        super.getSqlMapClientTemplate().update("SystemSQL.updateCode", code);
    }

    @Override
    public void createCode(Code code) {
        super.getSqlMapClientTemplate().insert("SystemSQL.createCode", code);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BatchMaster> getBatchList(BatchCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getBatchList", criteria, criteria.getFetchScale(), criteria.getListSize());
    }

    @Override
    public int getBatchListCount(BatchCriteria criteria) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getBatchListCount", criteria);
    }

    @Override
    public BatchMaster getBatchMaterId(String batchId) {
        return (BatchMaster) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getBatchMaterId", batchId);
    }

    @Override
    public void updateBatch(BatchMaster batch) {
        super.getSqlMapClientTemplate().update("SystemSQL.updateBatch", batch);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BatchHistory> getBatchDetail(BatchCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getBatchDetail", criteria, criteria.getFetchScale(), criteria.getListSize());
    }

    @Override
    public int getBatchDetailCount(BatchCriteria criteria) {
        return (Integer)super.getSqlMapClientTemplate().queryForObject("SystemSQL.getBatchDetailCount", criteria);
    }

    @Override
    public Sequence getSequenceByIdKey(Sequence sequence) {
        return (Sequence) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getSequenceByIdKey", sequence);
    }

    @Override
    public Sequence getSequenceById(String sequenceId) {
        return (Sequence) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getSequenceById", sequenceId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertSequenceDetail(Sequence sequence) {
        super.getSqlMapClientTemplate().insert("SystemSQL.insertSequenceDetail", sequence);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void increaseSequence(Sequence sequence) {
        super.getSqlMapClientTemplate().update("SystemSQL.increaseSequence", sequence);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Code> getCodeListForCodeHandler() {
        return (List<Code>) super.getSqlMapClientTemplate().queryForList("SystemSQL.getCodeListForCodeHandler");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PostNum> getPostNumListByDong(PostNumCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getPostNumListByDong", criteria, criteria.getFetchScale(), criteria.getListSize());
    }

    @Override
    public int getPostNumListCountByDong(PostNumCriteria criteria) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getPostNumListCountByDong", criteria);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NewPostNum> getPostNumListType1(PostNumCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getPostNumListType1", criteria, criteria.getFetchScale(), criteria.getListSize());
    }

    @Override
    public int getPostNumListCountType1(PostNumCriteria criteria) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getPostNumListCountType1", criteria);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NewPostNum> getPostNumListType2(PostNumCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getPostNumListType2", criteria, criteria.getFetchScale(), criteria.getListSize());
    }

    @Override
    public int getPostNumListCountType2(PostNumCriteria criteria) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getPostNumListCountType2", criteria);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NewPostNum> getPostNumListType4(PostNumCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getPostNumListType4", criteria, criteria.getFetchScale(), criteria.getListSize());
    }

    @Override
    public int getPostNumListCountType4(PostNumCriteria criteria) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getPostNumListCountType4", criteria);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PostBoxPostNum> getPostNumListType5(PostNumCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getPostNumListType5", criteria, criteria.getFetchScale(), criteria.getListSize());
    }

    @Override
    public int getPostNumListCountType5(PostNumCriteria criteria) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getPostNumListCountType5", criteria);
    }

    @Override
    public void saveWork(Work work) {
        super.getSqlMapClientTemplate().insert("SystemSQL.saveWork", work);
    }

    @Override
    public void saveWorkHistory(WorkHistory workHistory) {
        super.getSqlMapClientTemplate().insert("SystemSQL.saveWorkHistory", workHistory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Table> getTableList() {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getTableList");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<History> getWorkHistory(HistoryCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getWorkHistory", criteria, criteria.getFetchScale(), criteria.getListSize());
    }

    @Override
    public int getWorkHistoryCount(HistoryCriteria criteria) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getWorkHistoryCount", criteria);
    }

    @Override
    public void saveExchangeRate(ExchangeRate item) {
        super.getSqlMapClientTemplate().insert("SystemSQL.saveExchangeRate", item);
    }

    @Override
    public ExchangeRate getExchangeRateByDateForCache(String yyyymmdd) {
        return (ExchangeRate) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getExchangeRateByDateForCache", yyyymmdd);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExchangeRate> getExchangeRateList(ExchangeRateCriteria exchangeRateCriteria)  {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getExchangeRateList", exchangeRateCriteria);
    }

    @Override
    public void insertCharsetTest(String testString) {
        super.getSqlMapClientTemplate().insert("SystemSQL.insertCharsetTest", testString);
    }

    @Override
    public String getCharsetTest() {
        return (String) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getCharsetTest");
    }

    @Override
    public SystemVariable getSystemVariable() {
        return (SystemVariable) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getSystemVariable");
    }

    @Override
    public void updateSystemVariableByPopRcmndWord(SystemVariable systemVariable) {
        super.getSqlMapClientTemplate().update("SystemSQL.updateSystemVariableByPopRcmndWord", systemVariable);
    }

    @Override
    public void updateSystemVariableByCartChrgDscntCont(SystemVariable systemVariable) {
        super.getSqlMapClientTemplate().update("SystemSQL.updateSystemVariableByCartChrgDscntCont", systemVariable);
    }

    @Override
    public void updateCnrBatchYn(SystemVariable systemVariable) {
        super.getSqlMapClientTemplate().update("SystemSQL.updateCnrBatchYn", systemVariable);
    }

    @Override
    public void deleteFlightSchedule() {
        super.getSqlMapClientTemplate().delete("SystemSQL.deleteFlightSchedule");
    }

    @Override
    public void saveFlightSchedule() {
        super.getSqlMapClientTemplate().insert("SystemSQL.saveFlightSchedule");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteShinsegaeMember() {
        super.getSqlMapClientTemplate().delete("SystemSQL.deleteShinsegaeMember");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertShinsegaeMember(ShinsegaeMember member) {
        super.getSqlMapClientTemplate().insert("SystemSQL.insertShinsegaeMember", member);
    }

    @Override
    public void addOrderNum(String orderNum) {
        super.getSqlMapClientTemplate().insert("SystemSQL.addOrderNum", orderNum);
    }

    @Override
    public void insertShinsegaeMemberDblink() {
        super.getSqlMapClientTemplate().insert("SystemSQL.insertShinsegaeMemberDblink");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getOldPrdtDesc() {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getOldPrdtDesc");
    }

    @Override
    public void addTempImage(String image) {
        super.getSqlMapClientTemplate().insert("SystemSQL.addTempImage", image);
    }


    @Override
    public int getWeekDay() {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getWeekDay");
    }

    @Override
    public String getTime() {
        return (String) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getTime");
    }

    @Override
    public int getSaveTime() {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getSaveTime");
    }

    @Override
    public void insertLookHistory(AdminWorkHistory adminWorkHistory) {
        super.getSqlMapClientTemplate().insert("SystemSQL.insertLookHistory", adminWorkHistory);
    }

    @Override
    public void insertadminChangeLog(AdminChangeLog adminChangeLog) {
        super.getSqlMapClientTemplate().insert("SystemSQL.insertadminChangeLog", adminChangeLog);
    }

    @Override
    public String getDay() {
        return (String) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getDay");
    }

    @Override
    public String getToday() {
        return (String) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getToday");
    }

    @Override
    public boolean isOrderUseYn(String batchName) {
        return (Boolean) super.getSqlMapClientTemplate().queryForObject("SystemSQL.isOrderUseYn", batchName);
    }

    @Override
    public int getOrderCount(int minute) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getOrderCount", minute);
    }

    @Override
    public int getOrderCountKR(int minute) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getOrderCountKR", minute);
    }

    @Override
    public int getOrderCountCN(int minute) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getOrderCountCN", minute);
    }

    @Override
    public int getOrderFailureCount(int minute) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getOrderFailureCount", minute);
    }

    @Override
    public OrderFailureProcessor getOrderFailureTotalCount(int minute) {
        return (OrderFailureProcessor) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getOrderFailureTotalCount", minute);
    }

    @Override
    public void saveAdminWork(Work work) {
        super.getSqlMapClientTemplate().insert("SystemSQL.saveAdminWork", work);
    }

    @Override
    public void saveAdminWorkHistory(WorkHistory workHistory) {
        super.getSqlMapClientTemplate().insert("SystemSQL.saveAdminWorkHistory", workHistory);
    }

    @Override
    public List<History> getAdminWorkHistory(HistoryCriteria criteria) {
        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getAdminWorkHistory", criteria, criteria.getFetchScale(), criteria.getListSize());
    }

    @Override
    public int getAdminWorkHistoryCount(HistoryCriteria criteria) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getAdminWorkHistoryCount", criteria);
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public List<Menu> getAdminGroupMenuById(AdminPowerParam adminPowerParam) {
//        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getAdminGroupMenuById", adminPowerParam);
//    }

    @Override
    public void saveAdminMenuWorkHistory(WorkHistory workHistory) {
        super.getSqlMapClientTemplate().insert("SystemSQL.saveAdminMenuWorkHistory", workHistory);
    }

//    @Override
//    public List<AdminLogin> getUserLoginHistory(HistoryCriteria criteria) {
//        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getUserLoginHistory", criteria, criteria.getFetchScale(), criteria.getListSize());
//    }

    @Override
    public int getUserLoginHistoryCount(HistoryCriteria criteria) {
        return (Integer) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getUserLoginHistoryCount", criteria);
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public List<UserSaved> getUserSaved() {
//        return super.getSqlMapClientTemplate().queryForList("SystemSQL.getUserSaved");
//    }

    @Override
    public String getCommmonValue(String codeKey){
        return (String) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getCommmonValue", codeKey);
    }

    @Override
    public String getTodayEN() {
        return (String) super.getSqlMapClientTemplate().queryForObject("SystemSQL.getTodayEN");
    }
}
