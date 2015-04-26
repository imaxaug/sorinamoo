package kr.co.crewmate.site.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.dao.SystemDao;
import kr.co.crewmate.site.model.common.Sequence;
import kr.co.crewmate.site.service.SequenceService;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 클래스명: <code>SequenceServiceImpl</code>
 *
 * <pre>
 *  채번정보를 관리하는 테이블
 *  
 *  getFtcSequence: 공정위
 *  getFreeGiftId: 사은품
 *  getSavedId: 적립금
 *  getProductCode: 상품코드
 *  getProductImageName: 상품이미지이름
 *  getSpecialSell: 기획전
 *  getCouponGroupId: 쿠폰그룹
 *  getCouponId: 쿠폰아이디
 *  getExperianceId: 체험전아이디
 *  getEventId: 이벤트아이디
 *  getStampId: 스탬프아이디
 *  getOrderNum: 주문번호
 *  getFreeNumber: 가상번호
 *  getStoreId: 매장아이디
 *  getSpecialOrderNum: 스페셜오더 주문번호
 *  getSsgTranNum: 신세계포인트 거래추적번호 [SSG_TRAN_NUM]
 *  
 * </pre>
 *
 * @author smuft76
 * @date 2013. 3. 26.
 *
 */
@Service
public class SequenceServiceImpl implements SequenceService {
    
    Log log = LogFactory.getLog(this.getClass());
    
    @Inject
    private SystemDao systemDao;

    @Override
    public String next(String sequenceId, String sequenceKey) {
        Sequence resultSequence = getSequence(sequenceId, sequenceKey);
        return resultSequence.next();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private Sequence getSequence(String sequenceId, String sequenceKey) {
        Sequence sequence = new Sequence();
        sequence.setSequenceId(sequenceId);
        sequence.setSequenceKey(sequenceKey);

        Sequence resultSequence = systemDao.getSequenceByIdKey(sequence);
        if (resultSequence == null) {
            resultSequence = systemDao.getSequenceById(sequence.getSequenceId());
            if (resultSequence == null) {
                throw new RuntimeException("존재하지않는 시퀀스 아이디 " + sequenceId);
            } else {
                resultSequence.setNext(1);
                resultSequence.setSequenceKey(sequence.getSequenceKey());

                this.systemDao.insertSequenceDetail(resultSequence);
            }
        } else {
            resultSequence.increase();
            this.systemDao.increaseSequence(sequence);
        }

        return resultSequence;
    }

    /**
     * <pre>
     * 난수 생성
     * 1. 생성된 userCouponNumber의 hashCode 값을 구한다.
     * 2. hashCode의 뒷 두자리 값을 자른다.
     * 3. hashCode 값에 10000을 곱하고 hashCode의 뒷 두자리 값을 제곱하여 곱한뒤 7을 곱하고 400000000000000 을 더하고 cpnId 
     * 4. 36진수(0~9, a~z)로 바꾼 뒤 소문자를 대문자로 변경한다.
     * </pre>
     * @param userCouponNumber
     * @param cpnId
     * @return
     */
    @SuppressWarnings("unused")
    private String makeRandomNumberForUserCoupon(String userCouponNumber, String cpnId) {
        int hash = userCouponNumber.hashCode();
        String hashStr = String.valueOf(hash);
        int last2Num = Integer.parseInt(hashStr.substring(hashStr.length()-2));
        int cpnIdInt = StringUtils.isNumeric(cpnId) ? Integer.parseInt(cpnId) : 0;
        
        long randomNumberDecimalNumber = (hash * 10000L + last2Num * last2Num) * 7 + 400000000000000L + cpnIdInt;
        String changedCouponNumber = StringUtils.upperCase(Long.toString(randomNumberDecimalNumber, 36));
        log.debug("changedCouponNumber : " + changedCouponNumber);
        log.debug("cpnIdInt : " + cpnIdInt);
        
        return changedCouponNumber;
    }
    
    @Override
    public String getFtcSequence() {
        return this.next("FTC", "FTC");
    }

    @Override
    public String getFreeGiftId() {
        return this.next("FREEGIFT", "FREEGIFT");
    }
    
    @Override
    public String getSavedId() {
        return this.next("SAVED", "SAVED");
    }
    
    @Override
    public String getProductCode(String brandId) {
        return String.format("%s%s%s", brandId, Config.getString("product.code.key"), this.next("PRDT", brandId));
    }

    @Override
    public String getProductImageName() {
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String siteKey = Config.getString("service.key", Long.toHexString(System.currentTimeMillis()));
        return today + siteKey + this.next("PRDT_IMAGE", today);
    }

    @Override
    public String getSpecialSellId() {
        return this.next("SPL", "SPL");
    }
    
    @Override
    public String getSpecialSellGroupId() {
        return this.next("SPL_GROUP", "SPL_GROUP");
    }
    
    /*  getCouponGroupId: 쿠폰그룹
    *  getCouponId: 쿠폰아이디*/
    
    @Override
    public String getCouponGroupId() {
        return "X" + this.next("CPN_GROUP", "CPN_GROUP");
    }

    @Override
    public String getCouponId() {
        return this.next("CPN", "CPN");
    }
    
    @Override
    public String getExperianceId() {
        return this.next("EXP_ID", "EXP_ID");
    }

    @Override
    public String getEventId() {
        return this.next("EVENT_ID", "EVENT_ID");
    }
    
    @Override
    public String getStampId() {
        return this.next("STAMP_ID", "STAMP_ID");
    }
    
    @Override
    public String getOrderNum() {
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date()); 
        return today + this.next("ORDER_NUM", today);
    }
    
    @Override
    public String getSsgTranNum() {
        String today = new SimpleDateFormat("yyMMdd").format(new Date()); 
        return today + this.next("SSG_TRAN_NUM", today);
    }
    
    @Override
    public String getFreeNumber() {
        return this.next("V_BILL_NO", "V_BILL_NO");
    }
    
    @Override
    public String getStoreId() {
        return this.next("STORE_ID", "STORE_ID");
    }
    
    @Override
    public String getSpecialOrderNum() {
        return this.next("SPL_ORDER", "SPL_ORDER");
    }

	@Override
	public String getProductGroupId(String brandId) {
		// TODO Auto-generated method stub
        return String.format("%s%s", brandId, this.next("PRDT_GROUP", brandId));
	}
	
	@Override
	public String getBrandCollectionId(String brandId) {
		// TODO Auto-generated method stub
        return String.format("%s%s", brandId, this.next("BRND_CLCTN", brandId));
	}

}

