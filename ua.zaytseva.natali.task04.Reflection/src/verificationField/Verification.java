package verificationField;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Natali on 21.11.2014.
 */
public class Verification {
    public boolean fieldVerification(String field, ArrayList<String> fieldList) throws ClassNotFoundException {
        for (String fieldName : fieldList) {
            if (fieldName.toUpperCase().equals(field.toUpperCase())) {
                return false;
            }
        }
        return true;
    }

    public String setterMethodNameForFiled(Class classForName, String field) throws ClassNotFoundException {
        Method[] methods = classForName.getDeclaredMethods();
        String methodName = null;
        for (Method method : methods) {
            methodName = method.getName();
            if (methodName.startsWith("set") && methodName.toUpperCase().endsWith(field.toUpperCase())) {
                return methodName;
            }
        }
        return methodName;
    }

    public boolean valueVerification(Class classForName, String value, String setterName) throws ClassNotFoundException {
        Class<? extends Object> wrapper = wrapperMethod(classForName, value, setterName);
        if (wrapper == null) {
            return true;
        } else {
            return false;
        }
    }

    public Class<? extends Object> wrapperMethod(Class classForName, String value, String setterName) throws ClassNotFoundException {
        Method[] method = classForName.getDeclaredMethods();
        for (Method m : method) {
            String methodName = m.getName();
            Class[] paramTypes = m.getParameterTypes();
            if (setterName.toUpperCase().contains(methodName.toUpperCase())) {
                for (int j = 0; j < paramTypes.length; j++) {
                    try {
                        if (paramTypes[j] == Integer.TYPE) {
                            Integer value1 = Integer.parseInt(value);
                            return value1.getClass();
                        } else if (paramTypes[j] == float.class) {
                            paramTypes[j] = Float.class;
                            Float value1 = Float.parseFloat(value);
                            return value1.getClass();
                        } else if (paramTypes[j] == long.class) {
                            paramTypes[j] = Long.class;
                            Long value1 = Long.parseLong(value);
                            return value1.getClass();
                        } else if (paramTypes[j] == double.class) {
                            paramTypes[j] = Double.class;
                            Double value1 = Double.parseDouble(value);
                            return value1.getClass();
                        } else if (paramTypes[j] == byte.class) {
                            paramTypes[j] = Byte.class;
                            Byte value1 = Byte.parseByte(value);
                            return value1.getClass();
                        } else if (paramTypes[j] == char.class) {
                            paramTypes[j] = Character.class;
                            Byte value1 = Byte.parseByte(value);
                            return value1.getClass();
                        } else if (paramTypes[j] == short.class) {
                            paramTypes[j] = Short.class;
                            Byte value1 = Byte.parseByte(value);
                            return value1.getClass();
                        } else if (paramTypes[j] == boolean.class) {
                            paramTypes[j] = Boolean.class;
                            Byte value1 = Byte.parseByte(value);
                            return value1.getClass();
                        } else if (paramTypes[j] == String.class) {
                            String value1 = value;
                            return value1.getClass();
                        }
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }
            }
        }
        return null;
    }
}