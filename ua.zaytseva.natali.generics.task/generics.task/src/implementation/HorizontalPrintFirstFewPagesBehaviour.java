package src.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Natali on 05.11.2014.
 */
public class HorizontalPrintFirstFewPagesBehaviour extends TablePrintableBehaviour {

    public HorizontalPrintFirstFewPagesBehaviour(Table table) {
        super(table);
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print(int printToPage) {
        int lastRowOfPage = table.getLastRowOfPage(printToPage);

        if (printToPage > table.getNumberOfPagesGeneral() || printToPage <= 0) {
            throw new NoSuchElementException("Sorry we don't have this page");
        }
        List<Map<String, Object>> currentPageObject = new ArrayList<>();

        for (int i = 0; i < lastRowOfPage && i < table.getRows().size(); i++) {
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
    public void printPage(int currentPage) {
        throw new UnsupportedOperationException();
    }
}
