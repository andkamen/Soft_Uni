package bg.softuni.provider.type;

/**
 * Created by RoYaL on 8/2/2016.
 */
public interface TypeProvider {

    Class[] getClassesByAnnotation(Class annotation);

}
