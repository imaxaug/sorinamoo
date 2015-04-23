package kr.co.crewmate.site.model.batch;

import kr.co.crewmate.site.model.ToString;

/**
 * 클래스명: <code>BatchMaster</code>
 *
 * <pre>
 *  TB_BATCH_MASTER에 매칭되는 클래스
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 24.
 *
 */
@SuppressWarnings("serial")
public class BatchMaster extends ToString {
    
    /**
     * 배치아이디(batch_id)
     */
    private String id;
    
    /**
     * 배치이름(batch_name)
     */
    private String name;
    
    /**
     * 배치관리URL(batch_mnl_url)
     */
    private String managerUrl;
    
    /**
     * 사용여부(use_yn)
     */
    private boolean useYn;

    public BatchMaster() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerUrl() {
        return managerUrl;
    }

    public void setManagerUrl(String managerUrl) {
        this.managerUrl = managerUrl;
    }

    public boolean isUseYn() {
        return useYn;
    }

    public void setUseYn(boolean useYn) {
        this.useYn = useYn;
    }
}
