package annotationAnalizer;

import annotation.DefaultField;
import annotation.Marker;
import initializeValue.InitializeValueToSetMethod;
import printInstance.PrintInstance;
import scanner.ScanValueFromConsole;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Natali on 28.11.2014.
 */
public class AnnotationAnalyzer {

    public void annotationAnalyzer(Object object) throws IllegalAccessException, InstantiationException {
        ScanValueFromConsole valueFromConsole = new ScanValueFromConsole();
        valueFromConsole.startScanner();
        Class analyzerClass = object.getClass();
        Field[] fields = analyzerClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Marker.class)) {
                findSetMethodForField(field.getName(), analyzerClass, object, valueFromConsole);
            } else if (field.isAnnotationPresent(DefaultField.class)) {
                PrintInstance.printDefaultField(field);
            }
        }
        valueFromConsole.close();
        PrintInstance.printInstance(object);
    }


    private void findSetMethodForField(String name, Class analyzerClass, Object instance, ScanValueFromConsole valueFromConsole) {
        Method[] methods = analyzerClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set") && method.getName().toUpperCase().endsWith(name.toUpperCase())) {
                PrintInstance.printVariable(name);
                Class[] parameters = method.getParameterTypes();
                if (parameters.length >= 2) {
                    PrintInstance.printNoCorrectSetMethod(name);
                } else {
                    Class parameter = parameters[0];
                    String parameterType = parameter.getName();
                    PrintInstance.printParameterType(parameterType);
                    Object value = valueFromConsole.readValue(parameterType);
                    InitializeValueToSetMethod.initialize(instance, method, value);
                }
            }
        }
    }
}
