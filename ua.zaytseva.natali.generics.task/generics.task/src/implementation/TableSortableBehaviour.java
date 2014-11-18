package src.implementation;

import src.interfaces.SortableBehavior;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * реализация аспекта поведения - сортировка с указанием направления сортировки
 * - Direction.ASC  сортировка по возрастанию
 * - Direction.DESC сортировка по убыванию
 * - при отсутствии способа сортировки - сортировки не происходит
 * Created by natali on 29.10.14.
 */
public class TableSortableBehaviour extends SortableBehavior<Table> {

    protected Direction direction;

    public TableSortableBehaviour(Direction direction) {
        this.direction = direction;
    }

    public TableSortableBehaviour() {
    }

    public void sort(Table object, String columnName, Direction direction) {
        if (columnName != null && direction != null && object.getRows() != null) {
            Collections.sort(object.getRows(), new TableRowComparator(columnName, direction));
        }
    }

    public void sort(Table object, String column) {
        sort(object, column, direction);
    }

    private class TableRowComparator implements Comparator<Map<String, Object>> {

        String columnName;
        Direction direction;

        public TableRowComparator(String columnName, Direction direction) {
            this.columnName = columnName;
            this.direction = direction;
        }

        @Override
        public int compare(Map<String, Object> a, Map<String, Object> b) {
            if (direction.equals(Direction.ASC)) {
                if (a.get(columnName) == null && b.get(columnName) == null) {
                    return 0;
                } else if (a.get(columnName) != null && b.get(columnName) == null) {
                    return -1;
                } else if (a.get(columnName) == null && b.get(columnName) != null) {
                    return 1;
                } else {
                    if (a.get(columnName) instanceof Number && b.get(columnName) instanceof Number) {
                        return new BigDecimal(a.get(columnName).toString()).compareTo(new BigDecimal(b.get(columnName).toString()));
                    } else {
                        return a.get(columnName).toString().compareTo(b.get(columnName).toString());
                    }
                }
            } else if (direction.equals(Direction.DESC)) {
                if (a.get(columnName) == null && b.get(columnName) == null) {
                    return 0;
                } else if (a.get(columnName) != null && b.get(columnName) == null) {
                    return -1;
                } else if (a.get(columnName) == null && b.get(columnName) != null) {
                    return 1;
                } else {
                    if (a.get(columnName) instanceof Number && b.get(columnName) instanceof Number) {
                        return new BigDecimal(b.get(columnName).toString()).compareTo(new BigDecimal(a.get(columnName).toString()));
                    } else {
                        return b.get(columnName).toString().compareTo(a.get(columnName).toString());
                    }
                }
            } else {
                return 0; // сортировки не происходит
            }
        }
    }
}



