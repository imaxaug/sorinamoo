package kr.co.crewmate.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 클래스명: <code>EscapeUtils</code>
 *
 * <pre>
 *  XSS보안문제에 관련된 파라매터 변경
 *  
 *  이는 resin의 RequestParameter방식이 Clone이 아니기 때문에 
 *  해당과 같이 처리가가능하다. 만약 RequestParameter방식이 Clone방식일때는 
 *  표준에 마추어 해당 스크립트 언어를 캐치했을때에는 Exception을 떨궈야한다.
 * </pre>
 *
 * @author newstar000
 * @date 2012. 5. 21.
 *
 */
public class EscapeUtils {

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
     * 
     * @param text 변경할 문자열
     * @param escape escape 여부
     * @return
     * @throws IOException
     */
    public static String escapeXml(final String text, final Boolean escape) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(text));
        StringBuilder buffer = new StringBuilder(text.length() + 100);
        boolean start = true;
        
        try {
            for ( ; ; ) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                } else {
                    if (start) {
                        start = false;
                    } else {
                        buffer.append("\n");
                    }
                    
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
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return buffer.toString();
    }
}