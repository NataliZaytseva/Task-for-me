package src.interfaces;

import java.util.List;

/**
 * Created by Natali on 04.11.2014.
 */
public abstract class AddableBehaviour<T> {

    public abstract void add(T row);

    public abstract void remove(int i);

    public abstract void addRows(List<T> rows);

    public abstract void removeRows(int from, int to);


}
