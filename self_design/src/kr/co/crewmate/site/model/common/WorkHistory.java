package kr.co.crewmate.site.model.common;

import org.springframework.beans.BeanUtils;

/**
 * 클래스명: <code>WorkHistory</code>
 *
 * <pre>
 *  설명을 기입하세요
 * </pre>
 *
 * @author 이경연
 * @date 2013. 5. 20.
 *
 */
@SuppressWarnings("serial")
public class WorkHistory extends Differ {
    
    private int workHistorySequence;
    
    private String changeGubunCode;
    
    private int workSequence;
    
    private String encYn;
    
    private String powerId;
    
    
    private String oldData;

    private String newData;    

    public WorkHistory(Differ differ) {
        BeanUtils.copyProperties(differ, this);
        this.changeGubunCode = "C";
    }

    public WorkHistory() {
        this.changeGubunCode = "C";
    }
    
    public int getWorkHistorySequence() {
        return workHistorySequence;
    }

    public void setWorkHistorySequence(int workHistorySequence) {
        this.workHistorySequence = workHistorySequence;
    }

    public String getChangeGubunCode() {
        return changeGubunCode;
    }

    public void setChangeGubunCode(String changeGubunCode) {
        this.changeGubunCode = changeGubunCode;
    }

    public int getWorkSequence() {
        return workSequence;
    }

    public void setWorkSequence(int workSequence) {
        this.workSequence = workSequence;
    }

	public String getEncYn() {
		return encYn;
	}

	public void setEncYn(String encYn) {
		this.encYn = encYn;
	}

	public String getPowerId() {
		return powerId;
	}

	public void setPowerId(String powerId) {
		this.powerId = powerId;
	}

	public String getOldData() {
		return oldData;
	}

	public void setOldData(String oldData) {
		this.oldData = oldData;
	}

	public String getNewData() {
		return newData;
	}

	public void setNewData(String newData) {
		this.newData = newData;
	}
    
    
    
}
