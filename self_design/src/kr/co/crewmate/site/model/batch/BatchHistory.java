package kr.co.crewmate.site.model.batch;

import java.util.Date;

import kr.co.crewmate.site.model.ToString;


/**
 * 클래스명: <code>BatchHistory</code>
 *
 * <pre>
 *  TB_BATCH_HISTORY에 매핑되는 모델
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 24.
 *
 */
public class BatchHistory extends ToString {
    
    /**
     * 배치아이디(batch_id) 
     */
    private String id;
    
    /**
     * 배치이력일련번호(batch_hist_seq)
     */
    private int historySequence;
    
    /**
     * 배치시작일시(batch_start_dtm)
     */
    private Date startDatetime;
    
    /**
     * 배치종료일시(batch_end_dtm)
     */
    private Date endDatetime;
    
    /**
     * <pre>
     * 배치상태구분(batch_stat_gbn)
     *  S(성공)
     *  F(실패)
     *  P(진행중)
     * </pre>
     */
    private String statusGbn;
    
    /**
     * 배치실행실패사유(batch_exe_fail_rsn)
     */
    private String executeFailureReason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHistorySequence() {
        return historySequence;
    }

    public void setHistorySequence(int historySequence) {
        this.historySequence = historySequence;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getStatusGbn() {
        return statusGbn;
    }

    public void setStatusGbn(String statusGbn) {
        this.statusGbn = statusGbn;
    }

    public String getExecuteFailureReason() {
        return executeFailureReason;
    }

    public void setExecuteFailureReason(String executeFailureReason) {
        this.executeFailureReason = executeFailureReason;
    }
}
