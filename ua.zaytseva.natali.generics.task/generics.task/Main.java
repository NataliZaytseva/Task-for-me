import src.implementation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by natali on 22.10.14.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        List<Map<String, Object>> list = new ArrayList<>();
                           // установка типа сортирровки таблицы
        Table table = new Table(new ASCTableSortableBehaviour(), list);
//        Table table = new Table(new DESCTableSortableBehaviour(),list);  // сортировка по убыванию
//        Table table = new Table(new TableSortableBehaviour(Direction.ASC),list);
//        Table table = new Table(new TableSortableBehaviour(Direction.DESC),list);
//        Table table = new Table(new TableSortableBehaviour(),list);  // сортировки не происходит
                                   //установка типа добавления
        table.setAddableBehaviour((new AddToTailBehaviour(table)));
//        table.setAddableBehaviour((new AddToHeadBehaviour(table)));
        table.add(new TreeMap<String, Object>() {{
            put("b", 7);
            put("a", 8);
            put("c", 9l);
        }});

        table.add(new TreeMap<String, Object>() {{
            put("c", 1.7f);
            put("b", 2);
            put("a", 3);
        }});
        table.add(new TreeMap<String, Object>() {{
            put("c", 3);
            put("a", (byte)2);
            put("b", 1);
        }});

        table.add(new TreeMap<String, Object>() {{
            put("c", 4.0);
            put("b", 5.0);
            put("a", 6.0);
        }});

        table.add(new TreeMap<String, Object>() {{
            put("a", 4f);
            put("b", 5.5d);
            put("c", new BigDecimal("1000000000000000000000"));
        }});
        table.add(new TreeMap<String, Object>() {{
            put("m", 10);

        }});

        table.add(new TreeMap<String, Object>() {{
            put("l", null);

        }});
        table.add(new TreeMap<String, Object>() {{
            put("m", 5);

        }});


                              // добавление строк
        table.addRows(new ArrayList<Map<String, Object>>() {
            {
                add(new TreeMap<String, Object>() {{
                    put("a", 2);
                    put("b", 2);
                    put("c", 3f);
                }});
                add(new TreeMap<String, Object>() {{
                    put("a", 1);
                    put("b", 1);
                    put("c", "Some String");
                }});
                add(new TreeMap<String, Object>() {{
                    put("a", 3);
                    put("b", 3);
                    put("c", 10000);
                }});
                add(new TreeMap<String, Object>() {{
                    put("a", 4d);
                    put("b", 4d);
                    put("c", 4d);
                }});
                add(new TreeMap<String, Object>() {{
                    put("w", 5d);

                }});
            }
        });
                         // установка типа распечатывания
        table.setPrintableBehaviour(new TablePrintableBehaviour(table));
//        table.print();
        table.setSort("a");
        table.print();
        table.setPageSize(2);
//        table.printPage(1);


//        table.setPrintableBehaviour(new HorizontalPrintFirstFewPagesBehaviour(table));
//        table.print(8);
//        table.setSort("c");
//        table.setPageSize(2);
//        table.print(4);

//        table.setPrintableBehaviour(new HorizontalPrintLastFewPagesBehaviour(table));
//        table.print(8);
//        table.setSort("c");
//        table.setPageSize(2);
//        table.print(4);


        table.setPrintableBehaviour(new VerticalPrintBehaviour(table));
        table.printPage(3);


//        table.setPrintableBehaviour(new VerticalPrintFirstFewPagesBehaviour(table));
//        table.print(1);

                  // установка типа страниц
//        table.setTablePageableBehaviour(new HorizontalEvenPageableBehaviour(table));
//        System.out.println(table.hasNext());
//        System.out.println(table.hasPrevious());
//        System.out.println(table.getNumberOfPages());
//        table.printPage(table.currentPage());
//        table.printPage(table.nextPage());
//        table.printPage(table.previousPage());

        table.setTablePageableBehaviour(new VerticalEvenPageableBehaviour(table));
        System.out.println(table.hasNext());
        System.out.println(table.hasPrevious());
        System.out.println(table.getVerticalNumberOfPagesGeneral());
        table.printPage(table.currentPage());
//        System.out.println(table.hasNext());
//        System.out.println(table.hasNext());
//        System.out.println(table.hasNext());
//        System.out.println(table.hasNext());

//        table.printPage(table.nextPage());

//        table.printPage(table.previousPage());

//        table.setTablePageableBehaviour(new HorizontalUnEvenPageableBehaviour(table));
//        System.out.println(table.hasNext());
//        System.out.println(table.hasPrevious());
//        System.out.println(table.getNumberOfPages());
//        table.printPage(table.currentPage());
//        table.printPage(table.nextPage());
//        table.printPage(table.previousPage());

//        table.setTablePageableBehaviour(new VerticalUnEvenPageableBehaviour(table));
//        System.out.println(table.hasNext());
//        System.out.println(table.hasPrevious());
//       System.out.println(table.getVerticalNumberOfPagesGeneral());
//        table.printPage(table.currentPage());
//        table.printPage(table.nextPage());
//        table.printPage(table.previousPage());

////
//        System.out.println(table.getNumberOfPagesGeneral());
//
////        table.remove(1);
////        table.removeRows(2,5);
////        table.removePage(1);
//        table.print();
//        System.out.println(table.getNumberOfPagesGeneral());
    }
}



