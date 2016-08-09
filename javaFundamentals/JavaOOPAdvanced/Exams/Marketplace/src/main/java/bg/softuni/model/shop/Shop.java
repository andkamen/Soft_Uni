package bg.softuni.model.shop;

import bg.softuni.model.product.Product;

/**
 * Created by RoYaL on 8/2/2016.
 */
public interface Shop<S> {

    Iterable<Product> getProducts();

    Shop addProduct(Product product);

}
