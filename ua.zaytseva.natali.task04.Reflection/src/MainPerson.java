import initialization.InitializeField;
import print.Print;
import read.ReadAndFindSetterMethodsForFields;
import read.ReadFromConsole;

import java.util.ArrayList;

/**
 * Created by Natali on 21.11.2014.
 */
public class MainPerson {
    public static void main(String[] args) {
        ReadFromConsole readFromConsole = new ReadFromConsole();
        String name = readFromConsole.readClassNameFromConsole();
        try {
            Class classForName = Class.forName(name);
            Object newInstance = classForName.newInstance();
            Print print = new Print();
            print.printName(classForName);
            ReadAndFindSetterMethodsForFields setterMethodsForFields = new ReadAndFindSetterMethodsForFields();
            ArrayList<String> setterList = setterMethodsForFields.findSettersForFields(classForName);
            ArrayList<String> fieldList = setterMethodsForFields.fieldList(classForName);
            print.printSetterMethodsForFields(setterList);
            boolean oneMore = true;
            while (oneMore) {
                String setterMethodName = readFromConsole.readParameter(fieldList, classForName);
                String value = readFromConsole.readValue(classForName);

                InitializeField initializeField = new InitializeField();
                newInstance = initializeField.initializeField(newInstance, classForName, setterMethodName, value);
                boolean oneMoreMethod = readFromConsole.oneMore();
                oneMore = oneMoreMethod;

            }
            print.printClassForNameFields(newInstance);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
