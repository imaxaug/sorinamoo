package kr.co.crewmate.site.web.taglib;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * 클래스명: <code>PageNumberTag</code>
 *
 * <pre>
 *  페이징 넘버를 계산하기위한 커스텀태그
 *  &lt;ui:pageNumber name="pageHolder" index="${status.index}"/&gt;
 * </pre>
 *
 * @author 이경연
 * @date 2012. 4. 28.
 *
 */
@SuppressWarnings("serial")
public class PageNumberTag extends TagSupport {

    /**
     * 페이지 홀더리퀘스트 스쿠프이름
     */
    private String name;
    
    /**
     * 상대적 단위 시작 일련번호
     */
    private int index;
    
    @Override
    public int doStartTag() throws JspTagException {
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspTagException {
        PageHolder pageHolder = (PageHolder) lookup(pageContext, name, "request");
        if (pageHolder == null) {
            return SKIP_BODY;
        }

        try {
            JspWriter out = pageContext.getOut();
            long rowNumber = pageHolder.getTotalRows() - ((pageHolder.getCurrentPage() - 1) * pageHolder.getLineSize()) - this.index;
            out.print(rowNumber);
            out.flush();
        } catch (Exception e) {
            throw new JspTagException();
        }

        return EVAL_PAGE;
    }

    protected Object lookup(PageContext pageContext, String name, String scope) throws JspTagException {
        Object bean = null;
        if (scope == null) {
            bean = pageContext.findAttribute(name);
        } else if (scope.equalsIgnoreCase("page")) {
            bean = pageContext.getAttribute(name, PageContext.PAGE_SCOPE);
        } else if (scope.equalsIgnoreCase("request")) {
            bean = pageContext.getAttribute(name, PageContext.REQUEST_SCOPE);
        } else if (scope.equalsIgnoreCase("session")) {
            bean = pageContext.getAttribute(name, PageContext.SESSION_SCOPE);
        } else if (scope.equalsIgnoreCase("application")) {
            bean = pageContext.getAttribute(name, PageContext.APPLICATION_SCOPE);
        } else {
            JspTagException e = new JspTagException("Invalid scope " + scope);
            throw e;
        }
        return (bean);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
