package print;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by Natali on 21.11.2014.
 */
public class Print {
    public void printName(Class classForPrint) {
        String modifiers = Modifier.toString(classForPrint.getModifiers());
        if (modifiers.length() > 0) {
            System.out.print(modifiers + " ");
        }
        System.out.println(classForPrint);
    }

    public void printSetterMethodsForFields(ArrayList<String> setterList) {
        System.out.println("This class has set-methods: ");
        for (String setterMethod : setterList) {
            System.out.println(setterMethod);

        }
    }

    public void printClassForNameFields(Object objectForPrint) {

        System.out.println(objectForPrint);
    }
}
