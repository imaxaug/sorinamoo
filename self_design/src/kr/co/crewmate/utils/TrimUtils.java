/**
 *
 */
package kr.co.crewmate.utils;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * 클래스명: <code>ParamUtils.java</code>
 *
 * <pre>
 * String field 관련 trim util 
 * </pre>
 *
 * @date 2010. 10. 7.
 * @author ssundance
 *
 */
public class TrimUtils {
    /**
     * 매개변수의 모든 getter method 중 리턴타입이 String인 method들을 이용해서 문자열 파라미터들을 trim 적용한다.
     * @param obj
     * @throws Exception
     */
    public static void trimAllStringParam(Object obj) {
        if (obj != null) {
            int getIndex = 0;
            String get = "get";
            String set = "set";
            String methodName = null;
            String valueOfVariable = null;
            String nameOfVariable = null;
            Method getMethod = null;
            Method setMethod = null;
            Class<?> returnTypeClass = null;
            Class<?> clazz = obj.getClass();
    
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                methodName = method.getName();
                getIndex = StringUtils.indexOf(methodName, get);
                returnTypeClass = method.getReturnType();
    
                try {
                    if (getIndex == 0 && returnTypeClass == String.class) { // getter method 찾기
                        getMethod = method;
                        nameOfVariable = StringUtils.substringAfter(methodName, get);
                        valueOfVariable = (String) getMethod.invoke(obj); // getter method 호출
    
                        if (!StringUtils.isEmpty(valueOfVariable)) {
                            valueOfVariable = StringUtils.trimToNull(valueOfVariable); // 공백은 null 처리
                            setMethod = clazz.getMethod(set + nameOfVariable, String.class);
                            setMethod.invoke(obj, valueOfVariable); // setter method 호출
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
