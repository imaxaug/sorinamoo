package kr.co.crewmate.site.utils.rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author hardline
 */
public class RankUtils {

    public static <T> T leader(List<T> list, String field, Sort order) {
        if(list == null || list.isEmpty()) return null;
        Collections.sort(list, new FieldComparator(field, order));
        return list.get(0);
    }

    public static <T> void sort(List<T> list, String field, Sort order) {
        Collections.sort(list, new FieldComparator(field, order));

        Object prev = null;
        int rank = 0;
        int seq = 0;

        for (T result : list) {
            if (result instanceof Rankable) {
                Rankable rankable = (Rankable) result;
                seq++;
                try {
                    Object value = BeanUtils.getProperty(result, field);
                    if (value.equals(prev)) {
                        rankable.setRank(rank);
                    } else {
                        rank = seq;
                        rankable.setRank(rank);
                    }
                    prev = value;
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public static <T> List<T> filterRegularInning(List<T> list, int gameCount) throws Exception {
        List<T> newList = new ArrayList<T>();

        for (T pitcher : list) {
            String value = BeanUtils.getProperty(pitcher, "oc");
            int oc = Integer.parseInt(value);
            if (oc / 3 >= gameCount) {
                newList.add(pitcher);
            }
        }

        return newList;
    }

    public static <T> List<T> filterRegularAtBats(List<T> list, int gameCount) throws Exception {
        List<T> newList = new ArrayList<T>();

        for (T pitcher : list) {
            String value = BeanUtils.getProperty(pitcher, "tpa");
            int tpa = Integer.parseInt(value);
            if (tpa >= gameCount * 3.1) {
                newList.add(pitcher);
            }
        }

        return newList;
    }

    public static <T> List<T> filter(List<T> list, FilterOption filter, String field, String compareValue) {
        List<T> newList = new ArrayList<T>();

        try {
            for (T data : list) {
                String value = BeanUtils.getProperty(data, field);
                if (filter == FilterOption.EQUAL && value.equals(compareValue)) {
                    newList.add(data);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return newList;
    }

    public static <T> int rank(List<T> list, String field, double value, Sort sort) throws Exception {
        int count = 0;
        for (T t : list) {
            String v = BeanUtils.getProperty(t, field);
            double compareValue = Double.parseDouble(v);
            if (sort == Sort.DESC && value < compareValue) {
                count++;
            }
            if (sort == Sort.ASC && value > compareValue) {
                count++;
            }
        }
        return count + 1;
    }
}
