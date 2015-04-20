package kr.co.crewmate.site.model;

import java.lang.reflect.Method;
import java.net.URLEncoder;

import kr.co.crewmate.site.Constants;
import kr.co.crewmate.site.web.taglib.PageHolder;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 클래스명: <code>PageParam</code>
 *
 * <pre>
 *  페이징처리 클래스 
 *  페이징을 처리하는 클래스는 PageParam를 상속받아 처리한다.
 *  pageSize: 하단 페이지네이션 사이즈 (default: 10)
 *  listSize: item갯수 (default: 20)
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 18.
 *
 */
@SuppressWarnings("serial")
public class PageParam extends ToString {

	private String srchNatnCode;
	
    /**
     * 페이지(RequestParameter문자열)
     */
    private Integer page = 1;

    /**
     * 페이지사이즈, 하단 페이지 최대사이즈(Default 10)
     */
    private int pageSize = PageHolder.DEFAULT_PAGESIZE;

    /**
     * 리스트 사이즈, 데이터 아이템 갯수
     */
    private int listSize = PageHolder.DEFAULT_LISTSIZE;

    
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page == null) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

	public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public int getFetchScale() {
        return (page - 1) * listSize;
    }

    /**
     * <pre>
     * 탑카운트 리턴
     * (listScale * pageScale) + ((listScale * pageScale) * (page / pageScale)) + 1
     * </pre>
     * @return
     */
    public int getTopCount() {
        return PageHolder.getTopCount(this.page, this.listSize, this.pageSize);
    }

    /**
     * <pre>
     * 현재 넘어온 파라매터값을 자바 변수분석으로 다음과 같은 데이터로 리턴한다.
     * param1=variable1&param2=variable2&param3=variable3
     * 
     * page, listSize는 변수에서 제외한다.
     * </pre>
     * @return
     */
    public String getQuery() {
        Method[] methods = this.getClass().getMethods();
        String className = this.getClass().getName();
        StringBuilder buffer = new StringBuilder();

        boolean start = true;
        for (Method method: methods) {
            String methodName = method.getName();
            if (StringUtils.contains(method.getDeclaringClass().toString(), className)
                    || methodName.equals("getPage") || methodName.equals("getListSize")) {
                if (methodName.startsWith("get")) {
                    StringBuilder guessField = new StringBuilder(methodName.length() - 3);
                    for (int i = 0; i < methodName.length(); i++) {
                        if (i < 3) {
                            continue;
                        } else {
                            char ch = methodName.charAt(i);
                            if (i == 3) {
                                guessField.append(Character.toLowerCase(ch));
                            } else {
                                guessField.append(ch);
                            }
                        }
                    }

                    try {
                        Object o = method.invoke(this, new Object[]{});
                        if (o != null && StringUtils.isNotEmpty(o.toString())) {
                            if (start) {
                                start = false;
                            } else {
                                buffer.append('&');
                            }

                            buffer.append(guessField).append('=').append(URLEncoder.encode(o.toString(), Constants.WAS_CHARSET));
                        }
                    } catch (Exception ignore) {
                        // ignore
                    }
                }
            }
        }

        if (buffer.length() > 0) {
            return '?' + buffer.toString();
        } else {
            return null;
        }
    }

	public String getSrchNatnCode() {
		return srchNatnCode;
	}

	public void setSrchNatnCode(String srchNatnCode) {
		this.srchNatnCode = srchNatnCode;
	}
}
