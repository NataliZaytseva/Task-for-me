package actiion.compar;

import actiion.CompareAction;
import ua.natali.t03.Salaries;

/**
 * Created by natali on 08.10.14.
 */
public class MoneyComparator implements CompareAction {

    @Override
    public int compare(Salaries o1, Salaries o2) {
        int result = Double.compare(o1.getMoney(), (o2.getMoney()));
        return result;
    }
}
