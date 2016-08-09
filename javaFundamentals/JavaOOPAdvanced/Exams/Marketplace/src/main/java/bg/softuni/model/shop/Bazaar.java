package bg.softuni.model.shop;

import bg.softuni.framework.lifecycle.order.Order;

/**
 * Created by RoYaL on 8/2/2016.
 */
@Order(2)
public class Bazaar extends ShopAbstract<Mall> {

    private static final long MAX_CAPACITY = 30;

    public Bazaar(Mall successor) {
        super(successor, MAX_CAPACITY);
    }
}
