package kr.co.crewmate.site.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kr.co.crewmate.http.Url;
import kr.co.crewmate.utils.Closer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;

/**
 *
 * 클래스명: <code>Config</code>
 *
 * <pre>
 * 설정 파일 load관리
 * ssgdfs.xml의 환경변수를 메모리에 간직하는 클래스
 * </pre>
 *
 * @date 2010. 6. 10.
 * @author 이경연
 *
 */
public class Config implements ConfigKey {

    private static Properties properties = new Properties();

    public Config(Resource location) {
        try {
            if (location.exists()) {
                properties.loadFromXML(location.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadConfiguration(String path) {
        try {
            File file = new File(path);
            InputStream input = new FileInputStream(file);
            properties.loadFromXML(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getString(String key) {
        String propertiesValue = properties.getProperty(key);
        if (propertiesValue == null) {
            throw new ConfigValueNotFoundException(key + " 에 해당하는 환경 변수값을 찾을 수 없음");
        } else {
            return propertiesValue;
        }
    }

    public static String getString(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static int getInt(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new ConfigValueNotFoundException(key + " 에 해당하는 환경 변수값을 찾을 수 없음");
        } else {
            try {
                return Integer.parseInt(properties.getProperty(key));
            } catch (NumberFormatException e) {
                throw new ConfigValueNotFoundException(key + " 에 값[" + value + "]는 정수여야함");
            }
        }
    }

    public static int getInt(String key, int defaultValue) {
        try {
            return Integer.parseInt(properties.getProperty(key));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static boolean getBoolean(String key) {
        return stringToBoolean(properties.getProperty(key));
    }

    private static boolean stringToBoolean(String value) {
        if (value == null) {
            return false;
        }
        if (value.equals("true")) {
            return true;
        }
        if (value.equals("on")) {
            return true;
        }
        if (value.equals("yes")) {
            return true;
        }
        if (value.equals("1")) {
            return true;
        }
        if (value.equals("Y")) {
            return true;
        }
        return false;
    }
    
    public static long getLong(String key, long defaultValue) {
        try {
            return Long.parseLong(properties.getProperty(key));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Properties properties() {
        return (Properties) properties.clone();
    }

    /**
     * newline 으로 분리되는 설정값 리스트를 반환한다.
     *
     * @param key
     * @return \n으로 분리되는 설정값 리스트
     */
    public static List<String> getStrings(String key) {
        String propertyValue = getString(key);
        BufferedReader reader = null;
        StringReader stringReader = new StringReader(propertyValue);

        List<String> propertyValues = new ArrayList<String>();
        try {
            reader = new BufferedReader(stringReader);
            for (;;) {
                String line = readline(reader);
                if (line == null) {
                    break;
                } else if (StringUtils.isEmpty(line.trim())) {
                    continue;
                } else {
                    propertyValues.add(line.trim());
                }
            }
        } finally {
            if (reader != null) {
                Closer.close(reader);
            }
        }

        return propertyValues;
    }

    /**
     * Exception 이런오류 안나 걱정하지마 
     * @param reader
     * @return
     */
    private static String readline(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getImageServerHost() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("//");
        buffer.append(Config.getString("image.server.host"));
        int port = Config.getInt("image.server.port", 80);
        if (port != 80) {
            buffer.append(":");
            buffer.append(port);
        }
        return buffer.toString();
    }
    
    public static String getUploadServerWithSchema() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(Url.DEFAULT_PROTOCOL);
        buffer.append(getUploadServerHost());
        return buffer.toString();
    }

    public static String getUploadServerHost() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("//");
        buffer.append(Config.getString("image.server.host"));
        int port = Config.getInt("image.server.port", 80);
        if (port != 80) {
            buffer.append(":");
            buffer.append(port);
        }
        return buffer.toString();
    }

    public static String getSystemAdminId() {
        return getString("system.admin");
    }
    
    public static String getDefaultGroupId() {
        return getString("default.grade");
    }

    public static String getSiteNatnCode() {
        return getString("site.natn.code", "KR");
    }
    
    public static String getLangCode() {
        return getString("lang.code", "KR");
    }
    
    public static String getServerHostForFront() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(Url.DEFAULT_PROTOCOL);
        buffer.append("://");
        buffer.append(Config.getString("server.front.host"));
        int port = Config.getInt("server.front.port", 80);
        if (port != 80) {
            buffer.append(":");
            buffer.append(port);
        }
        
        return buffer.toString();
    }
    
    public static String getWWWServerHost() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(Url.DEFAULT_PROTOCOL);
        buffer.append("://");
        buffer.append(Config.getString("www.server.host"));
        int port = Config.getInt("www.server.port", 80);
        if (port != 80) {
            buffer.append(":");
            buffer.append(port);
        }
        
        return buffer.toString();
    }
    
    public static String getMServerHost() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(Url.DEFAULT_PROTOCOL);
        buffer.append("://");
        buffer.append(Config.getString("m.server.host"));
        int port = Config.getInt("m.server.port", 80);
        if (port != 80) {
            buffer.append(":");
            buffer.append(port);
        }
        
        return buffer.toString();
    }
    
    public static String getServerHostForFrontCN() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(Url.DEFAULT_PROTOCOL);
        buffer.append("://");
        buffer.append(Config.getString("server.front.host.CN"));
        int port = Config.getInt("server.front.port.CN", 80);
        if (port != 80) {
            buffer.append(":");
            buffer.append(port);
        }
        
        return buffer.toString();
    }
    
    public static String getServerHostForSSL() {
        boolean isSsl = Config.isSslYn();
        StringBuilder buffer = new StringBuilder();
        buffer.append(isSsl ? "https" : Url.DEFAULT_PROTOCOL);
        buffer.append("://");
        buffer.append(Config.getString("server.host"));
        int port = Config.getInt("server.port", 80);
        if (port != 80) {
            buffer.append(":");
            buffer.append(port);
        }
        
        return buffer.toString();
    }
    
    public static String getServerHost() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(Url.DEFAULT_PROTOCOL);
        buffer.append("://");
        buffer.append(Config.getString("server.host"));
        int port = Config.getInt("server.port", 80);
        if (port != 80) {
            buffer.append(":");
            buffer.append(port);
        }
        
        return buffer.toString();
    }
    
    public static boolean isSslYn() {
        return Config.getBoolean("ssl.yn");
    }

    public static String getServerHostForFrontMobile() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(Url.DEFAULT_PROTOCOL);
        buffer.append("://");
        buffer.append(Config.getString("server.front.host.Mobile"));
        int port = Config.getInt("server.front.port.Mobile", 80);
        if (port != 80) {
            buffer.append(":");
            buffer.append(port);
        }
        
        return buffer.toString();
    }
    
    
    public static String getServerHostForFrontMobileCN() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(Url.DEFAULT_PROTOCOL);
        buffer.append("://");
        buffer.append(Config.getString("server.front.host.Mobile"));
        int port = Config.getInt("server.front.port.Mobile", 80);
        if (port != 80) {
            buffer.append(":");
            buffer.append(port);
        }
        
        return buffer.toString();
    }    
    
    public static boolean getBrandShopUseYn(){
    	String brandShopYn = Config.getString("brandshop.yn");
    	if("Y".equals(brandShopYn))
    		return true;
    	else
    		return false;
    }

    public static double getSsgPoingSaveRate(){
    	String rate = Config.getString("ssgpoint.save.rate");
    	double saveRate = Double.parseDouble(rate);

    	return saveRate;
    }
   
    public static String getOnlyServerHost() {
        String onlyServerHost = Config.getString("server.host");

        if(onlyServerHost.substring(0, 4).equals("www.")){
            onlyServerHost = onlyServerHost.substring(4, onlyServerHost.length());
        }

        StringBuilder buffer = new StringBuilder();
        buffer.append(onlyServerHost);

        return buffer.toString();
    }    

}