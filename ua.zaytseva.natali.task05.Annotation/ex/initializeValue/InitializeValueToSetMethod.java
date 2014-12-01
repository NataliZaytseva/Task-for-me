package initializeValue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Natali on 28.11.2014.
 */
public class InitializeValueToSetMethod {

    public static void initialize(Object newInstance, Method method, Object value) {
        try {
            method.invoke(newInstance, value);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
