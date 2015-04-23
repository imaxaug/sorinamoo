package kr.co.crewmate.site.model.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.co.crewmate.site.model.ToString;

/**
 * 
 * 클래스명: <code>Work</code>
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
public class Work extends ToString {
    
    private int workSequence;
    
    private String workGubun;
    
    private Date registDatetime;

    private String productCode;
    
    private String adminId;
    
    private String orderNum;
    
    private String discountSequence;
    
    private String userId;
    
    private Integer bnrSeq;
    
    private String freeGiftId;
    
    private String userGradeId;
    
    private String userGroupId;
    
    private String powerId;
    

    
    
    
    private List<WorkHistory> historys = new ArrayList<WorkHistory>(30);
    
    public Integer getBnrSeq() {
        return bnrSeq;
    }

    public void setBnrSeq(Integer bnrSeq) {
        this.bnrSeq = bnrSeq;
    }

    public String getFreeGiftId() {
        return freeGiftId;
    }

    public void setFreeGiftId(String freeGiftId) {
        this.freeGiftId = freeGiftId;
    }

    public Work(String workGubun) {
        this.workGubun = workGubun;
        this.registDatetime = new Date();
    }

    public Work() {
        this.registDatetime = new Date();
    }

    public int getWorkSequence() {
        return workSequence;
    }

    public void setWorkSequence(int workSequence) {
        this.workSequence = workSequence;
    }

    public String getWorkGubun() {
        return workGubun;
    }

    public void setWorkGubun(String workGubun) {
        this.workGubun = workGubun;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getDiscountSequence() {
        return discountSequence;
    }

    public void setDiscountSequence(String discountSequence) {
        this.discountSequence = discountSequence;
    }
    
    public void setDiscountSequence(int discountSequence) {
        this.discountSequence = Integer.toString(discountSequence);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static Work getProduct() {
        return new Work("P");
    }
    
    public static Work getDiscount() {
        return new Work("T");
    }
    
    public static Work getUser() {
        return new Work("U");
    }

    public static Work getOrder() {
        return new Work("O");
    }
    
    public static Work getUserGrade() {
        return new Work("G");
    }
    
    public static Work getUserGroup() {
        return new Work("X");
    }
    
    public static Work getBanner() {
        return new Work("B");
    }

    public static Work getFreeGift() {
        return new Work("F");
    }
    
    public Date getRegistDatetime() {
        return registDatetime;
    }

    public void setRegistDatetime(Date registDatetime) {
        this.registDatetime = registDatetime;
    }

    public void addDiffers(List<Differ> differs) {
        for (Differ d: differs) {
            WorkHistory o = new WorkHistory(d);
            o.setWorkSequence(this.workSequence);
            this.historys.add(o);
        }
    }

    public void addDiffer(Differ differ) {
        WorkHistory o = new WorkHistory(differ);
        o.setWorkSequence(this.workSequence);
        this.historys.add(o);
    }

    public void addDiffer(WorkHistory differ) {
        differ.setWorkSequence(this.workSequence);
        this.historys.add(differ);
    }

    public List<WorkHistory> getHistorys() {
        return historys;
    }

    public void setHistorys(List<WorkHistory> historys) {
        this.historys = historys;
    }

    public String getUserGradeId() {
        return userGradeId;
    }

    public void setUserGradeId(String userGradeId) {
        this.userGradeId = userGradeId;
    }

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }

	public String getPowerId() {
		return powerId;
	}

	public void setPowerId(String powerId) {
		this.powerId = powerId;
	}

}
