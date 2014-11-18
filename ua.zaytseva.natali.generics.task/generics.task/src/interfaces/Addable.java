package src.interfaces;

import java.util.List;
import java.util.Map;

/**
 * Created by natali on 22.10.14.
 */
public interface Addable {

    void add(Map<String, Number> row);

    void remove(int i);

    public void addRows(List<Map<String, Number>> rows);

}
