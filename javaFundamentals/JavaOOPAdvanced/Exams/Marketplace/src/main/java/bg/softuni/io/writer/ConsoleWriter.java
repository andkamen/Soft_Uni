package bg.softuni.io.writer;

import bg.softuni.framework.lifecycle.component.Component;

/**
 * Created by RoYaL on 8/2/2016.
 */
@Component
public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
