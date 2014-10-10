package ua.natali.t03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by natali on 08.10.14.
 */
public class Token {
    private String delimiter;

    public List<Salaries> tokenSeparator(List<String> list) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String delimiter = null;
        boolean notEntered = true;
        List<Salaries> salaryList = new ArrayList<Salaries>();
        while (notEntered) {
            try {
                while (notEntered) {
                    System.out.println("Enter delimiter ");
                    delimiter = reader.readLine();

                    for (String parseStr : list) {
                        StringTokenizer str = new StringTokenizer(parseStr, delimiter);
                        int id = Integer.parseInt(str.nextToken());
                        String month = str.nextToken();
                        double money = Double.parseDouble(str.nextToken());
                        Salaries salaries = new Salaries(id, month, money);
                        salaryList.add(salaries);

                        notEntered = false;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("This symbol can not be delimiter " + delimiter);
                System.out.println("Try again");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return salaryList;
    }
}
