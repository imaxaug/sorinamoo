package kr.co.crewmate.site.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import kr.co.crewmate.http.RequestSender;
import kr.co.crewmate.site.config.Config;
//import kr.co.crewmate.site.dao.EventDao;
//import kr.co.crewmate.site.dao.ScheduleDao;
import kr.co.crewmate.site.model.batch.OrderNextParam;
//import kr.co.crewmate.site.model.batch.TenPayNotOrder;
//import kr.co.crewmate.site.model.event.EventEntryJoinParam;
//import kr.co.crewmate.site.model.event.EventParam;
//import kr.co.crewmate.site.model.promotion.OrderStamp;
//import kr.co.crewmate.site.model.promotion.WeddingGradeChange;
//import kr.co.crewmate.site.model.user.UserGradeChange;
//import kr.co.crewmate.site.model.user.UserGroupSaved;
//import kr.co.crewmate.site.service.NaverService;
import kr.co.crewmate.site.service.ScheduleService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    Log log = LogFactory.getLog(this.getClass());

	@Override
	public void removeCartBy3Day() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSpecialCart() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getAvailBenefitOrderNum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void benefit(String orderNum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertNaverProduct() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadTotalHtml() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadTotalTgHtml() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadSearchCatgoryIndex() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getSaveExtinctionUserForNextMonth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUserExitInfoThreeAfterDay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTempProductPrice() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadSavedForHanatour() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadSavedForUserGroup(String savedId, String userGroupId,
			int payAmount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void availableSaleCount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void oneOfUserStampSaved(String savedId, String eventStartDt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void twoOfUserStampSaved(String savedId, String eventStartDt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void threeOfUserStampSaved(String savedId, String eventStartDt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStoreBrandBranch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertStoreBrandBranch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStampSaved() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertStampSaved() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserAddr() {
		// TODO Auto-generated method stub

	}

	@Override
	public OrderNextParam getOrderNotNext() {
		// TODO Auto-generated method stub
		return null;
	}

//    @Inject
//    ScheduleDao scheduleDao;
//
//    @Inject
//    NaverService naverService;
//
//    @Inject
//    EventDao eventDao;
//
//    @Override
//    public void removeCartBy3Day() {
//        this.scheduleDao.removeCartSelectBy3Day();
//        this.scheduleDao.removeCartBy3Day();
//    }
//
//    @Override
//    public void removeSpecialCart() {
//        this.scheduleDao.removeSpecialCartSelect();
//        this.scheduleDao.removeSpecialCart();
//    }
//
//    @Override
//    public List<String> getAvailBenefitOrderNum() {
//        return this.scheduleDao.getAvailBenefitOrderNum();
//    }
//
//    @Override
//    public void benefit(String orderNum) {
//        /**
//         * 적립금저장
//         */
//        this.scheduleDao.payBuyOrderSaved(orderNum);
//        this.scheduleDao.benefitComplete(orderNum);
//        List<String> stampIds = this.scheduleDao.getAvailStampByOrderNum(orderNum);
//        for (String stampId: stampIds) {
//            OrderStamp orderStamp = new OrderStamp();
//            orderStamp.setOrderNum(orderNum);
//            orderStamp.setStampId(stampId);
//            this.scheduleDao.insertOrderStamp(orderStamp);
//            OrderStamp payBenefit = this.scheduleDao.getPayBenefitByStamp(orderStamp.getUserStampHistSeq());
//            if (payBenefit != null) {
//                if (payBenefit.getSavedId() != null) {
//                    this.scheduleDao.payUserSavedForStamp(payBenefit);
//                } else if (payBenefit.getCpnGroupId() != null) {
//                    this.scheduleDao.payUserCouponForStamp(payBenefit);
//                }
//            }
//        }
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void insertNaverProduct() {
//        this.scheduleDao.deleteNaverProduct();
//        this.scheduleDao.insertNaverProduct();
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void loadTotalHtml() {
//        String urlString = Config.getServerHost() + "/ep/live/all.txt";
//        RequestSender sender = new RequestSender(urlString);
//        sender.send();
//        this.naverService.updateTotalNaverHtml(sender.getResponseBody());
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void loadTotalTgHtml() {
//        String urlString = Config.getServerHost() + "/ep/live/allTg.txt";
//        RequestSender sender = new RequestSender(urlString);
//        sender.send();
//        this.naverService.updateTotalNaverTgHtml(sender.getResponseBody());
//    }
//
//    @Override
//    public void loadSearchCatgoryIndex() {
//        this.scheduleDao.deleteSearchCatgoryIndex();
//        this.scheduleDao.loadSearchCatgoryIndex();
//    }
//
//    @Override
//    public List<String> getSaveExtinctionUserForNextMonth() {
//        return this.scheduleDao.getSaveExtinctionUserForNextMonth();
//    }
//
//    @Override
//    public List<String> getUserExitInfoThreeAfterDay() {
//        return this.scheduleDao.getUserExitInfoThreeAfterDay();
//    }
//
//    @Override
//    public void updateWeddingUserGrade(UserGradeChange userGradeChng) {
//        this.scheduleDao.updateWeddingUserGrade(userGradeChng);
//    }
//
//    @Override
//    public List<WeddingGradeChange> getWeddingGradeChange(String wdnId) {
//        return this.scheduleDao.getWeddingGradeChange(wdnId);
//    }
//
//    @Override
//    public void updateUserGrade(UserGradeChange userGradeChng) {
//        this.scheduleDao.updateUserGrade(userGradeChng);
//    }
//
//    @Override
//    public void deleteTempProductPrice() {
//        this.scheduleDao.deleteTempProductPrice();
//    }
//
//    @Override
//    public void loadSavedForHanatour() {
//        this.scheduleDao.loadSavedForHanatour();
//    }
//
//    @Override
//    public void loadSavedForUserGroup(String savedId, String userGroupId, int payAmount) {
//        this.scheduleDao.loadSavedForUserGroup(new UserGroupSaved(savedId, userGroupId, payAmount));
//    }
//
//	@Override
//	public void availableSaleCount() {
//		// TODO Auto-generated method stub
//        this.scheduleDao.availableSaleCount();
//	}
//
//
//    @Override
//    public EventParam selectEventById(String eventId) {
//    	return this.eventDao.selectEventById(eventId);
//    }
//
//    @Override
//    public List<EventEntryJoinParam> getMayDayList(EventEntryJoinParam eventEntryJoinParam) {
//        return this.eventDao.getMayDayList(eventEntryJoinParam);
//    }
//
//    @Override
//    public void saveEventBrandRanking(EventEntryJoinParam eventEntryJoinParam) {
//        this.eventDao.saveEventBrandRanking(eventEntryJoinParam);
//    }
//
//    @Override
//    public void deleteEventBrandRanking(EventEntryJoinParam eventEntryJoinParam) {
//        this.eventDao.deleteEventBrandRanking(eventEntryJoinParam);
//    }
//
//    @Override
//    public void oneOfUserStampSaved(String savedId, String eventStartDt) {
//    	Map<String, String> param = new HashMap<String,String>();
//    	param.put("savedId", savedId);
//    	param.put("eventStartDt", eventStartDt);
//
//    	this.scheduleDao.insertOneOfUserStampSaved(param);
//    }
//
//    @Override
//    public void twoOfUserStampSaved(String savedId, String eventStartDt) {
//    	Map<String, String> param = new HashMap<String,String>();
//    	param.put("savedId", savedId);
//    	param.put("eventStartDt", eventStartDt);
//
//    	this.scheduleDao.insertTwoOfUserStampSaved(param);
//    }
//
//    @Override
//    public void threeOfUserStampSaved(String savedId, String eventStartDt) {
//    	Map<String, String> param = new HashMap<String,String>();
//    	param.put("savedId", savedId);
//    	param.put("eventStartDt", eventStartDt);
//
//    	this.scheduleDao.insertThreeOfUserStampSaved(param);
//    }
//
//    @Override
//    public void insertReturnSavedEventSaved(OrderStamp returnInfo) {
//        /**
//         * 적립금저장
//         */
//        this.scheduleDao.insertReturnSavedEventSaved(returnInfo);
//
//    }
//    @Override
//    public void updateReturnSavedEvent(OrderStamp returnInfo) {
//        /**
//         * 적립금저장
//         */
//        this.scheduleDao.updateReturnSavedEvent(returnInfo);
//
//    }
//    @Override
//    public List<OrderStamp> getReturnSavedEvent() {
//        return this.scheduleDao.getReturnSavedEvent();
//    }
//
//    @Override
//    public void deleteStoreBrandBranch() {
//        this.scheduleDao.deleteStoreBrandBranch();
//    }
//
//    @Override
//    public void insertStoreBrandBranch() {
//        this.scheduleDao.insertStoreBrandBranch();
//    }
//
//    @Override
//    public void deleteStampSaved() {
//        this.scheduleDao.deleteStampSaved();
//    }
//
//    @Override
//    public void insertStampSaved() {
//        this.scheduleDao.insertStampSaved();
//    }
//
//    @Override
//    public void updateUserAddr() {
//        this.scheduleDao.updateUserAddr();
//    }
//
//
//    @Override
//    public OrderNextParam getOrderNotNext() {
//       return this.scheduleDao.getOrderNotNext();
//    }
//
//    @Override
//    public TenPayNotOrder getTenPayNotOrder(){
//        return this.scheduleDao.getTenPayNotOrder();
//    }

}
