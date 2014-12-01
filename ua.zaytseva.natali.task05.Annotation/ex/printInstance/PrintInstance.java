package printInstance;

import annotation.DefaultField;

import java.lang.reflect.Field;

/**
 * Created by Natali on 28.11.2014.
 */
public class PrintInstance {

    public static void printInstance(Object instance) {
        System.out.println(instance);
    }

    public static void printVariable(String name) {
        System.out.println("You can set value for variable -" + name);
    }

    public static void printParameterType(String parameterType) {
        System.out.println("With type " + parameterType);
    }

    public static void printSetValueForVariable() {
        System.out.println("Enter please a value ");
    }

    public static void printTryOneMoreTime() {
        System.out.println("Type mismatch. Try again. ");
    }

    public static void printDefaultField(Field field) {
        System.out.println(field.getName() + " = " + field.getAnnotation(DefaultField.class).name());
    }

    public static void printNoCorrectSetMethod(String name) {
        System.out.println("Sorry, we do not have correct method for field " + name);
        System.out.println("Try to find another method for variable.");
    }
}
