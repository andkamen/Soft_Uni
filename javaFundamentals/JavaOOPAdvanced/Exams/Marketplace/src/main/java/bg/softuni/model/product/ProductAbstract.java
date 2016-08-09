package bg.softuni.model.product;

import bg.softuni.constants.Messages;
import bg.softuni.model.shop.Shop;

/**
 * Created by RoYaL on 8/2/2016.
 */
public abstract class ProductAbstract implements Product {

    private int id;
    private int size;
    private String name;
    private Shop shop;

    public ProductAbstract(int id, int size, String name) {
        this.setId(id);
        this.setSize(size);
        this.setName(name);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Shop getShop() {
        return this.shop;
    }

    @Override
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int getId() {
        return this.id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                Messages.PRODUCT_TO_STRING,
                this.getClass().getSimpleName(),
                this.getId(),
                this.getSize(),
                this.getName()
        );
    }
}
