package kr.co.crewmate.site.web.taglib;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

//import kr.co.crewmate.site.service.MessageService;
import kr.co.crewmate.site.utils.MessageHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
public class MessageLocaleTag extends TagSupport  {
    
    /**
     * 메세지키
     */
    private String key;
    
    /**
     * 언어코드
     */
    private String locale;
    
    public int doEndTag() throws JspException {
//        try {
//            JspWriter out = pageContext.getOut();
//            out.print(getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new JspException();
//        }

        return EVAL_PAGE;
    }


//    private String getMessage() {
//        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(super.pageContext.getServletContext());
//        MessageService messageService = applicationContext.getBean(MessageService.class);
//        MessageHandler messageHandler = messageService.getMessageHandler();
//        return messageHandler.getMessage(this.key, this.locale);
//    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

}
