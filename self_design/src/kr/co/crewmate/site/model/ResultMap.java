package kr.co.crewmate.site.model;

import java.io.Reader;
import java.sql.Clob;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 클래스명: <code>ResultMap</code>
 *
 * <pre>
 *  기본적으로 모델을 사용함으로 특수한 경우 아니면 사용하지않는다.
 *  
 * </pre>
 *
 * @deprecated
 * @author hardline
 * @date 2012. 5. 18.
 *
 */
@Deprecated
public class ResultMap implements Map<String,Object> {

    private final Map<String,Object> data = new HashMap<String,Object>();

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public boolean containsKey(Object key) {
        return this.data.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return this.data.containsValue(value);
    }

    public Object get(Object key) {
        return this.data.get(key);
    }

    public Object remove(Object key) {
        return this.data.remove(key);
    }

    public void clear() {
        this.data.clear();
    }

    public Set<String> keySet() {
        return this.data.keySet();
    }

    @Override
    public Object put(String key, Object value)
    {
        key = key.toLowerCase();

        StringBuilder camelCaseKey = new StringBuilder();

        boolean isCamel = false;

        for(int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (ch == '_') {
                isCamel = true;
                continue;
            }

            if(isCamel == true)
                ch = Character.toUpperCase(ch);

            camelCaseKey.append(ch);
            isCamel = false;
        }

        Reader input = null;
        String cValue = "";

        if (value instanceof Clob) {
            try {
                Clob clob = (Clob) value;
                StringBuilder output = new StringBuilder();

                input = clob.getCharacterStream();

                char[] buffer = new char[1024];
                int byteRead;

                while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
                    output.append(buffer, 0, byteRead);
                }

                cValue = output.toString();
            } catch (Exception e) {
                cValue = "SYSTEM ERROR. ??????? ?????????.";
                System.out.println("Exception :" + e);
            } finally {
                try {
                    if (input != null) {
                        input.close();
                    }
                } catch (Exception e) {
                    System.out.println("ResultMap Stream Close Error:" + e.toString());
                }
            }

            return data.put(camelCaseKey.toString(), cValue);
        } else {
            return data.put(camelCaseKey.toString(), value);
        }
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> map)
    {
        this.data.putAll(map);
    }

    @Override
    public Set<Map.Entry<String, Object>> entrySet()
    {
        return this.data.entrySet();
    }

    @Override
    public Collection<Object> values()
    {
        return this.data.values();
    }

    @Override
    public String toString()
    {
        return this.data.toString();
    }
}