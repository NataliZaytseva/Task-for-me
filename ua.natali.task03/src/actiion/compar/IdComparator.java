package actiion.compar;

import actiion.CompareAction;
import ua.natali.t03.Salaries;

/**
 * Created by natali on 08.10.14.
 */
public class IdComparator implements CompareAction {

    @Override
    public int compare(Salaries o1, Salaries o2) {

        return o1.getId() - o2.getId();
    }
}