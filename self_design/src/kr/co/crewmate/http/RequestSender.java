package kr.co.crewmate.http;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.protocol.HTTP;


/**
 * 클래스명: <code>RequestSender</code>
 *
 * <pre>
 * 리퀘스트를 보내고 해당결과를 저장하는 클래스입니다.
 *
 * 2008-06-05
 * POST구현(DEFAULT:GET)
 * getHost추가
 * 리트라이기능 삭제
 *
 * 2010-09-01
 * 스키마
 * 포트추가
 *
 * </pre>
 *
 * @date 2008-04-11
 * @author 이경연
 *
 */
public class RequestSender {
    
    final Log log = LogFactory.getLog(this.getClass());

    /**
     * 호스트
     */
    private String host;

    /**
     * 패스
     */
    private String path;

    /**
     * 파라매터
     */
    private final List<RequestParameter> parameters = new ArrayList<RequestParameter>();

    /**
     * response
     */
    private Response response;

    /**
     * 포트
     */
    private int port = Url.DEFAULT_PORT;

    /**
     * 스키마(프로토콜)
     */
    private String schema = Url.DEFAULT_PROTOCOL;

    /**
     * HttpMethod
     */
    private String method = Request.GET;

    /**
     * 문자셋
     */
    private String charset = HTTP.UTF_8;

    /**
     * Response Charset
     *
     * 문자열을 속이고 념겨주는 문제 리스판스
     */
    private String responseCharset;
    
    private int maxConnectionTimeout = Constants.MAX_CONNECTION_TIMEOUT;

    public RequestSender() {
    }

    public RequestSender(String uri) {
        Url url = new Url(uri);
        this.host = url.getHost();
        this.port = url.getPort();
        this.schema = url.getProtocol();
        this.path = url.getPath();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void addParameter(RequestParameter parameter) {
        this.parameters.add(parameter);
    }
    
    public void addParameter(String key, String value) {
        this.parameters.add(new RequestParameter(key, value));
    }
    
    public void addParameter(List<RequestParameter> params) {
        for (RequestParameter param: params) {
            addParameter(param);
        }
    }

    /**
     * <pre>
     * 세션서버로 리퀘스트를 날린다.
     * </pre>
     *
     * @throws HttpRequestException
     */
    public void send() throws HttpRequestException {
        if (Request.GET.equals(method)) {
            sendGetMethod();
        } if (Request.POST.equals(method)) {
            sendPostMethod();
        }
    }

    /**
     * <pre>
     * Post방식으로 리퀘스트를 날림
     * </pre>
     *
     * @throws HttpRequestException
     */
    private void sendPostMethod() throws HttpRequestException {
        Url url = new Url(this.createUrl());
        Request request = new RequestImpl(url, this.charset);
        request.setMaxConnectionTimeout(this.maxConnectionTimeout);
        request.setPost();
        request.setParams(parameters);
        request.setResponseCharset(this.responseCharset);
        this.response = request.execute();
        if (response.getStatus() != HttpStatus.SC_OK) {
            throw new HttpRequestException("Bad Request=" + response.getStatus());
        }
    }

    private String createUrl() {
        StringBuilder buffer = new StringBuilder(4096);
        buffer.append(this.schema);
        buffer.append("://");
        buffer.append(this.host);
        if (this.port != 80) {
            buffer.append(":");
            buffer.append(this.port);
        }

        if (this.path != null) {
            buffer.append(this.path);
        }

        return buffer.toString();
    }

    /**
     * <pre>
     * GET방식으로 리퀘스트를 날림
     * </pre>
     *
     * @throws HttpRequestException
     */
    private void sendGetMethod() throws HttpRequestException {
        String urlString = this.createUrl();
        if (this.parameters.size() > 0) {
            urlString += "?";
            for (int i = 0; i < parameters.size(); i++) {
                RequestParameter p = parameters.get(i);
                urlString += p.toString();
                if (i + 1 < parameters.size()) {
                    urlString += "&";
                }
            }
        }
        
        Url url = new Url(urlString);
        Request request = new RequestImpl(url, this.charset);
        request.setMaxConnectionTimeout(this.maxConnectionTimeout);
        request.setResponseCharset(this.responseCharset);
        this.response = request.execute();
        if (response.getStatus() != HttpStatus.SC_OK) {
            throw new HttpRequestException("Bad Request=" + response.getStatus());
        }
    }

    public String getResponseBody() {
        if (response == null) {
            return null;
        }

        return response.getResponseBody();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getStatus() {
        if (response == null) {
            return 0;
        }

        return response.getStatus();
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getResponseCharset() {
        return responseCharset;
    }

    public void setResponseCharset(String responseCharset) {
        this.responseCharset = responseCharset;
    }

    public Response getResponse() {
        return response;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public InputStream getInputStream() {
        return this.response.getInputStream();
    }

    public byte[] getBytes() {
        return this.response.getBytes();
    }

    public int getMaxConnectionTimeout() {
        return maxConnectionTimeout;
    }

    public void setMaxConnectionTimeout(int maxConnectionTimeout) {
        this.maxConnectionTimeout = maxConnectionTimeout;
    }
}