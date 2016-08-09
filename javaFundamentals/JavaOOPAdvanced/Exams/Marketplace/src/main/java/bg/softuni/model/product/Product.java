package bg.softuni.model.product;

import bg.softuni.model.shop.Shop;

/**
 * Created by RoYaL on 8/2/2016.
 */
public interface Product {

    int getSize();

    String getName();

    Shop getShop();

    int getId();

    void setSize(int size);

    void setName(String name);

    void setShop(Shop shop);


}
