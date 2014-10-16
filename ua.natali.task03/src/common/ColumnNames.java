package common;

import actiion.CompareAction;
import actiion.compar.IdComparator;
import actiion.compar.MoneyComparator;
import actiion.compar.MonthComparator;
import analize.AnalizerInterface;
import analize.columnNameAnalizers.IDAnalizer;
import analize.columnNameAnalizers.MoneyAnalizer;
import analize.columnNameAnalizers.MonthAnalizer;
import ua.natali.t03.MyTokinizer;
import ua.natali.t03.Salaries;
import verification.Verification;

import java.util.Collections;
import java.util.List;


/**
 * Created by natali on 08.10.14.
 */
public enum ColumnNames {

    ID(new IDAnalizer(), new IdComparator()),
    MONTH(new MonthAnalizer(), new MonthComparator()),
    MONEY(new MoneyAnalizer(), new MoneyComparator());

    private AnalizerInterface analizer;
    private CompareAction compareAction;

    ColumnNames(AnalizerInterface analizer, CompareAction compareAction) {
        this.analizer = analizer;
        this.compareAction = compareAction;

    }

    public static List<Salaries> findColumnAndSort(List<String> lines) {

        MyTokinizer token = new MyTokinizer();
        List<Salaries> salaries = token.tokenSeparator(lines);
        ColumnNames columnName = Verification.columnVerification();
        Collections.sort(salaries, columnName.compareAction);

        return salaries;
    }

    public AnalizerInterface getAnalizer(){
        return analizer;
    }
}
