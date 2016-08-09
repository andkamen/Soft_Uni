package bg.softuni.model.shop;

import bg.softuni.framework.lifecycle.order.Order;

/**
 * Created by RoYaL on 8/2/2016.
 */
@Order(1)
public class Mall extends ShopAbstract<Mall> {

    public Mall() {
        super(null, Long.MAX_VALUE);
    }
}
