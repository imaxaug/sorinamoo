package kr.co.crewmate.site.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * 클래스명: <code>EncryptUtils</code>
 *
 * <pre>
 *  LG U+에서 사용하는  MD5 해쉬암호화 
 * </pre>
 *
 * @author newstar000
 * @date 2012. 2. 3.
 *
 */
public class EncryptUtils {

    public static String md5(String target) {
        byte[] bNoti = target.getBytes();
        MessageDigest md = null;
        
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        
        byte[] digest = md.digest(bNoti);

        StringBuffer sb = new StringBuffer();
        for (int i=0 ; i < digest.length ; i++) {
            int c = digest[i] & 0xff;
            if (c <= 15){
                sb.append("0");
            }
            sb.append(Integer.toHexString(c));
        }
        
        return sb.toString();
    }
}
