package kr.co.crewmate.site.dao;

import java.util.Date;
import java.util.List;

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

public interface SystemDao {

    Date getDate();

    void savePostNum(NewPostNum postNum);

    List<Code> getCodeList(CodeCriteria criteria);

    int getCodeListCount(CodeCriteria criteria);

    List<Code> getCodeListByCodeClass(String codeClass);

    void updateCode(Code code);

    void createCode(Code code);

    List<BatchMaster> getBatchList(BatchCriteria criteria);

    int getBatchListCount(BatchCriteria criteria);

    Sequence getSequenceByIdKey(Sequence sequence);

    Sequence getSequenceById(String sequenceId);

    void insertSequenceDetail(Sequence sequence);

    void increaseSequence(Sequence sequence);

    BatchMaster getBatchMaterId(String batchId);

    void updateBatch(BatchMaster batch);

    List<BatchHistory> getBatchDetail(BatchCriteria criteria);

    int getBatchDetailCount(BatchCriteria criteria);

    List<Code> getCodeListForCodeHandler();

    List<PostNum> getPostNumListByDong(PostNumCriteria criteria);

    int getPostNumListCountByDong(PostNumCriteria criteria);

    List<NewPostNum> getPostNumListType1(PostNumCriteria criteria);

    int getPostNumListCountType1(PostNumCriteria criteria);

    List<NewPostNum> getPostNumListType2(PostNumCriteria criteria);

    int getPostNumListCountType2(PostNumCriteria criteria);

    List<NewPostNum> getPostNumListType4(PostNumCriteria criteria);

    int getPostNumListCountType4(PostNumCriteria criteria);

    List<PostBoxPostNum> getPostNumListType5(PostNumCriteria criteria);

    int getPostNumListCountType5(PostNumCriteria criteria);

    void saveWork(Work work);

    void saveAdminWork(Work work);

    void saveWorkHistory(WorkHistory workHistory);

    void saveAdminWorkHistory(WorkHistory workHistory);

    /**
     * 테이블의 정보를 리스트로 반환
     * @return
     */
    List<Table> getTableList();

    List<History> getWorkHistory(HistoryCriteria criteria);

    List<History> getAdminWorkHistory(HistoryCriteria criteria);

//    List<AdminLogin> getUserLoginHistory(HistoryCriteria criteria);

    int getWorkHistoryCount(HistoryCriteria criteria);

    int getAdminWorkHistoryCount(HistoryCriteria criteria);

    int getUserLoginHistoryCount(HistoryCriteria criteria);

    void saveExchangeRate(ExchangeRate item);

    ExchangeRate getExchangeRateByDateForCache(String yyyymmdd);

    List<ExchangeRate> getExchangeRateList(ExchangeRateCriteria exchangeRateCriteria) ;

    void insertCharsetTest(String testString);

    String getCharsetTest();

    SystemVariable getSystemVariable();

    void updateSystemVariableByPopRcmndWord(SystemVariable systemVariable);

    void updateSystemVariableByCartChrgDscntCont(SystemVariable systemVariable);

    void updateCnrBatchYn(SystemVariable systemVariable);

    void deleteFlightSchedule();

    void saveFlightSchedule();

    void deleteShinsegaeMember();

    void insertShinsegaeMember(ShinsegaeMember member);

    void addOrderNum(String orderNum);

    void insertShinsegaeMemberDblink();

    List<String> getOldPrdtDesc();

    void addTempImage(String image);

    int getWeekDay();

    String getTime();

    int getSaveTime();

    void insertLookHistory(AdminWorkHistory adminWorkHistory);

	void insertadminChangeLog(AdminChangeLog adminChangeLog);

	String getDay();

	String getToday();

	String getTodayEN();

	boolean isOrderUseYn(String batchName);

	int getOrderCount(int minute);

	int getOrderCountKR(int minute);

	int getOrderCountCN(int minute);

	int getOrderFailureCount(int minute);

	OrderFailureProcessor getOrderFailureTotalCount(int minute);

//	List<Menu> getAdminGroupMenuById(AdminPowerParam adminPowerParam) ;

	void saveAdminMenuWorkHistory(WorkHistory workHistory);

//	List<UserSaved> getUserSaved();

	String getCommmonValue(String codeKey);
}
