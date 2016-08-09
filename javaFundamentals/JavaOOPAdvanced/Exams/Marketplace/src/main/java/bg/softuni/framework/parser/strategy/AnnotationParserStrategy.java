package bg.softuni.framework.parser.strategy;

import java.util.Map;

/**
 * Created by RoYaL on 8/2/2016.
 */
public interface AnnotationParserStrategy<C, R> {

    void parse(Map<C, R> cachedResult) throws IllegalAccessException, InstantiationException;

}
