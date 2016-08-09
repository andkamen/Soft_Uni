package bg.softuni.framework.container;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by RoYaL on 8/2/2016.
 */
public interface Container {

    <T> T resolve(Class<T> typeToResolve) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;

    void resolveDependencies(Object object) throws IllegalAccessException, InstantiationException,
            InvocationTargetException;

    void addDependency(Class from, Object to);

}
