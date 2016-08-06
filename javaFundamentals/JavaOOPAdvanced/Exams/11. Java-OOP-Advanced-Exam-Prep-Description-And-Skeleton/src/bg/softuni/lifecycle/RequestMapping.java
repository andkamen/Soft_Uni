package bg.softuni.lifecycle;

import bg.softuni.lifecycle.request.RequestMethod;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    String value();

    RequestMethod method() default RequestMethod.ADD;
}
