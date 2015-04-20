package kr.co.crewmate.site.web.taglib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 클래스명: <code>UiFunctions</code>
 *
 * <pre>
 *  시스템에서 사용하는 공통 커스텀 함수
 *  &lt;c:if test="${hfn:lineToBrEscapeXml(string, boolean)}"&gt;
 *  &lt;c:if test="${hfn:cutoff("hello", 3)}"&gt;
 *  &lt;c:if test="${hfn:progress("20120125", "20120125")}"&gt;
 *  &lt;c:if test="${hfn:rate(1000, 2)}"&gt;
 * </pre>
 *
 * @author newstar000
 * @date 2011. 11. 14.
 *
 */
public class UiFunctions {
    
    private static final String BR = "<br/>";

    @SuppressWarnings("serial")
    private static Map<Character, String> escapeMap = new HashMap<Character, String>(5) {
        {
            put(new Character('&'), "&amp;");
            put(new Character('<'), "&lt;");
            put(new Character('>'), "&gt;");
            put(new Character('\"'), "&#034;");
            put(new Character('\''), "&#039;");
        }
    };

    /**
     * <pre>
     *  여러라인으로 된 문자열 화면에서 처리
     *  &lt;c:if test="${hfn:lineToBrEscapeXml(string, boolean)}"&gt;
     * </pre>
     * @param text
     * @param escape
     * @return
     * @throws IOException
     */
    public static String lineToBrEscapeXml(final String text, final Boolean escape) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(text));
        StringBuilder buffer = new StringBuilder(text.length() + 100);

        try {
            for ( ; ; ) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                } else {
                    if (escape) {
                        for (int i = 0; i < line.length(); i++) {
                            char ch = line.charAt(i);
                            if (escapeMap.containsKey(ch)) {
                                buffer.append(escapeMap.get(ch));
                            } else {
                                buffer.append(ch);
                            }
                        }
                    } else {
                        buffer.append(line);
                    }
                    buffer.append(BR);
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return buffer.toString();
    }
    
    /**
     * <pre>
     * 글자수로 자르기
     * &lt;c:if test="${hfn:cutoff("hello", 3)}"&gt;
     * </pre>
     * @param resource
     * @param cut
     * @return
     */
    public static String cutoff(final String resource, Integer cut) {
        if (resource == null) {
            return null;
        } else {
            String result = resource.length() > cut ? StringUtils.substring(resource, 0, cut) + "..." : resource; 
            return result;
        }
    }
    
    /**
     * 진행중처리 
     * -1: 대기
     * 0: 진행중
     * 1: 진행종료
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static String progress(final Object startDateObject, final Object endDateObject) {
        int result = 0;
        String startDate = null;
        String endDate = null;
        try {
            if (startDateObject == null || endDateObject == null) {
                throw new RuntimeException("null");
            } else {
                startDate = getDateString(startDateObject);
                endDate = getDateString(endDateObject);
            }
            
            result = Utils.progress(startDate, endDate);
        } catch (RuntimeException e) {
            result = -1;
        }
        
        
        return Integer.toString(result);
    }

    private static String getDateString(Object object) {
        String result = null;
        if (object instanceof String) {
            result = object.toString();
        } else if (object instanceof Date) {
            result = Utils.getYyyymmdd((Date)object);
        } else {
            throw new RuntimeException(String.format("invalid type [%s]", object.toString()));
        }
        
        return result;
    }
    
    
    /**
     * <pre>
     * 글자수로 자르기
     * &lt;c:if test="${hfn:cutoff("hello", 3)}"&gt;
     * </pre>
     * @param resource
     * @param cut
     * @return
     */
    public static String masking(final String resource) {
    	String result = "";
    	String cutResult = "*";
    	
    	
    	if(resource == null){
    		return resource;
    	}

		if(resource.length() <= 2){
			result = resource.substring(0, 1);
			result = result + cutResult;  			    			
		}else{
			result = resource.substring(0, 1);
			result = result + cutResult;
			for(int i = 2; i< resource.length(); i++){
				result += resource;     				
			}
		}
    	
    	return result;
    }    
    
    
    public static String masking(String s, String s1) {
        String s2 = "";    
    	
        if(StringUtils.isEmpty(s)){
    		return s2;
    	}

        if(s1.equals("name")) {
            if(s.length() <= 2){
                s2 = strMaskingReplace(s, 1);
            }else{
            	s2 = s.substring(0, 1);
            	s2 = s2 + "*";
            	for(int i = s2.length(); i < s.length(); i++){
            		s2 = s2 + s.substring(i);
            		break;
            	}
            }
        } else
        if(s1.equals("engName"))
            s2 = strMaskingReplace(s, s.length());
        else
        if(s1.equals("allEngName"))
            s2 = strLeftOnMaskingReplace(s, 4);
        else                    
        if(s1.equals("psprtNum"))
            s2 = strMaskingReplace(s, 4);
        else
        if(s1.equals("id"))
            s2 = strMaskingReplace(s, 4);
        else
        if(s1.equals("address"))
            s2 = strMaskingReplace(s, 4);
        else
        if(s1.equals("birth"))
            s2 = strMaskingReplace(s, 4);
        else
        if(s1.equals("allhpTelNum"))
            s2 = strRightOnMaskingReplace(s, 4);
        else              
        if(s1.equals("hpTelNum")){
        	if(s.indexOf("-") == -1){
        		if(s.length() <= 4){
        			s2 = s;
        		}else{
        			s2 = s2 + s.substring(s.length()-4, s.length());
        		}
        	}else{
        		int fristCnt = s.indexOf("-") + 1;
        		int lastCnt = s.lastIndexOf("-");
        		if(fristCnt > lastCnt){
        			s2 = s2 +  s.substring(fristCnt);
        		}else{
	        		s2 = s.substring(0, fristCnt);
		        	for(int i = fristCnt; i < s.length(); i++){
		        		if(lastCnt > i){
		        			s2 = s2 + "*";
		        		}else{
		        			s2 = s2 + s.substring(i);
		        			break;
		        		}
		        	}
        		}
        	}
        }
        else
        if(s1.equals("mail")){
        	if(s.indexOf("@") == -1 || s.indexOf("@") == 0){
        	s2 = s;	
        	}else{
        		int fristCnt = s.indexOf("@") ;
        		if(fristCnt <= 3){
        			s2 = s.substring(0, fristCnt - 1);
        			for(int i = s2.length(); i < fristCnt; i++){
        				s2 = s2 + "*";
        			}
        		}else{
        			s2 = s.substring(0, 3);
        			for(int i = s2.length(); i < fristCnt; i++){
        				s2 = s2 + "*";
        			}
        		}
        		s2 = s2 + s.substring(fristCnt);
        	}
        }
        else
            s2 = s;
        return s2;
    }


    
    
    
    
    public static String strMaskingReplace(String s, int i){
        String s1 = "";
        if(s.length() > i){
            s1 = s.substring(0, s.length() - i);
            for(int j = 0; j < i; j++)
                s1 = s1 + "*";

        }else{
            for(int k = 0; k < s.length(); k++)
                s1 = s1 + "*";
        }
        return s1;
    }

    public static String strLeftOnMaskingReplace(String s, int i)
    {
        String s1 = "";
        int tmplen=s.length()-i; 
        if(s.length() > i)
        {
            s1 = s.substring(0, s.length()-tmplen);
            for(int j = 0; j < tmplen; j++)
                s1 = s1 + "*";

        } else
        {
            s1 = s.substring(0, 1);
            for(int k = 0; k < s.length()-1; k++)
                s1 = s1 + "*";

        }
        return s1;
    }

    public static String strRightOnMaskingReplace(String s, int i)
    {
        String s1 = "";
        String tmps1 ="";
        int tmplen=s.length()-i; 
        if(s.length() > i)
        {
            tmps1 = s.substring(tmplen,s.length());
            for(int j = 0; j < tmplen; j++)
                s1 +="*";

        } else
        {
            tmps1 = s.substring(s.length()-1,s.length() );
            for(int k = 0; k < s.length()-1; k++)
                s1 += "*";

        }
        s1 = s1+tmps1;
        return s1;
    }    

    // 주사위 확률 낮춤 2014.03.05
    public static String randomNum(Integer min, Integer max) {
    	Math.random();
    	
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date());
    	
    	int[] totalDice = new int[2];
    	
    	totalDice[0] =  (int)(Math.random()*max)+1;
    	totalDice[1] =  (int)(Math.random()*max)+1;
        	
    	int second = cal.get(Calendar.SECOND);
    	
    	if((totalDice[0] + totalDice[1] )==9) {
        	if((second > 10)) {
        		totalDice[0] =  6;
        		totalDice[1] =  4;
        	}else{
        		if(second%2==1) {
    				totalDice[0] =  1;
    				totalDice[1] =  2;
        		}
        	}
    	}
    	if((totalDice[0] + totalDice[1] )==8) {
    		if((second < 40)) {
    			totalDice[0] =  1;
    			totalDice[1] =  3;
    		}else{
    			if(second%2==0) {
    				totalDice[0] =  5;
    				totalDice[1] =  6;
    			}
    		}
    	}

		return  totalDice[0]+"^"+totalDice[1]; 
    }
    
    
 // 20140627 주사위 확률 조정(누적적립금 7000원 한도)
    public static String randomTuning(Integer min, Integer max, String eventId, String userId, Integer diceResult) {
    	Math.random();
 System.out.println("============="+userId);
 System.out.println("=======>>>======"+eventId);
 System.out.println("=======>>>======"+diceResult);
 		
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date());
    	
    	int[] totalDice = new int[2];
    	int second = cal.get(Calendar.SECOND);

    	if(diceResult >= 5000){
    		if((second > 10)) {
        		totalDice[0] =  4;
        		totalDice[1] =  2;
        	}else{
        		if(second%2==1) {
    				totalDice[0] =  1;
    				totalDice[1] =  2;
        		}
        		else{
        			totalDice[0] =  1;
    				totalDice[1] =  5;
        		}
        	}
    	}else{
    	
	    	totalDice[0] =  (int)(Math.random()*max)+1;
	    	totalDice[1] =  (int)(Math.random()*max)+1;
	        	
	    	
	    	if((totalDice[0] + totalDice[1] )==7) {
	        	if((second > 5)) {
	        		totalDice[0] =  6;
	        		totalDice[1] =  5;
	        	}else{
	        		if(second%2==1) {
	    				totalDice[0] =  1;
	    				totalDice[1] =  2;
	        		}
	        	}
	    	}
	    	if((totalDice[0] + totalDice[1] )==8) {
	    		if((second < 50)) {
	    			totalDice[0] =  2;
	    			totalDice[1] =  4;
	    		}else{
	    			if(second%2==0) {
	    				totalDice[0] =  2;
	    				totalDice[1] =  2;
	    			}
	    		}
	    	}
	    	
    	}
    	
		return  totalDice[0]+"^"+totalDice[1]; 
    }
    
    
    // 20140627 주사위 확률 조정(누적적립금 7000원 한도)
    public static String randomTuning(Integer min, Integer max, String userId, Integer diceResult) {
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date());
    	
    	int[] totalDice = new int[2];
    	int second = cal.get(Calendar.SECOND);

    	if(diceResult >= 5000){
    		if((second > 10)) {
        		totalDice[0] =  4;
        		totalDice[1] =  2;
        	}else{
        		if(second%2==1) {
    				totalDice[0] =  1;
    				totalDice[1] =  2;
        		}
        		else{
        			totalDice[0] =  1;
    				totalDice[1] =  5;
        		}
        	}
    	}else{
    	
	    	totalDice[0] =  (int)(Math.random()*max)+1;
	    	totalDice[1] =  (int)(Math.random()*max)+1;
	        	
	    	
	    	if((totalDice[0] + totalDice[1] )==7) {
	        	if((second > 5)) {
	        		totalDice[0] =  6;
	        		totalDice[1] =  5;
	        	}else{
	        		if(second%2==1) {
	    				totalDice[0] =  1;
	    				totalDice[1] =  2;
	        		}
	        	}
	    	}
	    	if((totalDice[0] + totalDice[1] )==8) {
	    		if((second < 50)) {
	    			totalDice[0] =  2;
	    			totalDice[1] =  4;
	    		}else{
	    			if(second%2==0) {
	    				totalDice[0] =  2;
	    				totalDice[1] =  2;
	    			}
	    		}
	    	}
	    	
    	}
    	
		return  totalDice[0]+"^"+totalDice[1]; 
    }    
    
    
    public static String probability(Integer min, Integer max) {
    	Math.random();
    	
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date());
    	
    	int[] totalDice = new int[2];
    	
    	totalDice[0] =  (int)(Math.random()*max)+1;
    	totalDice[1] =  (int)(Math.random()*max)+1;
        	
    	int second = cal.get(Calendar.SECOND);
    	
    	if((totalDice[0] + totalDice[1] )==7) {
        	if((second > 10)) {
        		totalDice[0] =  6;
        		totalDice[1] =  4;
        	}else{
        		if(second%2==1) {
    				totalDice[0] =  1;
    				totalDice[1] =  2;
        		}
        	}
    	}
    	if((totalDice[0] + totalDice[1] )==8) {
    		if((second < 40)) {
    			totalDice[0] =  1;
    			totalDice[1] =  3;
    		}else{
    			if(second%2==0) {
    				totalDice[0] =  5;
    				totalDice[1] =  6;
    			}
    		}
    	}

		return  totalDice[0]+"^"+totalDice[1]; 
    }    
    
    public static boolean diffOfDate(String begin) throws Exception {
    	
    	boolean checkDate = true;
    	
    	Calendar cal = Calendar.getInstance();    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
   

    	Date beginDate = formatter.parse(begin);
    	Date sysDate = formatter.parse(formatter.format(cal.getTime()));

   
    	int compare = beginDate.compareTo( sysDate ); 
    	
    	if(compare < 0) {
    		checkDate = false;
    	}else if(compare == 0){
    		checkDate = false;    		
    	}else{
    		checkDate = true;
    	}
   

		return checkDate;

    }

}
