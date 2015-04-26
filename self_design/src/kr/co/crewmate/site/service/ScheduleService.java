package kr.co.crewmate.site.service;

import java.util.List;

import kr.co.crewmate.site.model.batch.OrderNextParam;
//import kr.co.crewmate.site.model.batch.TenPayNotOrder;
//import kr.co.crewmate.site.model.event.EventEntryJoinParam;
//import kr.co.crewmate.site.model.event.EventParam;
//import kr.co.crewmate.site.model.promotion.OrderStamp;
//import kr.co.crewmate.site.model.promotion.WeddingGradeChange;
//import kr.co.crewmate.site.model.user.UserGradeChange;

public interface ScheduleService {

    void removeCartBy3Day();

    void removeSpecialCart();

    List<String> getAvailBenefitOrderNum();

    void benefit(String orderNum);

    void insertNaverProduct();

    void loadTotalHtml();

    void loadTotalTgHtml();

    void loadSearchCatgoryIndex();

    List<String> getSaveExtinctionUserForNextMonth();

    List<String> getUserExitInfoThreeAfterDay();

//    List<WeddingGradeChange> getWeddingGradeChange(String wdnId);
//
//    void updateWeddingUserGrade(UserGradeChange userGradeChng);
//
//    void updateUserGrade(UserGradeChange userGradeChng);

    void deleteTempProductPrice();

    void loadSavedForHanatour();

    void loadSavedForUserGroup(String savedId, String userGroupId, int payAmount);

	void availableSaleCount();


	void oneOfUserStampSaved(String savedId, String eventStartDt);

	void twoOfUserStampSaved(String savedId, String eventStartDt);

	void threeOfUserStampSaved(String savedId, String eventStartDt);

//	EventParam selectEventById(String eventId);
//
//	void insertReturnSavedEventSaved(OrderStamp returnInfo);
//	void updateReturnSavedEvent(OrderStamp returnInfo);
//	List<OrderStamp> getReturnSavedEvent();

	void deleteStoreBrandBranch();
	void insertStoreBrandBranch();

	void deleteStampSaved();
    void insertStampSaved();

    void updateUserAddr();

    OrderNextParam getOrderNotNext();

//    List<EventEntryJoinParam> getMayDayList(EventEntryJoinParam eventEntryJoinParam);
//
//    void saveEventBrandRanking(EventEntryJoinParam eventEntryJoinParam);
//
//    void deleteEventBrandRanking(EventEntryJoinParam eventEntryJoinParam);
//
//    TenPayNotOrder getTenPayNotOrder();
}
