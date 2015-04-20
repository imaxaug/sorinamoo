package kr.co.crewmate.http;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 클래스명: <code>Url</code>
 * 
 * <pre>
 * 호스트/path/query/port/protocol정보를 담당한다
 * 2008-03-05 contentType추가
 * 2008-03-06 getEncodingURI()추가
 * 2008-11-07 포트변경로직 추가(Qoom 와글보드에서 사용하기위한 로직)
 *            와스에서 업로드 웹서버로 직접통신시 포트가 일반적으로 사용되는 포트와 다르기 때문에
 *            추가 포트가 있을시 해당포트로 유알엘을 작업하는 로직을 추가
 * 
 * QoomSessionServer로보내는 리퀘스트에서 사용할꺼임
 * 
 * 2010-07-07 구조변경, 내부적으로 디랙토리구조 오류인것을 처리한는 로직추가
 *            http://www.archives.go.kr/test/../../images/hello.gif
 *        ->  http://www.archives.go.kr/images/hello.gif
 * </pre>
 * 
 * @date 2008-04-11
 * @author 이경연
 * 
 */
public class Url {

    @SuppressWarnings("unused")
    private final Log log = LogFactory.getLog(this.getClass());

    private final static char SEPERATOR = '/';

    public static int DEFAULT_BUFFER_SIZE = 4096;

    /**
     * URL
     */
    private URL url = null;

    /**
     * 기본포트(80)
     */
    public final static int DEFAULT_PORT = 80;

    /**
     * 기본프로토콜(http)
     */
    public final static String DEFAULT_PROTOCOL = "http";

    /**
     * 포트
     */
    private int port = 0;

    private String host;

    private String path;

    private String query;

    private String fileName;

    private String protocol;

    private String schema;

    public Url(String schema, String host, int port, String path, String query) {
        StringBuilder buffer = new StringBuilder(200);
        buffer.append(schema); 
        buffer.append(host).append(':');
        buffer.append(port).append(path);
        if (StringUtils.isEmpty(query)) {
        } else {
            buffer.append('?').append(query);
        }
        
        generateUrlInstance(buffer.toString());
    }

    /**
     * 생성자
     * 
     * @param urlString
     * @throws HttpRequestException
     */
    public Url(String urlString) {
        generateUrlInstance(urlString);
    }

    private void generateUrlInstance(String urlString) {
        try {
            this.url = new URL(urlString);
            setProperty();
        } catch (MalformedURLException e) {
            throw new HttpRequestException(e);
        }
    }

    public void setProperty() {
        int urlPort = url.getPort();
        this.port = urlPort == -1 ? DEFAULT_PORT : urlPort;
        this.host = url.getHost();
        this.protocol = url.getProtocol();
        this.schema = this.protocol + "://";
        String pp = this.url.getPath();
        DirectoryPath dp = new DirectoryPath(pp);
        dp.analysis();
        this.path = dp.getURI();
        this.fileName = dp.getFileName();
        this.query = url.getQuery();
    }

    /**
     * 
     * @param url
     * @throws HttpRequestException
     */
    public Url(URL url) {
        this.url = url;
        setProperty();
    }

    /**
     * 
     * @param url
     * @throws HttpRequestException
     */
    public Url(URI uri) {
        try {
            this.url = uri.toURL();
            setProperty();
        } catch (MalformedURLException e) {
            throw new HttpRequestException(e);
        }
    }

    /**
     * 생성자
     * 
     * @param urlString
     * @param baseUrl
     * @throws MalformedURLException
     */
    public Url(String urlString, String baseUrl) throws MalformedURLException {
        this.url = new URL(baseUrl + urlString);
        setProperty();
    }

    /**
     * <pre>
     * 호스트정보 리턴
     * </pre>
     * 
     * @return
     */
    public String getHost() {
        return this.host;
    }

    /**
     * 
     * <pre>
     * Path정보 리턴
     * </pre>
     * 
     * @return
     */
    public String getPath() {
        return this.path;
    }

    /**
     * <pre>
     * 포트리턴
     * </pre>
     * 
     * @return
     */
    public int getPort() {
        return port;
    }

    /**
     * <pre>
     * 프로토콜정보 리턴
     * </pre>
     * 
     * @return
     */
    public String getProtocol() {
        return this.protocol;
    }

    /**
     * 스키마
     * 
     * @return
     */
    public String getSchema() {
        return this.schema;
    }

    /**
     * <pre>
     * 쿼리정보리턴
     * </pre>
     * 
     * @return
     */
    public String getQuery() {
        return this.query == null ? "" : this.query;
    }

    /**
     * <pre>
     * 패스+쿼리정보 리턴
     * </pre>
     * 
     * @return
     */
    public String getURI() {
        StringBuilder buffer = new StringBuilder(DEFAULT_BUFFER_SIZE);
        buffer.append(this.getPath());
        if (this.getQuery().equals("") == false) {
            buffer.append("?").append(this.getQuery());
        }

        return buffer.toString();
    }

    /**
     * <pre>
     * 패스+쿼리정보리턴
     * 쿼리를 URI인코딩한다.
     * </pre>
     * 
     * @return
     */
    public String getEncodingURI() {
        StringBuilder buffer = new StringBuilder(DEFAULT_BUFFER_SIZE);
        if (isEncodingURI()) {
            return this.getURI();
        }

        DirectoryPath dp = new DirectoryPath(this.getPath());
        dp.analysis();

        List<String> directorys = dp.getDirectories();
        for (String directory : directorys) {
            buffer.append(SEPERATOR);
            buffer.append(Util.UrlEncoding(directory));
        }

        buffer.append(SEPERATOR);
        buffer.append(Util.UrlEncoding(dp.getFileName()));

        if (StringUtils.isNotEmpty(this.getQuery())) {
            String tmpQuery = this.getQuery();
            buffer.append("?");
            String word = "";
            for (int i = 0; i < tmpQuery.length(); i++) {
                char ch = tmpQuery.charAt(i);
                if (ch == '&' || ch == '=') {
                    buffer.append(Util.UrlEncoding(word)).append(ch);
                    word = "";
                } else {
                    word += ch;
                }
            }
            if (StringUtils.isNotEmpty(word)) {
                buffer.append(Util.UrlEncoding(word));
            }
        }

        return buffer.toString();
    }

    /**
     * <pre>
     * 딱히 알방법이 없어서 '%'문자열이 섞여 있으면 인코딩된 유알엘로 생각한다.
     * </pre>
     * 
     * @return
     */
    private boolean isEncodingURI() {
        int index = StringUtils.indexOf(this.getURI(), '%');
        return index != StringUtils.INDEX_NOT_FOUND;
    }

    /**
     * 새로작성한 URL을 리턴한다.
     * @return UrlString
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(DEFAULT_BUFFER_SIZE);
        buffer.append(this.getProtocol()).append("://");
        if (StringUtils.isEmpty(this.getHost())) {
            return buffer.toString();
        } else {
            buffer.append(this.getHost());
        }

        if (getPort() != DEFAULT_PORT) {
            buffer.append(":").append(this.getPort());
        }

        if (this.getPath().equals("")) {
            buffer.append(SEPERATOR);
        } else {
            buffer.append(this.getPath());
        }

        if (this.getQuery().equals("") == false) {
            buffer.append("?").append(this.getQuery());
        }

        return buffer.toString();
    }

    /**
     * <pre>
     * 프로토콜 + 호스트 + 포트
     * </pre>
     * 
     * @return
     */
    public String getHostNPort() {
        StringBuilder buffer = new StringBuilder(DEFAULT_BUFFER_SIZE);
        buffer.append(this.getProtocol()).append("://");
        buffer.append(this.getHost());
        if (getPort() != DEFAULT_PORT) {
            buffer.append(":").append(this.getPort());
        }
        return buffer.toString();
    }

    /**
     * <pre>
     * 프로토콜 + 호스트 + 포트 + 패스
     * </pre>
     * 
     * @return
     */
    public String getHostNpath() {
        StringBuilder buffer = new StringBuilder(DEFAULT_BUFFER_SIZE);
        buffer.append(this.getProtocol()).append("://");
        buffer.append(this.getHost());
        if (getPort() != DEFAULT_PORT) {
            buffer.append(":").append(this.getPort());
        }
        if (this.getPath().equals("")) {
            buffer.append(SEPERATOR);
        } else {
            buffer.append(this.getPath());
        }

        return buffer.toString();
    }

    /**
     * <pre>
     * 프로토콜 + 호스트
     * </pre>
     * 
     * @return
     */
    public String getProtocolHost() {
        StringBuilder buffer = new StringBuilder(DEFAULT_BUFFER_SIZE);
        buffer.append(this.getProtocol()).append("://");
        buffer.append(this.getHost());
        if (getPort() != DEFAULT_PORT) {
            buffer.append(":").append(this.getPort());
        }
        buffer.append(SEPERATOR);
        return buffer.toString();
    }

    public void setPort(int port) {
        this.port = port;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getBlankUrl() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(StringUtils.replace(this.toString(), " ", "%20"));
        return buffer.toString();
    }
}