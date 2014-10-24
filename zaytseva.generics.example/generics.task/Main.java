import implementation.Table;

import java.io.IOException;
import java.util.*;

/**
 * Created by natali on 22.10.14.
 */
public class Main {

    public static void main(String[] args) throws IOException {


        List<Map<String, Integer>> list = new ArrayList<>();


        Table table = new Table(list);
        table.add(new TreeMap<String, Integer>() {{
            put("c", 1);
            put("b", 2);
            put("a", 3);
        }});
        table.add(new TreeMap<String, Integer>() {{
            put("b", 7);
            put("a", 8);
            put("c", 9);
        }});
        table.add(new TreeMap<String, Integer>() {{
            put("c", 3);
            put("a", 2);
            put("b", 1);
        }});
        table.add(new TreeMap<String, Integer>() {{
            put("c", 4);
            put("b", 5);
            put("a", 6);
        }});
        table.add(new TreeMap<String, Integer>() {{
            put("a", 4);
            put("b", 5);
            put("c", 6);
        }});
        table.sort("b");
        table.print();
    }
}



