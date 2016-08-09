package bg.softuni.model.shop;

import bg.softuni.model.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RoYaL on 8/2/2016.
 */
public abstract class ShopAbstract<S extends Shop> implements Shop<S> {

    private List<Product> products;

    protected S successor;
    protected long filledCapacity;
    protected long capacity;

    public ShopAbstract(S successor, long capacity) {
        this.successor = successor;
        this.capacity = capacity;
        this.products = new ArrayList<>();
    }

    public Shop addProduct(Product product) {
        if (product.getSize() + this.filledCapacity > this.capacity
                && this.successor != null) {
            return this.successor.addProduct(product);
        }

        this.products.add(product);
        this.filledCapacity += product.getSize();

        return this;
    }

    public Iterable<Product> getProducts() {
        return this.products;
    }

}
