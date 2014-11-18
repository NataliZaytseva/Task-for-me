package src.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Natali on 14.11.2014.
 */
public class VerticalPrintBehaviour extends TablePrintableBehaviour {

    public VerticalPrintBehaviour(Table table) {
        super(table);
    }

    protected void printHeader(int currentPage) {
        if (currentPage > table.getHeaderList().size() / (table.getPageSize() == 0 ? 1 : table.getPageSize()) || currentPage <= 0) {
            throw new NoSuchElementException("Sorry we don't have this page");
        }
        int firstColumn = table.getFirstRowOfPage(currentPage);
        int lastColumn = table.getLastRowOfPage(currentPage);

        List<String> headerList = table.getHeaderList();
        for (int i = firstColumn; i < lastColumn; i++) {
            String s = headerList.get(i);
            System.out.printf(formatKeys, s);
        }
        System.out.println();
    }

    @Override
    public void printPage(int currentPage) {
        int firstRowOfPage = 0;
        int lastRowOfPage = table.getRows().size();

        if (currentPage > table.getHeaderList().size() || currentPage <= 0) {
            throw new NoSuchElementException("Sorry we don't have this page");
        }
        List<Map<String, Object>> currentPageObject = new ArrayList<>();
        for (int i = firstRowOfPage; i < lastRowOfPage && i < table.getRows().size(); i++) {
            currentPageObject.add(table.getRows().get(i));
        }
        printBorder();
        printHeaderForColumnNames();
        printBorder();

        printHeader(currentPage);
        printBody(currentPageObject, currentPage);
        printBorder();
    }

    protected void printBody(List<Map<String, Object>> rowsForPrint, int currentPage) {

        for (Map<String, Object> row : rowsForPrint) {
            List<String> headerList = table.getHeaderList();

            for (int i = (table.getFirstRowOfPage(currentPage)); i < (table.getLastRowOfPage(currentPage)); i++) {
                String s = headerList.get(i);
                Object object = row.get(s);
                if (object == null) {
                    object = " ";
                }
                Object str = checkObject(object);
                System.out.printf(formatValue, str);
            }
            System.out.println();
        }
    }

    protected void printBorder() {
        int borderLength;
        if (table.getPageSize() == 0) {
            borderLength = 15;
        } else {
            borderLength = (table.getHeaderList().size() / table.getPageSize()) * 10 + 1;
        }
        for (int i = 0; i < borderLength; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
    protected void printBorder(int printToColumn) {
        int borderLength = (printToColumn * 16) - 1;
        for (int i = 0; i < borderLength; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    @Override
    protected void printHeaderForColumnNames() {
        int widthForColumnName;
        if (table.getPageSize() == 0) {
            widthForColumnName = 1;
        } else {
            widthForColumnName = (table.getHeaderList().size() / table.getPageSize()) * 10 - 2;
        }
        System.out.printf("|%-" + widthForColumnName + "s | %n", "Column_Names");
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print(int printToPage) {
        throw new UnsupportedOperationException();
    }
}
