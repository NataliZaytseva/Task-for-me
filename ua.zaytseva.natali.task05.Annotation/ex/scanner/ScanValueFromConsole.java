package scanner;

import printInstance.PrintInstance;

import java.util.Scanner;

/**
 * Created by Natali on 28.11.2014.
 */
public class ScanValueFromConsole {
    private Scanner scanner;

    public void startScanner() {
        scanner = new Scanner(System.in);
    }

    public void close() {
        scanner.close();
    }

    public Object readValue(String parameterType) {
        boolean notEntered = true;
        Object value = null;
        while (notEntered) {
            String valueType;
            PrintInstance.printSetValueForVariable();
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                valueType = value.getClass().getName();
            } else if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                valueType = value.getClass().getName();
            } else if (scanner.hasNextBoolean()) {
                value = scanner.nextBoolean();
                valueType = value.getClass().getName();
            } else {
                value = scanner.next();
                valueType = value.getClass().getName();
            }
            boolean flag = isComparableTypes(valueType, parameterType);
            if (flag) {
                PrintInstance.printTryOneMoreTime();
            }
            notEntered = flag;
        }
        return value;
    }

    private boolean isComparableTypes(String enteredValue, String parameterType) {
        return !enteredValue.toUpperCase().contains(parameterType.toUpperCase());
    }
}
