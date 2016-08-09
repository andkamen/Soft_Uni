package bg.softuni.integration;

import bg.softuni.model.product.Product;
import bg.softuni.model.shop.Mall;
import bg.softuni.model.shop.Shop;
import bg.softuni.provider.data.DataProvider;
import bg.softuni.provider.data.ShopDatabase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import bg.softuni.util.DatabaseUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Set;

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
    public void testEditProduct_validData_shouldRemoveFromSizeNameType() throws ClassNotFoundException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Product product = this.db.addProduct(69, "pesho", "BigProduct");

        this.db.editProduct(1, 42, "pesho");
        Set<Product> result
                = new LinkedHashSet<Product>();

        this.db.getProductBySizeNameType(138, "pesho", "BigProduct").forEach(result::add);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testEditProduct_validData_shouldBeInNewAssociations() throws ClassNotFoundException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Product product = this.db.addProduct(69, "pesho", "BigProduct");

        this.db.editProduct(1, 42, "gosho");

        Assert.assertNotNull(this.db.getProductBySizeNameType(84, "gosho", "BigProduct"));
    }

    @Test
    public void testEditMovedProduct_validData_shopShouldNotBeChanged() throws ClassNotFoundException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Product product = this.db.addProduct(69, "pesho", "BigProduct");
        Shop productShop = new Mall();
        product.setShop(productShop);

        Product newProduct = this.db.editProduct(1, 42, "gosho");

        Assert.assertEquals(productShop, newProduct.getShop());
    }

}
