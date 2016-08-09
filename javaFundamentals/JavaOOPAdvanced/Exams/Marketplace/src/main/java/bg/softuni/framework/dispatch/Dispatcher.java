package bg.softuni.framework.dispatch;

import bg.softuni.framework.lifecycle.request.RequestMethod;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by RoYaL on 8/2/2016.
 */
public interface Dispatcher {

    String dispatch(RequestMethod requestMethod, String uri) throws InvocationTargetException, IllegalAccessException;

    <T> T locate(Class<T> locator) throws IllegalAccessException, InvocationTargetException, InstantiationException;

}
