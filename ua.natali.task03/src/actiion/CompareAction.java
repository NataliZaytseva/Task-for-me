package actiion;

import ua.natali.t03.Salaries;

import java.util.Comparator;

/**
 * Created by natali on 08.10.14.
 */
public interface CompareAction extends Comparator<Salaries> {
    public int compare(Salaries o1, Salaries o2);

}
