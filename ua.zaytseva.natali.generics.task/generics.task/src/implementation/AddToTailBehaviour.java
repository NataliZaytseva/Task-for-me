package src.implementation;

import src.interfaces.AddableBehaviour;

import java.util.List;
import java.util.Map;

/**
 * Created by Natali on 04.11.2014.
 */
public class AddToTailBehaviour extends AddableBehaviour<Map<String, Object>> {
    Table table;

    public AddToTailBehaviour(Table table) {
        this.table = table;
    }

    @Override
    public void add(Map<String, Object> row) {
        if (row != null) {
            table.getRows().add(row);
        }
    }

    @Override
    public void remove(int i) {
        if (i > 0 && i <= table.getRows().size()) {
            table.getRows().remove(i - 1);
        }
    }

    @Override
    public void addRows(List<Map<String, Object>> rows) {
        if (rows != null) {
            this.table.getRows().addAll(rows);
        }
    }

    @Override
    public void removeRows(int from, int to) {
        if (from > 0 && from <= table.getRows().size()) {
            if (to >= from && to <= table.getRows().size()) {
                for (int i = from; i < to; i++) {
                    table.getRows().remove(from - 1);
                }
            }
        }
    }
}
