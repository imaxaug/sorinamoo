package kr.co.crewmate.site.model.mail;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import kr.co.crewmate.site.model.ToString;

/**
 * 클래스명: <code>MailTemplate</code>
 *
 * <pre>
 *  설명을 기입하세요
 * </pre>
 *
 * @author 이경연
 * @date 2013. 8. 21.
 *
 */
@SuppressWarnings("serial")
public class MailTemplate extends ToString {
    
    private String template;
    
    private HttpServletRequest request;
    
    private HttpServletResponse response;
    
    public MailTemplate(HttpServletResponse response, String template) {
        this.response = response;
        this.template = String.format("mailTemplate_%s", template);
        init();
    }
    
    private void init() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        this.request = ((ServletRequestAttributes) requestAttributes).getRequest();
        if (this.request == null) {
            throw new RuntimeException("Request가 존재하는곳에서 테스트하십쇼");
        }
    }

    public void setAttribute(String key, Object value) {
        this.request.setAttribute(key, value);
    }
    
    public String getHtmlCode() {
        ImportResponseWrapper wrapper = new ImportResponseWrapper(this.response);
        try {
            this.request.getRequestDispatcher("/WEB-INF/template/" + this.template + ".jsp").include(request, wrapper);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        return wrapper.getString();
    }

    private class ImportResponseWrapper extends HttpServletResponseWrapper {
        
        public static final String DEFAULT_ENCODING = "ISO-8859-1";

        private final StringWriter sw = new StringWriter();

        private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

        private final ServletOutputStream sos = new ServletOutputStream() {
            @Override
            public void write(int b) {
                bos.write(b);
            }
        };

        private boolean isWriterUsed;

        private boolean isStreamUsed;

        private int status = 200;

        public ImportResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public PrintWriter getWriter() {
            if (isStreamUsed) {
                throw new RuntimeException("import illegal stream");
            }
            isWriterUsed = true;
            return new PrintWriter(sw);
        }

        @Override
        public ServletOutputStream getOutputStream() {
            if (isWriterUsed) {
                throw new RuntimeException("import_illegal writer");
            }
            isStreamUsed = true;
            return sos;
        }

        @Override
        public void setContentType(String x) {
            // ignore
        }

        /** Has no effect. */
        @Override
        public void setLocale(Locale x) {
            // ignore
        }

        @Override
        public void setStatus(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }

        public String getString() {
            if (isWriterUsed) {
                return sw.toString();
            } else if (isStreamUsed) {
                try {
                    return bos.toString(DEFAULT_ENCODING);
                } catch (UnsupportedEncodingException e) {
                    /**
                     * 이런일 안생겨
                     */
                    throw new RuntimeException(e);
                }
            } else {
                return "";
            }
        }
    }
}
