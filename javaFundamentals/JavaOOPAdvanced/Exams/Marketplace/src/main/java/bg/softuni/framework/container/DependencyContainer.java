package bg.softuni.framework.container;

import bg.softuni.framework.lifecycle.component.Inject;
import bg.softuni.framework.parser.Parser;
import bg.softuni.framework.parser.strategy.ComponentAnnotationParserStrategy;
import bg.softuni.provider.type.TypeProvider;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by RoYaL on 8/2/2016.
 */
public class DependencyContainer implements Container {

    private Parser parser;

    private TypeProvider provider;

    private Map<Class, Class> components;

    private Map<Class, Object> cachedComponents;

    private static final String INITIALIZE_METHOD = "initialize";

    public DependencyContainer(Parser parser, TypeProvider provider) throws InstantiationException,
            IllegalAccessException {
        this.parser = parser;
        this.components = new HashMap<>();
        this.cachedComponents = new HashMap<>();
        this.provider = provider;
        this.fillComponents();
    }

    public <T> T resolve(Class<T> from) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (!this.components.containsKey(from)) {
            throw new UnsupportedOperationException(
                    "Cannot map dependency of type "
                            + from.getName()
                            + ". It is not annotated with @Component " +
                            "or not registered in bg.Main.@ComponentScan"
            );
        }

        if (this.cachedComponents.containsKey(from)) {
            return (T)this.cachedComponents.get(from);
        }

        T result = (T)this.components.get(from).newInstance();

        this.resolveDependencies(result);

        this.invokeInitMethod(result);

        if (!this.cachedComponents.containsKey(from)) {
            this.cachedComponents.put(from, result);
            this.cachedComponents.put(result.getClass(), result);
        }

        return result;
    }

    public void resolveDependencies(Object object) throws IllegalAccessException, InstantiationException,
            InvocationTargetException {
        Field[] currentDependencies;
        currentDependencies = Arrays.stream(object
                .getClass()
                .getDeclaredFields())
                .filter(t -> t.isAnnotationPresent(Inject.class))
                .toArray(Field[]::new);

        for (Field dependency : currentDependencies) {
            dependency.setAccessible(true);
            Class currentDependencySource = dependency.getType();

            if (!this.components.containsKey(currentDependencySource)) {
                throw new UnsupportedOperationException(
                        "Cannot map dependency of type "
                                + currentDependencySource.getName()
                                + ". It is not annotated with @Component " +
                                "or not registered in bg.Main.@ComponentScan"
                );
            }

            Class currentDependencyTarget = this.components.get(currentDependencySource);
            Object currentDependencyInstance = null;
            if (this.cachedComponents.containsKey(currentDependencyTarget)) {
                currentDependencyInstance = this.cachedComponents.get(currentDependencyTarget);
                dependency.set(object, currentDependencyInstance);
            } else {
                currentDependencyInstance
                        = currentDependencyTarget.newInstance();

                dependency.set(object, currentDependencyInstance);

                this.cachedComponents.put(currentDependencyTarget, currentDependencyInstance);

                this.resolveDependencies(currentDependencyInstance);

                this.invokeInitMethod(currentDependencyInstance);
            }
        }
    }

    public void addDependency(Class from, Object to) {
        this.cachedComponents.put(to.getClass(), to);
        this.components.put(from, to.getClass());
    }


    private void fillComponents() throws IllegalAccessException, InstantiationException {
        this.parser.parse(
                new ComponentAnnotationParserStrategy(this.provider),
                this.components
        );
    }

    private void invokeInitMethod(Object result) throws IllegalAccessException, InvocationTargetException {
        Optional<Method> initMethod = Arrays.stream(result.getClass().getDeclaredMethods())
                .filter(m -> m.getName().equals(INITIALIZE_METHOD))
                .findFirst();

        if (initMethod.isPresent()) {
            Method method = initMethod.get();
            method.setAccessible(true);;
            method.invoke(result);
        }
    }
}
