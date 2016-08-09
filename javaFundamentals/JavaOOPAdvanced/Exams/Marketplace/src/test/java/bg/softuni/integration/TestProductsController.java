package bg.softuni.integration;

import bg.softuni.MarketApplication;
import bg.softuni.constants.Messages;
import bg.softuni.controller.ProductController;
import bg.softuni.model.product.BigProduct;
import bg.softuni.model.product.Product;
import bg.softuni.provider.data.DataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by RoYaL on 8/2/2016.
 */
public class TestProductsController {

    private ProductController controller;

    private DataProvider db;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        MarketApplication application = new MarketApplication();

        this.db = Mockito.mock(DataProvider.class);
        application.getContainer().addDependency(DataProvider.class, db);
        this.controller = application.getDispatcher().locate(ProductController.class);
    }

    @Test
    public void testEdit_nonExistentProduct_messageNoExists() {
        Mockito.when(db.editProduct(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString()))
                .thenReturn(null);

        String result = this.controller.edit(1, "sdfdfg", 23);

        Assert.assertEquals(
                String.format(Messages.PRODUCT_DOES_NOT_EXIST, 1),
                result
        );
    }

    @Test
    public void testEdit_predefinedProduct_messageEditedSuccessfull() {
        Product expected = new BigProduct(4, 69, "pesho");

        Mockito.when(db.editProduct(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString()))
                .thenReturn(expected);

        String result = this.controller.edit(4, "sdfdfg", 23);

        Assert.assertEquals(
                String.format(Messages.PRODUCT_EDITED_OK, 4),
                result
        );
    }

}
