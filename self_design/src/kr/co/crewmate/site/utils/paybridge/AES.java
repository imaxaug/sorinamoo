package kr.co.crewmate.site.utils.paybridge;

import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
* 암호화 및 복호화를 담당 하는 클래스
*
*/
public class AES {

    public final static String ENCODE = "ENCODE";
    public final static String DECODE = "DECODE";

    private SecretKeySpec secretKey = null;
    private Cipher cipher = null;
    private String cryptoKey = null;
    
    /**
     * @return AES 암호화 키 (16Bytes)
     */
    public String makeAES16BytesKey(){
    	String [] specialChar = new String [] {"~", "!", "@", "#", "$", "%", "^", "&", "*", "+"};
    	String newCryptoKey = null;
    	String str = "" + UUID.randomUUID();
    	str = str.replaceAll("-", "");
    	
    	int i1 = (int) (Math.random() * 10);
    	int i2 = (int) (Math.random() * 10);
    	int i3 = (int) (Math.random() * 10);
    	int i4 = (int) (Math.random() * 10);
    	
    	newCryptoKey =   specialChar[i1] + str.substring(0, 3)
    			       + specialChar[i2] + str.substring(8, 11).toUpperCase()
    			       + specialChar[i3] + str.substring(16, 19)
    			       + specialChar[i4] + str.substring(24, 27).toUpperCase();

    	return newCryptoKey;
    }

    /**
     * 키생성 알고리즘은 AES 이며 데이터 암호화 방식은 AES 의 ECB 블록 방식을 따르며 페딩 규칙은 사용자 정의 페딩 규칙을 따름
     * 참조 사이트 http://java.sun.com/j2se/1.5.0/docs/guide/security/jce/JCERefGuide.html(128bit rijndael)
     *
     * @param plainText 암호화 하고자 하는 String
     * @return
     * @throws Exception
     */
     private String getEncrypt(String plainText) throws Exception{
         secretKey = new SecretKeySpec(cryptoKey.getBytes(), "AES");
         cipher = Cipher.getInstance("AES/ECB/NoPadding");

         cipher.init(Cipher.ENCRYPT_MODE, secretKey);
         byte[] lackBuf = plainText.getBytes("UTF-8");
         byte[] fullBuf = this.addPadding(lackBuf);
         byte[] encBuf = cipher.doFinal(fullBuf);
         char[] encHex = Hex.encodeHex(encBuf);

         String cipherText = new String(encHex);

         return cipherText.toUpperCase();
     }

    /**
     * 키생성 알고리즘은 AES 이며 데이터 복호화 방식은 AES 의 ECB 블록 방식을 따르며 페딩 규칙은 사용자 정의 페딩 규칙을 따름
     *    
     * @param cipherData 복호화 하고자 하는 String
     * @return
     * @throws Exception
     */
     private String getDecrypt(String cipherData) throws Exception{
        secretKey = new SecretKeySpec(cryptoKey.getBytes(), "AES");
        cipher = Cipher.getInstance("AES/ECB/NoPadding");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);        
        String cipherText = new String(cipherData.getBytes("UTF-8"));        
        char[] encHex = new char[cipherText.length()];
        for(int i=0; i < cipherText.length(); i++){
            encHex[i] = cipherText.charAt(i);
        }
        byte[] decHex = Hex.decodeHex(encHex);
        byte[] decBuf = cipher.doFinal(decHex);

        byte[] cutBuf = this.deletePadding(decBuf);

        String plainText = new String(cutBuf,"UTF-8");

        return plainText;
     }

    /**
     * 사용자 정의 키값으로 암호화 와 복호화를 사용하고자 할경우 사용
     *
     * @param encType
     * @param content
     * @param key
     * @return
     */
    public String getSecure(String encType, String content, String key) {
       String returnStr = null;

       setCryptoKey(key);

       try {
           if(encType != null && encType.equals(ENCODE)) {
               returnStr = getEncrypt(content);
           } else if (encType != null && encType.equals(DECODE)) {
               returnStr = getDecrypt(content);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

       return returnStr;
    }

    /**
     * 16바이트의 배수를 만들기 위해서 0x00(공백) 바이트 추가 함수 (현재 16바이트의 배수일 경우에도 한번은 붙여줌)
     *
     * @param lackBuf
     * @return
     */
    private byte[] addPadding(byte[] lackBuf){
        int fullLen = lackBuf.length + (16 - (lackBuf.length % 16));
        byte[] fullBuf = new byte[fullLen];

        System.arraycopy(lackBuf, 0, fullBuf, 0, lackBuf.length);

        for(int i = lackBuf.length; i < fullBuf.length; i++){
            fullBuf[i] = 0x00;
        }
        return fullBuf;
    }

    /**
     * 암호화시에 추가한 0x00(공백) 바이트 제거 함수
     *
     * @param fullBuf
     * @return
     */
    private byte[] deletePadding(byte[] fullBuf){
        int i = 0;
        boolean loop = true;

        while(loop){
            if(i == fullBuf.length || fullBuf[i] == 0x00){
                loop = false;
                i--;
            }
            i++;
        }

        byte[] cutBuf = new byte[i];

        System.arraycopy(fullBuf, 0, cutBuf, 0, i);

        return cutBuf;
    }

    /**
     * @param cryptoKey The cryptoKey to set.
     */
    public void setCryptoKey(String cryptoKey) {
        this.cryptoKey = cryptoKey;
    }
}
