package kr.co.crewmate.site.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import kr.co.crewmate.site.config.Config;
import kr.kisa.SHA256;
import kr.kisa.SeedCBC;

import org.apache.commons.codec.binary.Base64;

/**
 * 클래스명: <code>Encryption</code>
 * 
 * <pre>
 *  암호화 로직
 *  1. password 복호화안됨
 *  2. encode
 *  3. decode
 * </pre>
 * 
 * @author 이경연
 * @date 2012. 1. 3.
 * 
 */
public class Encryption {

    /**
     * 암호화 로직 이 암호는 복호화 되지않는다. -- 현시스템에서는 사용하지않음
     * 
     * @param source
     * @return
     */
    public static String passwordForOldVersion(String source) {
        SHA256 s = new SHA256(source.getBytes());
        byte[] bs = Base64.encodeBase64(s.GetHashCode());
        return byte2String(bs);
    }

    /**
     * 암호화 로직 이 암호는 복호화 되지않는다.
     * 
     * 신세계 면세점 암호화로직 SHA256
     * 
     * @param source
     * @return
     */
    public static String password(String source) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(source.getBytes());

            byte byteData[] = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            
            return hexString.toString().toUpperCase();
        } catch (Exception e) {
            throw new RuntimeException("WTF");
        }
    }

    /**
     * 암호화
     * 
     * @param source
     * @return
     */
    public static String encode(String source) {
        SeedCBC s = new SeedCBC();
        s.LoadConfig();
        byte[] bCipherText = s.Encryption(source.getBytes());
        byte[] bs = Base64.encodeBase64(bCipherText);
        return byte2String(bs);
    }

    /**
     * 복호화
     * 
     * @param result
     * @return
     */
    public static String decode(String result) {
        byte[] bs = Base64.decodeBase64(result.getBytes());
        SeedCBC s = new SeedCBC();
        s.LoadConfig();
        byte[] bPlainText = s.Decryption(bs);
        return byte2String(bPlainText);
    }

    private static String byte2String(byte[] source) {
        try {
            return new String(source, Config.getString("system.charset", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return new String(source);
        }
    }

}
