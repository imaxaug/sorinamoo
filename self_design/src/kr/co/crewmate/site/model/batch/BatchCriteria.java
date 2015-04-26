package kr.co.crewmate.site.model.batch;

import kr.co.crewmate.site.model.PageParam;


/**
 * 
 * 클래스명: <code>BatchCriteria</code>
 *
 * <pre>
 *  배치 정보 검색 및 페이지 처리를 위한 모델 클래스
 * </pre>
 *
 * @author sist818
 * @date 2013. 3. 26.
 *
 */
@SuppressWarnings("serial")
public class BatchCriteria extends PageParam {
    
    private String batchId;
    
    private String batchName;
    
    private String batchMnrUrl;
    
    private Boolean batchUseYn;

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchMnrUrl() {
        return batchMnrUrl;
    }

    public void setBatchMnrUrl(String batchMnrUrl) {
        this.batchMnrUrl = batchMnrUrl;
    }

    public Boolean getBatchUseYn() {
        return batchUseYn;
    }

    public void setBatchUseYn(Boolean batchUseYn) {
        this.batchUseYn = batchUseYn;
    }

}
