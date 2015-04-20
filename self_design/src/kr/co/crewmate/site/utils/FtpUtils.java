package kr.co.crewmate.site.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.exceptions.FtpLoginFailException;
import kr.co.crewmate.utils.FileHelper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * 
 * 클래스명: <code>FtpUtils</code>
 * 
 * <pre>
 *  FTPUtils, ssgdfs 의 디랙토리 경로대로 처리하는 FTP로직처리 클래스
 *  
 *  2013-06-09 수정: 이경연
 *   멀티 쓰레드 처리를 위해 싱글톤을 없앤다.
 * </pre>
 * 
 * @author newstar000
 * @date 2011. 11. 24.
 * 
 */
public class FtpUtils {

    private final Log log = LogFactory.getLog(this.getClass());

    private static final String SEPARATOR = "/";

    private final String host = Config.getString("upload.server.ip");

    private final String id = Config.getString("upload.server.id");

    private final String pw = Config.getString("upload.server.password");

    private final String basePath = Config.getString("upload.server.base.path");
    
    private final String systemPath = Config.getString("upload.server.system.path");
    
    private final String productPath = Config.getString("upload.server.product.path");

    private final int CONNECT_TIME_OUT = 5000;

    private final int SOCKET_TIME_OUT = 100000000;

    private FTPClient ftpClient = null;

    private boolean isPassive = false;
    
    private String imageServerEncoding = "EUC-KR";

    private FtpUtils() {
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding(imageServerEncoding);
        ftpClient.setConnectTimeout(CONNECT_TIME_OUT);
        this.isPassive = Config.getBoolean("ftp.is.passive");
    }
    
    public FTPClient generate() {
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.setControlEncoding(imageServerEncoding);
            ftpClient.setConnectTimeout(CONNECT_TIME_OUT);
            this.isPassive = Config.getBoolean("ftp.is.passive");
            ftpClient.connect(host);
            int resultCode = ftpClient.getReplyCode();
            if (log.isDebugEnabled()) {
                log.debug("IS CONNECT? " + resultCode);
            }

            if (!FTPReply.isPositiveCompletion(resultCode)) {
                throw new RuntimeException("Connect Failure");
            } else {
                ftpClient.setSoTimeout(SOCKET_TIME_OUT);
                if (this.isPassive) {
                    ftpClient.enterLocalPassiveMode();
                }

                boolean isLogin = ftpClient.login(id, pw);
                if (isLogin) {
                    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                } else {
                    throw new FtpLoginFailException(String.format("Login Failure> id=%s&password=%s" + pw, id, pw));
                }
            }
            
            return ftpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * FtpUtils의 instance를 리턴
     * 
     * 2013-06-09 수정: 이경연
     *  싱글톤을 없앤다.
     * @return
     */
    public static FtpUtils getInstance() {
        return new FtpUtils();
    }

    public void uploadForIgnoreHash(InputStream is, String path, String fileName) {
        boolean isuploaded = connectFTPAndUpload(is, path, fileName);
        if (false == isuploaded) {
            throw new RuntimeException(String.format("업로드실패[%s][%s]", path, fileName)); 
        }
    }
    
    /**
     * 이미지 서버에 파일 업로드
     * 
     * @param is
     * @param pathParam
     * @param fileName
     * @return
     */
    public String upload(InputStream is, String fileName) {
        return upload(is, null, fileName);
    }
    
    
    /**
     * 이미지 서버에 파일 업로드
     * 
     * @param is
     * @param pathParam
     * @param fileName
     * @return
     */
    public String upload(InputStream is, String pathParam, String fileName) {
        String uploadPath = "";
        String hashPath = FileHelper.getHashCodeDirectory(fileName);
        StringBuilder path = new StringBuilder(512);
        path.append(basePath).append(SEPARATOR);
        if (StringUtils.isNotBlank(pathParam)) {
            path.append(pathParam).append(SEPARATOR);
        }
        path.append(hashPath);
        
        String t = new SimpleDateFormat("ssSSS").format(new Date());
        int a =Integer.parseInt(t);
        int b = (int) (Math.random() * a);
        int c = a + b;
        
        fileName = Integer.toString(c)+fileName;

        boolean isuploaded = connectFTPAndUpload(is, path.toString(), fileName);
        if (isuploaded) {
            
            uploadPath = path.toString() + SEPARATOR +fileName;
        }

        return uploadPath;
    }
    
    
    
    
    /**
     * 이벤트별로 Img 경로 생성을 위한 메소드(이경도 추가)
     * 
     * @param is
     * @param pathParam
     * @param fileName
     * @return
     */
    public String upload(String id, InputStream is, String fileName) {
        return upload(id, is, null, fileName);
    }
        
    
    /**
     * 이벤트별 이미지 서버에 해당 경로로 파일 업로드(이경도 추가)
     * 
     * @param is
     * @param pathParam
     * @param fileName
     * @return
     */
    public String upload(String id, InputStream is, String pathParam, String fileName) {
        String uploadPath = "";
        StringBuilder path = new StringBuilder(512);
        path.append(basePath).append(SEPARATOR);
        if (StringUtils.isNotBlank(pathParam)) {
            path.append(pathParam).append(SEPARATOR);
        }
        
        path.append("event"+SEPARATOR);
        path.append(id);
        
        String t = new SimpleDateFormat("ssSSS").format(new Date());
        
        int a =Integer.parseInt(t);
        int b = (int) (Math.random() * a);
        int c = a + b;
        
        fileName = Integer.toString(c)+fileName;

        boolean isuploaded = connectFTPAndUpload(is, path.toString(), fileName);
        if (isuploaded) {
            
            uploadPath = path.toString() + SEPARATOR +fileName;
        }

        return uploadPath;
    }       
    
    /**
     * <pre>
     * 이미지 서버에 파일 업로드(상품용)
     * </pre>
     * @param is
     * @param fileName
     * @return
     */
    public String productUpload(byte[] is, String code, String fileName) {
        return productUpload(new ByteArrayInputStream(is), code, fileName);
    }
    
    /**
     * <pre>
     * 이미지 서버에 파일 업로드(상품용)
     * </pre>
     * @param ftpClient
     * @param is
     * @param code
     * @param fileName
     * @return
     */
    public String productUpload(FTPClient ftpClient, byte[] is, String code, String fileName) {
        return productUpload(ftpClient, new ByteArrayInputStream(is), code, fileName);
    }

    /**
     * <pre>
     * 이미지 서버에 파일 업로드(상품용)
     * </pre>
     * @param is
     * @param fileName
     * @return
     */
    public String productUpload(InputStream is, String code, String fileName) {
        StringBuilder path = new StringBuilder(512);
        path.append(productPath).append(SEPARATOR);
        path.append(code).append(SEPARATOR);
        String hashPath = FileHelper.getHashCodeDirectory(fileName);
        path.append(hashPath);
        boolean isuploaded = connectFTPAndUpload(is, path.toString(), fileName);
        if (isuploaded) {
            String uploadPath = hashPath + SEPARATOR + fileName;
            return uploadPath;
        } else {
            throw new RuntimeException("FTP UploadFailure");
        }
    }
    
    /**
     * <pre>
     * 이미지 서버에 파일 업로드(상품용)
     * </pre>
     * @param ftpClient
     * @param is
     * @param code
     * @param fileName
     * @return
     */
    public String productUpload(FTPClient ftpClient, InputStream is, String code, String fileName) {
        StringBuilder path = new StringBuilder(512);
        path.append(productPath).append(SEPARATOR);
        path.append(code).append(SEPARATOR);
        String hashPath = FileHelper.getHashCodeDirectory(fileName);
        path.append(hashPath);
        boolean isuploaded = connectFTPAndUpload(ftpClient, is, path.toString(), fileName);
        if (isuploaded) {
            String uploadPath = hashPath + SEPARATOR + fileName;
            return uploadPath;
        } else {
            throw new RuntimeException("FTP UploadFailure");
        }
    }

    private boolean connectFTPAndUpload(FTPClient ftpClient, InputStream is, String pathParam, String name) {
        boolean isUploaded = false;
        String path = systemPath + pathParam;

        try {
            ftpClient.makeDirectory(path);
            isUploaded = ftpClient.storeFile(path + SEPARATOR + name, is);
            if (log.isDebugEnabled()) {
                log.debug("path:" + path);
                log.debug("name:" + name);
                log.debug("IS SUCCESS UPLOADED? " + isUploaded);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
        return isUploaded;
    }

    private boolean connectFTPAndUpload(InputStream is, String pathParam, String name) {
        boolean isUploaded = false;
        String path = systemPath + pathParam;

        try {
            ftpClient.connect(host);
            int resultCode = ftpClient.getReplyCode();
            if (log.isDebugEnabled()) {
                log.debug("IS CONNECT? " + resultCode);
            }

            if (FTPReply.isPositiveCompletion(resultCode)) {
                ftpClient.setSoTimeout(SOCKET_TIME_OUT);
                if (this.isPassive) {
                    ftpClient.enterLocalPassiveMode();
                }

                boolean isLogin = ftpClient.login(id, pw);
                if (isLogin) {
                    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                    ftpClient.makeDirectory(path);
                    isUploaded = ftpClient.storeFile(path + SEPARATOR + name, is);
                    if (log.isDebugEnabled()) {
                        log.debug("path:" + path);
                        log.debug("name:" + name);
                        log.debug("IS SUCCESS UPLOADED? " + isUploaded);
                    }
                    
                    if (!isUploaded) {
                        throw new RuntimeException("Upload Failure");
                    }
                } else {
                    throw new FtpLoginFailException(String.format("Login Failure> id=%s&password=%s" + pw, id, pw));
                }
            } else {
                throw new RuntimeException("? FTPReply.isPositiveCompletion(resultCode) Failure");
            }
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error(e.getMessage(), e);
            }
            throw new RuntimeException(e);
        } finally {
            close();
        }
        return isUploaded;
    }

    private void close() {
        try {
            ftpClient.disconnect();
        } catch (Exception e) {
            // do nothing
        }
    }

    public InputStream getStream(String srcDir, String fileName) {
        InputStream is = null;
        try {
            ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
            is = ftpClient.retrieveFileStream(srcDir + "/" + fileName);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        
        return is;
    }
}
