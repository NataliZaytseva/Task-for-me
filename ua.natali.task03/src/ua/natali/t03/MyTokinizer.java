package ua.natali.t03;

import common.ColumnNames;
import readFrom.readImpl.BufferedReaderClass;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


public class MyTokinizer {
    public List<Salaries> tokenSeparator(List<String> list)  {

        String delimiter = null;
        boolean notEntered = true;
        List<Salaries> salaryList = new ArrayList<Salaries>();
        while (notEntered) {
            try {
                System.out.println("Enter delimiter ");
                delimiter = BufferedReaderClass.read();
                for (String parseStr : list) {
                    StringTokenizer str = new StringTokenizer(parseStr, delimiter);
                    if (parseStr.toUpperCase().contains(ColumnNames.ID.name()) | parseStr.toUpperCase().contains(ColumnNames.MONTH.name()) | parseStr.toUpperCase().contains(ColumnNames.MONEY.name())) {
                        System.out.println("There are columns at the table : ");
                        while (str.hasMoreTokens()) {
                            String token = str.nextToken();
                            System.out.print(token + "\t");
                        }
                        System.out.println();
                    }else {
                    int id = Integer.parseInt(str.nextToken());
                    String month = str.nextToken();
                    double money = Double.parseDouble(str.nextToken());
                    Salaries salaries = new Salaries(id, month, money);
                    salaryList.add(salaries);
                    }
                }
                notEntered = false;
            } catch (NumberFormatException e) {
                System.out.println("Try again");
            } catch (NoSuchElementException e) {
                System.out.println("This symbol can not be delimiter " + delimiter);
            }
        }
        return salaryList;
    }
}
