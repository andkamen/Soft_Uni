package bg.softuni.model.shop;

import bg.softuni.framework.lifecycle.order.Order;

/**
 * Created by RoYaL on 8/2/2016.
 */
@Order(3)
public class Store extends ShopAbstract<Bazaar> {

    private static final long MAX_CAPACITY = 15;

    public Store(Bazaar successor) {
        super(successor, MAX_CAPACITY);
    }
}
