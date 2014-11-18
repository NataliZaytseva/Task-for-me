package src.implementation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Natali on 06.11.2014.
 */
public class HorizontalPrintLastFewPagesBehaviour extends TablePrintableBehaviour {

    public HorizontalPrintLastFewPagesBehaviour(Table table) {
        super(table);
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print(int printFromPage) {
        int firstRowOfPage = (table.getLastRowOfPage(printFromPage) - (table.getPageSize() != 0 ? table.getPageSize() : 1));

        if (printFromPage > table.getNumberOfPagesGeneral() || printFromPage <= 0) {
            throw new NoSuchElementException("Sorry we don't have this page");
        }
        List<Map<String, Object>> currentPageObject = new ArrayList<>();

        for (int i = firstRowOfPage; i < table.getRows().size(); i++) {
            currentPageObject.add(table.getRows().get(i));
        }
        printBorder();
        printHeaderForColumnNames();
        printBorder();
        printHeader();
        printBody(currentPageObject);
        printBorder();

    }

    @Override
    public void printPage(int pageNumber) {
        throw new UnsupportedOperationException();
    }
}
