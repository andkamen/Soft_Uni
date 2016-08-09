package bg.softuni;

import bg.softuni.framework.container.Container;
import bg.softuni.framework.container.DependencyContainer;
import bg.softuni.framework.dispatch.Dispatcher;
import bg.softuni.framework.lifecycle.ComponentScan;
import bg.softuni.framework.parser.AnnotationParser;
import bg.softuni.framework.parser.Parser;
import bg.softuni.provider.type.ClassProvider;
import bg.softuni.provider.type.TypeProvider;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * This class allows to run the application from anywhere
 * also provides default values for each of the significant
 * framework object such as TypeProvider, Parser amd Container
 * @see TypeProvider
 * @see Parser
 * @see Container
 *
 * If you want to write unit tests you may instantiate
 * the application and use the container in order to
 * inject dependencies to the framework-managed objects
 * such as controllers
 * @see bg.softuni.framework.lifecycle.controller.Controller
 *
 * @author RoYaL
 */
public class MarketApplication {

    private TypeProvider typeProvider;

    private Parser parser;

    private Container container;

    private Dispatcher dispatcher;

    private EventLoop eventLoop;

    public MarketApplication() throws IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {
        this.typeProvider = new ClassProvider(Main.class.getAnnotation(ComponentScan.class).classes());
        this.parser = new AnnotationParser();
        this.container = new DependencyContainer(parser, typeProvider);
        container.addDependency(TypeProvider.class, typeProvider);
        container.addDependency(Parser.class, parser);
        container.addDependency(Container.class, container);
        this.dispatcher = container.resolve(Dispatcher.class);
        this.eventLoop = container.resolve(EventLoop.class);
    }

    public MarketApplication(Class[] classes) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        this.typeProvider = new ClassProvider(classes);
        this.parser = new AnnotationParser();
        this.container = new DependencyContainer(parser, typeProvider);
        container.addDependency(TypeProvider.class, typeProvider);
        container.addDependency(Parser.class, parser);
        container.addDependency(Container.class, container);
        this.dispatcher = container.resolve(Dispatcher.class);
        this.eventLoop = container.resolve(EventLoop.class);
    }

    public MarketApplication(TypeProvider typeProvider, Parser parser, Container container) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.typeProvider = typeProvider;
        this.parser = parser;
        this.container = container;
        container.addDependency(TypeProvider.class, typeProvider);
        container.addDependency(Parser.class, parser);
        container.addDependency(Container.class, container);
        this.dispatcher = container.resolve(Dispatcher.class);
        this.eventLoop = container.resolve(EventLoop.class);
    }

    public MarketApplication(TypeProvider typeProvider, Parser parser, Container container, Dispatcher dispatcher) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.typeProvider = typeProvider;
        this.parser = parser;
        this.container = container;
        this.dispatcher = dispatcher;
        this.eventLoop = container.resolve(EventLoop.class);
    }

    public MarketApplication(TypeProvider typeProvider, Parser parser, Container container, Dispatcher dispatcher,
                              EventLoop eventLoop) {
        this.typeProvider = typeProvider;
        this.parser = parser;
        this.container = container;
        this.dispatcher = dispatcher;
        this.eventLoop = eventLoop;
    }

    public TypeProvider getTypeProvider() {
        return typeProvider;
    }

    public void setTypeProvider(TypeProvider typeProvider) {
        this.typeProvider = typeProvider;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public EventLoop getEventLoop() {
        return eventLoop;
    }

    public void setEventLoop(EventLoop eventLoop) {
        this.eventLoop = eventLoop;
    }

    public void run() throws IllegalAccessException, IOException, InvocationTargetException {
        this.eventLoop.run();
    }
}
