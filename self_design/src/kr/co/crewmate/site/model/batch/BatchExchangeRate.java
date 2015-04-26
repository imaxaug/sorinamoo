package kr.co.crewmate.site.model.batch;


/**
 * 클래스명: <code>BatchExchangeRate</code>
 *
 * <pre>
 *  환율 정보를 갖고 오는 모델
 * </pre>
 *
 * @author 이선영
 * @date 2014. 01. 21.
 *
 */
public class BatchExchangeRate {
	//기간계
	private String dal;
	private String yen;
	private String cny;
	
	
	//신세계면세점 온라인
	private String dalExcRate;
	private String yenExcRate;
	private String yuanExcRate;
	
	
	public String getDal() {
		return dal;
	}
	public void setDal(String dal) {
		this.dal = dal;
	}
	public String getYen() {
		return yen;
	}
	public void setYen(String yen) {
		this.yen = yen;
	}
	
	public String getDalExcRate() {
		return dalExcRate;
	}
	public void setDalExcRate(String dalExcRate) {
		this.dalExcRate = dalExcRate;
	}
	public String getYenExcRate() {
		return yenExcRate;
	}
	public void setYenExcRate(String yenExcRate) {
		this.yenExcRate = yenExcRate;
	}
	public String getYuanExcRate() {
		return yuanExcRate;
	}
	public void setYuanExcRate(String yuanExcRate) {
		this.yuanExcRate = yuanExcRate;
	}
	public String getCny() {
		return cny;
	}
	public void setCny(String cny) {
		this.cny = cny;
	}
	
}
