package ua.natali.t03;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by natali on 08.10.14.
 */
public class Token {
    private String delimiter;

    public Token(String delimiter) {
        this.delimiter = delimiter;
    }

    public List<Salaries> tokenSeparator(List<String> list) {
        List<Salaries> salaryList = new ArrayList<Salaries>();
        try {
            for (String parseStr : list) {
                StringTokenizer str = new StringTokenizer(parseStr, delimiter);
                int id = Integer.parseInt(str.nextToken());
                String month = str.nextToken();
                double money = Double.parseDouble(str.nextToken());
                Salaries salaries = new Salaries(id, month, money);
                salaryList.add(salaries);
            }
        } catch (NumberFormatException e) {
            System.out.println("This symbol can not be delimiter " + delimiter);
        }
        return salaryList;
    }
}
