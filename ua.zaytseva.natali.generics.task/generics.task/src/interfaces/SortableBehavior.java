package src.interfaces;

import src.implementation.Direction;

/**
 * для представления определенного поведения
 * Created by natali on 29.10.14.
 */
public abstract class SortableBehavior<T> {
    public abstract void  sort(T Object, String columnName);
    public abstract void  sort(T Object, String columnName, Direction direction);
}
