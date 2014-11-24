package read;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Natali on 21.11.2014.
 */
public class ReadAndFindSetterMethodsForFields {
    public ArrayList<String> findSettersForFields(Class className) {
        ArrayList<String> setterList = new ArrayList<>();
        Field[] fields = className.getDeclaredFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            String fieldName = field.getName();
            Method[] methods = className.getDeclaredMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                Class[] paramTypes = method.getParameterTypes();

                for (int j = 0; j < paramTypes.length; j++) {
                    if (methodName.startsWith("set") && methodName.toUpperCase().endsWith(fieldName.toUpperCase())) {
                        StringBuilder parameterString = new StringBuilder();
                        if (fieldType.equals(paramTypes[j])) {
                            parameterString.append(paramTypes[j]);
                            setterList.add(methodName + " (" + parameterString + " " + fieldName + ");");
                        }
                    }
                }
            }
        }
        return setterList;
    }

    public ArrayList<String> fieldList(Class className) {
        ArrayList<String> fieldList = new ArrayList<>();
        Field[] fields = className.getDeclaredFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            String fieldName = field.getName();
            Method[] methods = className.getDeclaredMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                Class[] paramTypes = method.getParameterTypes();
                StringBuilder parameterString = new StringBuilder();

                for (int j = 0; j < paramTypes.length; j++) {
                    if (methodName.startsWith("set") && methodName.toUpperCase().endsWith(fieldName.toUpperCase())) {
                        if (fieldType.equals(paramTypes[j])) {
                            parameterString.append(paramTypes[j]);
                            fieldList.add(fieldName);
                        }
                    }
                }
            }
        }
        return fieldList;
    }
}
