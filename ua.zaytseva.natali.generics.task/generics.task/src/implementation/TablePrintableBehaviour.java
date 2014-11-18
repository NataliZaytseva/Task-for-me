package src.implementation;

import src.interfaces.PrintableBehaviour;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class TablePrintableBehaviour extends PrintableBehaviour<List<Map<String, Object>>> {
    Table table;
    protected  String formatKeys = "|%-13.1s| ";
    protected  String formatValue = "|%-13.13s| ";
    public TablePrintableBehaviour(Table table) {
        this.table = table;
    }

    @Override
    public void print() {
        printBorder();
        printHeaderForColumnNames();
        printBorder();

        printHeader();
        List<Map<String, Object>> fullList = table.getRows();
        printBody(fullList);
        printBorder();
    }

    @Override
    public void printPage(int currentPage) {

        int firstRowOfPage = table.getFirstRowOfPage(currentPage);
        int lastRowOfPage = table.getLastRowOfPage(currentPage);

        if (currentPage > table.getNumberOfPagesGeneral() || currentPage <= 0) {
            throw new NoSuchElementException("Sorry we don't have this page");
        }
        List<Map<String, Object>> currentPageObject = new ArrayList<>();
        for (int i = firstRowOfPage; i < lastRowOfPage && i < table.getRows().size(); i++) {
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
    public void print(int printToPage) {
        throw new UnsupportedOperationException();
    }

    protected void printBorder() {
        int borderLength = (table.getHeaderList().size() * 16) - 1;
        for (int i = 0; i < borderLength; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    protected void printHeaderForColumnNames() {
        int widthForColumnName = (table.getHeaderList().size() * 16) - 4;
        System.out.printf("|%-" + widthForColumnName + "s | %n", "Column_Names");
    }

    protected void printHeader() {
        List<String> headerList = table.getHeaderList();
        for (String s : headerList) {
            System.out.printf(formatKeys, s);
        }
        System.out.println();
    }

    protected void printBody(List<Map<String, Object>> rowsForPrint) {

        for (Map<String, Object> row : rowsForPrint) {
            List<String> headerList = table.getHeaderList();
            for (String key : headerList) {
                Object object = row.get(key);

                if (object == null) {
                    object = " ";
                }
                Object str = checkObject(object);
                System.out.printf(formatValue, str);
            }
            System.out.println();
        }
    }
    protected Object checkObject(Object object) {
        if (object instanceof Integer) {
            return object = "||" + object + "|| ";
        } else if (object instanceof Double) {
            return object = "_ _" + object + "_ _ ";
        } else if (object instanceof BigDecimal) {
            return object = "$" + object + " ";
        } else if (object instanceof String) {
            return object = "*" + object + "* ";
        } else if (object instanceof Float) {
            return object = "#" + object + "# ";
        } else if (object instanceof Byte) {
            return object = "@" + object + "@ ";
        } else if (object instanceof Long) {
            return object = "LLL" + object + " ";
        } else if (object == null) {
            return object = "%" + object + "% ";
        }
        return object;
    }
}
