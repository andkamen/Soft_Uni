package bg.softuni.provider.type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RoYaL on 8/2/2016.
 */
public class ClassProvider implements TypeProvider {

    private Class[] classes;

    private Map<Class, Class[]> classesByAnnotation;

    public ClassProvider(Class[] classes) {
        this.classes = classes;
        this.classesByAnnotation = new HashMap<>();
    }

    @Override
    public Class[] getClassesByAnnotation(Class annotation) {
        if (this.classesByAnnotation.containsKey(annotation)) {
            return this.classesByAnnotation.get(annotation);
        }

        Class[] result = Arrays.stream(this.classes)
                .filter(c -> c.isAnnotationPresent(annotation))
                .toArray(Class[]::new);

        this.classesByAnnotation.put(annotation, result);

        return result;
    }
}
