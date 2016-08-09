package bg.softuni;

import bg.softuni.framework.dispatch.Dispatcher;
import bg.softuni.framework.lifecycle.component.Component;
import bg.softuni.framework.lifecycle.component.Inject;
import bg.softuni.framework.lifecycle.request.RequestMethod;
import bg.softuni.io.reader.Reader;
import bg.softuni.io.writer.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by RoYaL on 8/2/2016.
 */
@Component
public class MainEventLoop implements EventLoop {

    @Inject
    private Reader reader;

    @Inject
    private Writer writer;

    @Inject
    private Dispatcher dispatcher;


    private static final String END_LINE = "ILIENCI";

    @Override
    public void run() throws IOException, InvocationTargetException, IllegalAccessException {

        String line = this.reader.readLine();

        while (!line.equals(END_LINE)) {
            String[] tokens = line.split(" ");
            RequestMethod requestMethod = RequestMethod.valueOf(tokens[0]);
            String uri = tokens[1];

            this.writer.writeLine(this.dispatcher.dispatch(requestMethod, uri));

            line = this.reader.readLine();
        }
    }
}
