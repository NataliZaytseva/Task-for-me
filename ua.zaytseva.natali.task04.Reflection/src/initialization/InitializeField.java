package initialization;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Natali on 21.11.2014.
 */
public class InitializeField {
    public Object initializeField(Object newInstance, Class classForName, String setterMethodName, String value) throws IllegalAccessException, NoSuchMethodException {

        Method[] method = classForName.getDeclaredMethods();
        for (Method m : method) {
            String methodName = m.getName();
            Class[] paramTypes = m.getParameterTypes();
            if (setterMethodName.toUpperCase().contains(methodName.toUpperCase())) {
                for (int j = 0; j < paramTypes.length; j++) {
                    try {
                        if (paramTypes[j] == Integer.TYPE) {
                            Integer value1 = Integer.parseInt(value);
                            m.invoke(newInstance, value1);
                        } else if (paramTypes[j] == float.class) {
                            paramTypes[j] = Float.class;
                            Float value1 = Float.parseFloat(value);
                            m.invoke(newInstance, value1);
                        } else if (paramTypes[j] == long.class) {
                            paramTypes[j] = Long.class;
                            Long value1 = Long.parseLong(value);
                            m.invoke(newInstance, value1);
                        } else if (paramTypes[j] == double.class) {
                            paramTypes[j] = Double.class;
                            Double value1 = Double.parseDouble(value);
                            m.invoke(newInstance, value1);
                        } else if (paramTypes[j] == byte.class) {
                            paramTypes[j] = Byte.class;
                            Byte value1 = Byte.parseByte(value);
                            m.invoke(newInstance, value1);
                        } else if (paramTypes[j] == char.class) {
                            paramTypes[j] = Character.class;
                            Byte value1 = Byte.parseByte(value);
                            m.invoke(newInstance, value1);
                        } else if (paramTypes[j] == short.class) {
                            paramTypes[j] = Short.class;
                            Byte value1 = Byte.parseByte(value);
                            m.invoke(newInstance, value1);
                        } else if (paramTypes[j] == boolean.class) {
                            paramTypes[j] = Boolean.class;
                            Byte value1 = Byte.parseByte(value);
                            m.invoke(newInstance, value1);
                        } else if (paramTypes[j] == String.class) {
                            String value1 = value;
                            m.invoke(newInstance, value1);
                        }
                    } catch (NumberFormatException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return newInstance;
    }
}
