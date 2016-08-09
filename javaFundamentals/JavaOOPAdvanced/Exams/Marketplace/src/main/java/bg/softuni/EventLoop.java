package bg.softuni;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by RoYaL on 8/2/2016.
 */
public interface EventLoop {

    void run() throws IOException, InvocationTargetException, IllegalAccessException;

}
