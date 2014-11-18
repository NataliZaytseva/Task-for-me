package src.implementation;

import src.interfaces.PrintableBehaviour;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Natali on 14.11.2014.
 */
//public class VerticalPrintBehaviour extends TablePrintableBehaviour {
public class VerticalPrintBehaviour extends PrintableBehaviour<List<Map<String, Object>>> {
    Table table;
    public VerticalPrintBehaviour(Table table) {
        this.table = table;
    }

    protected void printHeader(int currentPage) {
        if (currentPage > table.getHeaderList().size()/(table.getPageSize() == 0 ? 1 : table.getPageSize()) || currentPage <= 0) {
            throw new NoSuchElementException("Sorry we don't have this page");
        }
        int firstColumn = table.getFirstRowOfPage(currentPage) ;
        int lastColumn = table.getLastRowOfPage(currentPage);

        printBorder();
        String formatKeys = "|%-13.1s| ";
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
        String formatValue = "|%-13.10s| ";

        for (Map<String, Object> row : rowsForPrint) {
            List<String> headerList = table.getHeaderList();

            for (int i = (table.getFirstRowOfPage(currentPage)); i < (table.getLastRowOfPage(currentPage)); i++) {
                String s = headerList.get(i);
                Object object = row.get(s);
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


    protected void printBorder() {
        int borderLenght;
        if (table.getPageSize() == 0 ){
             borderLenght = 15;
        }else {
         borderLenght = (table.getHeaderList().size()/ table.getPageSize())* 10 +1;}
        for (int i = 0; i < borderLenght; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    protected void printHeaderForColumnNames() {
        int widthForColumnName;
        if (table.getPageSize() == 0 ){
            widthForColumnName = 1;
        }else {
        widthForColumnName =  (table.getHeaderList().size()/ table.getPageSize())* 10 -2 ;}
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
