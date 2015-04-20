package kr.co.crewmate.site.utils.paybridge;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

public class MakeHash {	
    public String sha(String text, String charset){
        return DigestUtils.shaHex(getContentBytes(text, charset));
    }
    
    public byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }

        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(charset);
        }
    }
}
