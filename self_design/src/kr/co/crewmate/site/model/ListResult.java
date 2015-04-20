package kr.co.crewmate.site.model;

import java.util.List;

/**
 * 
 * 클래스명: <code>ListResult</code>
 *
 * <pre>
 *  페이징관련된것을 한서비스에 묶기위한 리스트인터페이스 
 * </pre>
 *
 * @author smuft76
 * @date 2012. 5. 18.
 *
 * @param <E>
 */
@SuppressWarnings("serial")
public class ListResult<E> extends ToString {

    /**
     * <E>를 가지고있는 리스트
     */
    private List<E> list;

    /**
     * 리스트 카운트
     */
    private int listCount;
    
    /**
     * 전체 카운트
     */
    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getListCount() {
        return listCount;
    }

    public void setListCount(int listCount) {
        this.listCount = listCount;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
