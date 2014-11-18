package src.implementation;

import src.interfaces.PrintableBehaviour;
import java.math.BigDecimal;
import java.util.*;

public class TablePrintableBehaviour extends PrintableBehaviour<List<Map<String, Object>>> {
    Table table;
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
        int borderLenght = (table.getHeaderList().size() * 16) - 1;
        for (int i = 0; i < borderLenght; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    protected void printHeaderForColumnNames() {
        int widthForColumnName = (table.getHeaderList().size() * 16) - 4;
        System.out.printf("|%-" + widthForColumnName + "s | %n", "Column_Names");
    }

    protected void printHeader() {
        String formatKeys = "|%-13.1s| ";
        List<String> headerList = table.getHeaderList();
        for (String s : headerList) {
            System.out.printf(formatKeys, s);
        }
        System.out.println();
    }

    protected void printBody(List<Map<String, Object>> rowsForPrint) {
        String formatValue = "|%-13.13s| ";

        for (Map<String, Object> row : rowsForPrint) {
            List<String> headerList = table.getHeaderList();
            for (String key : headerList) {
                Object object = row.get(key);

                if (object == null) {
                    object = " ";
                }
                if (object instanceof Integer) {
                    object = "||" + object + "|| ";
                } else if (object instanceof Double) {
                    object = "_ _" + object + "_ _ ";
                } else if (object instanceof BigDecimal) {
                    object = "$" + object + " ";
                } else if (object instanceof String) {
                    object = "*" + object + "* ";
                } else if (object instanceof Float) {
                    object = "#" + object + "# ";
                } else if (object instanceof Byte) {
                    object = "@" + object + "@ ";
                } else if (object instanceof Long) {
                    object = "LLL" + object + " ";
                } else if (object == null) {
                    object = "%" + object + "% ";
                }
                System.out.printf(formatValue, object);
            }
            System.out.println();
        }
    }
}
