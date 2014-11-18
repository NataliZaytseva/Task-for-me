package src.implementation;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * реализация аспекта поведения - Сортировка по возростанию
 * Created by natali on 29.10.14.
 */
public class ASCTableSortableBehaviour extends TableSortableBehaviour {

    @Override
    public void sort(Table object, final String columnName) {
        if (object != null && columnName != null && object.getRows() != null) {
            Collections.sort(object.getRows(), new TableRowComparator(columnName));

        }
    }

    private class TableRowComparator implements Comparator<Map<String, Object>> {
        String columnName;

        public TableRowComparator(String columnName) {
            this.columnName = columnName;
        }

        @Override
        public int compare(Map<String, Object> a, Map<String, Object> b) {
         if(a.get(columnName) == null && b.get(columnName) == null ){
                return 0;
          }else if (a.get(columnName) != null && b.get(columnName) == null) {
             return -1;
          }else if (a.get(columnName) == null && b.get(columnName) != null){
             return 1;
            } else {
                if (a.get(columnName) instanceof Number && b.get(columnName) instanceof Number) {
                    return new BigDecimal(a.get(columnName).toString()).compareTo(new BigDecimal(b.get(columnName).toString()));
                } else {
                    return a.get(columnName).toString().compareTo(b.get(columnName).toString());
                }
            }
        }
    }
}


