package src.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Natali on 17.11.2014.
 */
public class VerticalPrintFirstFewPagesBehaviour extends VerticalPrintBehaviour {
    public VerticalPrintFirstFewPagesBehaviour(Table table) {
        super(table);
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print(int printToColumn) {
        int firstRowOfPage = 0;
        int lastRowOfPage = table.getRows().size();


        if (printToColumn > table.getVerticalNumberOfPagesGeneral() || printToColumn <= 0) {
            throw new NoSuchElementException("Sorry we don't have this page");
        }
        List<Map<String, Object>> currentPageObject = new ArrayList<>();

        for (int i = firstRowOfPage; i < lastRowOfPage && i < table.getRows().size(); i++) {
            currentPageObject.add(table.getRows().get(i));
        }

        printBorder(printToColumn);
        printHeaderForColumnNames();
        printBorder(printToColumn);
        printHeader(printToColumn);
        printBody(currentPageObject, printToColumn);
        printBorder(printToColumn);
    }

    @Override
    public void printPage(int currentPage) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void printHeader(int currentPage) {
        if (currentPage > table.getHeaderList().size() / (table.getPageSize() == 0 ? 1 : table.getPageSize()) || currentPage <= 0) {
            throw new NoSuchElementException("Sorry we don't have this page");
        }
        int lastColumn = table.getLastRowOfPage(currentPage);

        List<String> headerList = table.getHeaderList();
        for (int i = 0; i < lastColumn; i++) {
            String s = headerList.get(i);
            System.out.printf(formatKeys, s);
        }
        System.out.println();
    }

    @Override
    protected void printBody(List<Map<String, Object>> rowsForPrint, int currentPage) {

        for (Map<String, Object> row : rowsForPrint) {
            List<String> headerList = table.getHeaderList();

            for (int i = 0; i < (table.getLastRowOfPage(currentPage)); i++) {
                String s = headerList.get(i);
                Object object = row.get(s);
                if (object == null) {
                    object = " ";
                }
                Object str =  checkObject(object);
                System.out.printf(formatValue, str);
            }
            System.out.println();
        }
    }
}
