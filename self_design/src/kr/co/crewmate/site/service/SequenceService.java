
package kr.co.crewmate.site.service;

public interface SequenceService {
    String next(String sequenceId, String sequenceKey);

    String getFtcSequence();

    String getFreeGiftId();

    String getSavedId();

    String getProductCode(String brandId);

    String getProductImageName();

    String getSpecialSellId();
    
    String getSpecialSellGroupId();

    String getCouponGroupId();

    String getCouponId();

    String getExperianceId();

    String getEventId();

    String getStampId();

    String getOrderNum();

    String getFreeNumber();

    String getStoreId();

    String getSpecialOrderNum();

    String getSsgTranNum();
    
    String getProductGroupId(String brandId);

    String getBrandCollectionId(String brandId);

}
