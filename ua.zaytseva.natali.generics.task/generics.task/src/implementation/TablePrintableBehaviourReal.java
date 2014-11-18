//package src.implementation;
//
//import src.interfaces.PrintableBehaviour;
//
//import java.math.BigDecimal;
//import java.util.*;
//
///**
// * Created by Natali on 05.11.2014.
// */
//public class TablePrintableBehaviour extends PrintableBehaviour<List<Map<String, Object>>> {
//    Table table;
//
//    public TablePrintableBehaviour(Table table) {
//        this.table = table;
//    }
//
//    public TablePrintableBehaviour() {
//
//    }
//
//    @Override
//    public void print() {
////        System.out.println("=======================");
////        System.out.printf( "|%-5s |%-10s| %n","Col_Names", "Values");
////        System.out.println("=======================");
////        for (Map<String, Object> map : table.getRows()) {
////            for (Map.Entry<String, Object> entries : map.entrySet()) {
////                String key = entries.getKey();
////                Object value = entries.getValue();
////                String format = "|%1$-10.1s|%2$-10.10s|\n";
////
////                if (value instanceof Integer) {
////                    value = "^" + value + "^ ";
////                } else if (value instanceof Double) {
////                    value = "_ _" + value + "_ _ ";
////                } else if (value instanceof BigDecimal) {
////                    value = "$" + value + " ";
////                } else if (value instanceof String) {
////                    value = "**" + value + "** ";
////                } else if (value instanceof Float) {
////                    value = "#" + value + "# ";
////                } else if (value instanceof Byte) {
////                    value = "@" + value + "@ ";
////                } else if (value instanceof Long) {
////                    value = "LLL" + value + " ";
////                } else if (value == null) {
////                    value = "%" + value + "% ";
////                }
////                System.out.printf(format, key, value);
////            }
////            System.out.println("=======================");
////        }
////        System.out.println();
//        System.out.println("=======================");
//        System.out.printf( "|%-5s | %n","Col_Names");
//        System.out.println("=======================");
////                String formatKeys = "|%1$-10.1s|%2$-10.10s|%3$-10.10s|";
//        String formatKeys = "|%-5.10s|";
////        String formatValues = "|%1$-10.10s|%2$-10.10s|%3$-10.10s|";
//                String formatValue = "|%1$5.20s|";
//        for (Map<String, Object> map : table.getRows()) {
//            for (Map.Entry<String, Object> entries : map.entrySet()) {
//                 Set<String> keys = map.keySet();
////                for (int i = 0; i < keys.size(); i++) {
////                }
//                System.out.printf(formatKeys,keys);
//                Object value = map.values();
//                String key = entries.getKey();
////                Object value = entries.getValue();
//
//                if (value instanceof Integer) {
//                    value = "||" + value + "|| ";
////                    System.out.printf(formatValue, value);
//                } else if (value instanceof Double) {
//                    value = "_ _" + value + "_ _ ";
////                    System.out.printf(formatValue, value);
//                } else if (value instanceof BigDecimal) {
////                    value = "$" + value + " ";
//                    System.out.printf(formatValue, value);
//                } else if (value instanceof String) {
//                    value = "**" + value + "** ";
////                    System.out.printf(formatValue, value);
//                } else if (value instanceof Float) {
//                    value = "#" + value + "# ";
////                    System.out.printf(formatValue, value);
//                } else if (value instanceof Byte) {
//                    value = "@" + value + "@ ";
////                    System.out.printf(formatValue, value);
//                } else if (value instanceof Long) {
//                    value = "LLL" + value + " ";
////                    System.out.printf(formatValue, value);
//                } else if (value == null) {
//                    value = "%" + value + "% ";
////                    System.out.printf(formatValue, value);
//                }
//                System.out.printf(formatKeys,keys);
//                System.out.println();
////                System.out.printf(formatValue, value);
//                System.out.println();
//            }
//        }
//        System.out.println("=======================");
//        System.out.println();
//    }
//
//    @Override
//    public void print(int printToPage) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public void printPage(int currentPage) {
//
//        int firstRowOfPage = table.getFirstRowOfPage(currentPage) /*- table.getPageSize()*/;
//        int lastRowOfPage = table.getLastRowOfPage(currentPage) /*- table.getPageSize()*/;
//
//        if (currentPage > table.getNumberOfPagesGeneral() || currentPage <= 0) {
//            throw new NoSuchElementException("Sorry we don't have this page");
//        }
//        List<Map<String, Object>> currentPageObject = new ArrayList<>();
//        for (int i = firstRowOfPage; i < lastRowOfPage && i < table.getRows().size(); i++) {
//            currentPageObject.add(table.getRows().get(i));
//        }
//        System.out.println("=======================");
//        System.out.printf( "|%-5s |%-10s| %n","Col_Names", "Values");
//        System.out.println("=======================");
//        for (Map<String, Object> map : currentPageObject) {
//            for (Map.Entry<String, Object> entries : map.entrySet()) {
//                String key = entries.getKey();
//                Object value = entries.getValue();
//                String format = "|%1$-10.1s|%2$-10.10s|\n";
//                if (value instanceof Integer) {
//                    value = "||" + value + "|| ";
//                } else if (value instanceof Double) {
//                    value = "_ _" + value + "_ _ ";
//                } else if (value instanceof BigDecimal) {
//                    value = "$" + value + " ";
//                } else if (value instanceof String) {
//                    value = "**" + value + "** ";
//                } else if (value instanceof Float) {
//                    value = "#" + value + "# ";
//                } else if (value instanceof Byte) {
//                    value = "@" + value + "@ ";
//                } else if (value instanceof Long) {
//                    value = "LLL" + value + " ";
//                } else if (value == null) {
//                    value = "%" + value + "% ";
//                }
//                System.out.printf(format, key, value);
//            }
//        }
//        System.out.println("=======================");
//        System.out.println();
//
//    }
//}
