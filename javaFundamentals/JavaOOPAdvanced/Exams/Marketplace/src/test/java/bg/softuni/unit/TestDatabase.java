package bg.softuni.unit;

import bg.softuni.model.product.Product;
import bg.softuni.provider.data.DataProvider;
import bg.softuni.provider.data.ShopDatabase;
import bg.softuni.util.DatabaseUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by RoYaL on 8/2/2016.
 */
public class TestDatabase {

    private DataProvider db;

    @Before
    public void setUp() {
        this.db = new ShopDatabase(DatabaseUtils.createPredefinedShops());
    }

    @Test
    public void testEditProduct_validSize_sizeEditedSuccessfully() throws ClassNotFoundException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Product product = this.db.addProduct(69, "pesho", "BigProduct");

        Product newProduct = this.db.editProduct(1, 42, "pesho");

        Assert.assertEquals(84, newProduct.getSize());
    }

    @Test
    public void testEditProduct_validName_nameEditedSuccessfully() throws ClassNotFoundException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Product product = this.db.addProduct(69, "pesho", "BigProduct");

        Product newProduct = this.db.editProduct(1, 69, "gosho");

        Assert.assertEquals("gosho", newProduct.getName());
    }


    @Test
    public void testEditProduct_validData_referencesEquals() throws ClassNotFoundException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Product product = this.db.addProduct(69, "pesho", "BigProduct");

        Product newProduct = this.db.editProduct(1, 69, "gosho");

        Assert.assertEquals("References of edited and input product should be the same, and not recreated", product, newProduct);
    }

    @Test
    public void testEditProduct_validData_idNotChanged() throws ClassNotFoundException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Product product = this.db.addProduct(69, "pesho", "BigProduct");

        Product newProduct = this.db.editProduct(1, 69, "gosho");

        Assert.assertEquals("Id should be the same and not changed", 1, newProduct.getId());
    }

    @Test
    public void testEditProduct_nonExistentProduct_shouldReturnNull() throws ClassNotFoundException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Product newProduct = this.db.editProduct(1, 69, "gosho");

        Assert.assertNull("The product should not exist", newProduct);
    }




}
