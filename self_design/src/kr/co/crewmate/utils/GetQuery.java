package kr.co.crewmate.utils;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;

import kr.co.crewmate.site.Constants;

import org.apache.commons.lang3.StringUtils;


public class GetQuery {
    
    @SuppressWarnings("serial")
    static Set<String> exceptParameter = new HashSet<String>() {
        {
            add("getClass");
        }
    };
    
    public static String getQuery(Object obj){
        Method[] methods = obj.getClass().getMethods();
        StringBuilder buffer = new StringBuilder();
        boolean start = true;
        
        for (Method method: methods) {
            String methodName = method.getName();
            if (exceptParameter.contains(methodName)) {
                continue;
            }
            
            if (methodName.startsWith("get")) {
                StringBuilder guessField = new StringBuilder(methodName.length() - 3);
                for (int i = 0; i < methodName.length(); i++) {
                    if (i < 3) {
                        continue;
                    } else {
                        char ch = methodName.charAt(i);
                        if (i == 3) {
                            guessField.append(Character.toLowerCase(ch));
                        } else {
                            guessField.append(ch);
                        }
                    }
                }

                try {
                    Object o = method.invoke(obj, new Object[]{});
                    if (o != null && StringUtils.isNotEmpty(o.toString())) {
                        if (start) {
                            start = false;
                        } else {
                            buffer.append(',');
                        }

                        buffer.append(guessField).append('=').append(URLEncoder.encode(o.toString(), Constants.WAS_CHARSET));
                    }
                } catch (Exception ignore) {
                    // ignore
                }
            }
        }

        return buffer.toString();
    }
}