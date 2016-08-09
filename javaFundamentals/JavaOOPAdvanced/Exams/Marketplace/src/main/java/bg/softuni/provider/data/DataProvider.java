package bg.softuni.provider.data;

import bg.softuni.model.product.Product;
import bg.softuni.model.shop.Shop;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by RoYaL on 8/2/2016.
 */
public interface DataProvider {

    Product addProduct(int size, String name, String type) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException;

    Product getProductById(int id);

    Iterable<Product> getProductBySizeName(int size, String name);

    Iterable<Product> getProductBySizeNameType(int size, String name, String type);

    Product editProduct(int id, int newSize, String newName);

    Iterable<Product> getShopProducts(String shopType);

    Shop addProductToShop(String shopType, int productId);

}
