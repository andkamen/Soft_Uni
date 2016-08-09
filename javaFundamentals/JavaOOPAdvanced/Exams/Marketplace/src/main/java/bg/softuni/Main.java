package bg.softuni;

import bg.softuni.controller.ProductController;
import bg.softuni.controller.ShopController;
import bg.softuni.framework.container.Container;
import bg.softuni.framework.container.DependencyContainer;
import bg.softuni.framework.dispatch.ControllerDispatcher;
import bg.softuni.framework.dispatch.Dispatcher;
import bg.softuni.framework.lifecycle.*;
import bg.softuni.framework.parser.*;
import bg.softuni.io.reader.ConsoleReader;
import bg.softuni.io.reader.Reader;
import bg.softuni.io.writer.ConsoleWriter;
import bg.softuni.io.writer.Writer;
import bg.softuni.model.shop.Bazaar;
import bg.softuni.model.shop.Mall;
import bg.softuni.model.shop.Shop;
import bg.softuni.model.shop.Store;
import bg.softuni.provider.data.DataProvider;
import bg.softuni.provider.data.ShopDatabase;
import bg.softuni.provider.type.ClassProvider;
import bg.softuni.provider.type.TypeProvider;

@ComponentScan(classes = {
        Main.class,
        ProductController.class,
        DataProvider.class,
        ShopDatabase.class,
        Dispatcher.class,
        ControllerDispatcher.class,
        EventLoop.class,
        MainEventLoop.class,
        Reader.class,
        ConsoleReader.class,
        Writer.class,
        ConsoleWriter.class,
        ShopController.class,
        Shop.class,
        Mall.class,
        Bazaar.class,
        Store.class
})
public class Main {

    public static void main(String args[]) throws Exception {
        TypeProvider provider = new ClassProvider(Main.class.getAnnotation(ComponentScan.class).classes());
        Parser parser = new AnnotationParser();
        Container container = new DependencyContainer(parser, provider);
        container.addDependency(TypeProvider.class, provider);
        container.addDependency(Parser.class, parser);
        container.addDependency(Container.class, container);

        MarketApplication application = new MarketApplication(provider, parser, container);

        application.run();
    }

}
