package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Natali on 27.11.2014.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultField {
    String name();
}
