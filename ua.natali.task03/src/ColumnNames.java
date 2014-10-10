import actiion.CompareAction;
import actiion.compar.IdComparator;
import actiion.compar.MoneyComparator;
import actiion.compar.MonthComparator;
import analize.AnalizerInterface;
import analize.columnNameAnalizers.IDAnalizer;
import analize.columnNameAnalizers.MoneyAnalizer;
import analize.columnNameAnalizers.MonthAnalizer;
import ua.natali.t03.Salaries;
import ua.natali.t03.Token;

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
    public static void names() {
        System.out.println("There are columns at the table : " );
        for (ColumnNames names : ColumnNames.values()) {
            System.out.print(names + "\t");
        }
        System.out.println();
    }

    public static List<Salaries> findColumnAndSort(String columnName, List<String> lines/*, String delimiter*/) {
        List<Salaries> salaries = null;

        for (ColumnNames names : ColumnNames.values()) {
            if (names.analizer.analize(columnName)) {
                Token token = new Token();
                salaries = token.tokenSeparator(lines);
                Collections.sort(salaries, names.compareAction);
            }
        }
        return salaries;
    }
}
