package kr.co.crewmate.site.model.common;

import kr.co.crewmate.site.model.ToString;


/**
 * 
 * 클래스명: <code>Sequence</code>
 *
 * <pre>
 *  채번테이블 모델
 *  TB_CREATE_NUMBER_MASTER, 
 *  TB_CREATE_NUMBER_DETAIL 
 *  겸용
 * </pre>
 *
 * @author 이경연
 * @date 2011. 11. 11.
 *
 */
public class Sequence extends ToString {

    /**
     * 시퀀스 아이디(crt_num_id)
     */
    private String sequenceId;

    /**
     * 일련번호길이(num_len)
     */
    private int length;

    /**
     * 시퀀스이름(crt_num_name)
     */
    private String sequenceName;

    /**
     * 시퀀스키(crt_num_key)
     */
    private String sequenceKey;

    /**
     * 다음번호(next)
     */
    private long next;

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getNext() {
        return next;
    }

    public void setNext(long next) {
        this.next = next;
    }

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public String getSequenceKey() {
        return sequenceKey;
    }

    public void setSequenceKey(String sequenceKey) {
        this.sequenceKey = sequenceKey;
    }

    public String next() {
        return String.format("%0" + this.length + "d", this.next);
    }

    public void increase() {
        this.next++;

    }

}
