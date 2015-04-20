package kr.co.crewmate.site.dao.ibatis;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

/**
 * 
 * 클래스명: <code>YNBooleanTypeHandler</code>
 * <pre>
 * </pre>
 *
 * @date 2010. 6. 9.
 * @author hardline
 *
 */
public class YNBooleanTypeHandler implements TypeHandlerCallback {

    static final String TRUE = "Y";

    static final String FALSE = "N";

    public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {
        if (parameter == null) {
            setter.setString(FALSE);
            return;
        }

        final Boolean bool = (Boolean) parameter;

        if (bool.booleanValue()) {
            setter.setString(TRUE);
        }
        else {
            setter.setString(FALSE);
        }
    }

    public Object getResult(ResultGetter getter) throws SQLException {
        final String dbValue = trim(getter.getString());
        final Object result = valueOf(dbValue);

        return result;
    }

    public Object valueOf(String s) {
        if (s == null) {
            return Boolean.FALSE;
        }

        final String value = trim(s);

        if (TRUE.equals(value)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    static String trim(String string) {
        return (string == null) ? null : string.trim();
    }
}