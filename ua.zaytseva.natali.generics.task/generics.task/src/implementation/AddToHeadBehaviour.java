package src.implementation;

import src.interfaces.AddableBehaviour;

import java.util.List;
import java.util.Map;

/**
 * Created by Natali on 05.11.2014.
 */
public class AddToHeadBehaviour extends AddableBehaviour<Map<String, Object>> {
    Table table;
    public AddToHeadBehaviour(Table table){
        this.table = table;
    }
    @Override
    public void add(Map<String, Object> row) {
        if (row != null) {
            table.getRows().add(0, row);
        }
    }

    @Override
    public void remove(int i) {
        if (i >= 0 && i < table.getRows().size()) {
            table.getRows().remove(i);
        }
    }

    @Override
    public void addRows(List<Map<String, Object>> rows) {
        this.table.getRows().addAll(0,rows);

    }

    @Override
    public void removeRows(int from, int to) {
        if ( from > 0 && from <= table.getRows().size()){
            if(to >= from && to <= table.getRows().size()){
                for( int i = from; i < to; i++ ){
                    table.getRows().remove(from-1);
                }
            }
        }
    }
}
