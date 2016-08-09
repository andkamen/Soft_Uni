package bg.softuni.io.reader;

import bg.softuni.framework.lifecycle.component.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by RoYaL on 8/2/2016.
 */
@Component
public class ConsoleReader implements Reader {

    private BufferedReader bufferedReader;

    public ConsoleReader() {
        this.bufferedReader = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
    }

    @Override
    public String readLine() throws IOException {
        return this.bufferedReader.readLine();
    }
}
