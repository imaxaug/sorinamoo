package kr.co.crewmate.site.web.taglib;

/**
 * 클래스명: <code>PageHolder</code>
 *
 * <pre>
 *  페이징 처리를 하기위한 유틸클래스(크루메이트)
 * </pre>
 *
 * @author Sung-Bae Kim
 * @date 2012. 5. 21.
 * @version $Revision: 1.2 $ $Date: 2009/08/08 09:52:53 $
 *
 */
public class PageHolder {

    public static int DEFAULT_LISTSIZE = 10;

    public static int DEFAULT_PAGESIZE = 10;

    /**
     *
     */
    private int listSize = DEFAULT_LISTSIZE;

    /**
     *
     */
    private int pageSize = DEFAULT_PAGESIZE;

    /**
     *
     */
    private final long totalRows;

    /**
     *
     */
    // final변수로 선언된 변수는 절대 변할 수 없다. 고정값. 
    private final int currentPage;

    public PageHolder(long totalRows, int currentPage) {
        this.totalRows = totalRows;
        this.currentPage = currentPage;
    }

    public PageHolder(long totalRows, int currentPage, int listSize) {
        this.totalRows = totalRows; //총 게시물수
        this.currentPage = currentPage; // 현재페이지(클릭된)
        this.listSize = listSize;//(10페이지면 10페이지씩 잘라주는거)
    }

    public PageHolder(long totalRows, int currentPage, int listSize, int pageSize) {
        this.totalRows = totalRows;
        this.currentPage = currentPage;
        this.listSize = listSize;
        this.pageSize = pageSize;
    }

    public int getStartNumber() {
        return (this.currentPage - 1) * this.listSize + 1;
    }

    public int getLastIndexNumber() {
        return (int) (this.totalRows - (this.getStartNumber() - 1));
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getLineSize() {
        return this.listSize;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getTotalPages() {
        if (totalRows > 0 && currentPage > 0) {
            long totalPages = totalRows / listSize;
            if (totalRows % listSize > 0)
                totalPages++;
            return totalPages;
        }
        else {
            return 0;
        }
    }

    public long getTotalRows() {
        return this.totalRows;
    }

    /**
     * <pre>
     * 탑카운트 리턴
     * (listScale * pageScale) + ((listScale * pageScale) * (page / pageScale)) + 1
     * </pre>
     * @param page
     * @param listScale
     * @param pageScale
     * @return
     */
    public static int getTopCount(int page, int listScale, int pageScale) {
        int topCount = 0;
        int boxCount = listScale * pageScale;
        if (page <= pageScale) {
            topCount = boxCount + 1;
        } else {
            int d = page / pageScale;
            topCount = boxCount + (boxCount * d) + 1;
        }

        return topCount;
    }

    /**
     * 탑카운트 리턴
     *
     * @return
     */
    public static int getTopCount(int page, int listScale) {
        return getTopCount(page, listScale, DEFAULT_PAGESIZE);
    }

    /**
     * 탑카운트 리턴
     *
     * @return
     */
    public static int getTopCount(int page) {
        return getTopCount(page, DEFAULT_LISTSIZE, DEFAULT_PAGESIZE);
    }

}
