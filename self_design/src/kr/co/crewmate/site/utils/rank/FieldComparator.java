package kr.co.crewmate.site.utils.rank;

import java.util.Comparator;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author hardline
 */
public class FieldComparator implements Comparator<Object> {

    private String field;
    
    private Sort sort;

    public FieldComparator(String field, Sort sort) {
        this.field = field;
        this.sort = sort;
    }

    @Override
    public int compare(Object o1, Object o2) {
        try {
            String value1 = BeanUtils.getProperty(o1, field);
            String value2 = BeanUtils.getProperty(o2, field);

            Double doubleValue1 = Double.valueOf(value1);
            Double doubleValue2 = Double.valueOf(value2);

            if (doubleValue1 < doubleValue2) {
                return sort == Sort.ASC ? -1 : 1;
            } else if (doubleValue1 == doubleValue2) {
                return 0;
            } else if (doubleValue1 > doubleValue2) {
                return sort == Sort.DESC ? -1 : 1;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return 0;
    }
}
