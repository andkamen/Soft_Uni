package bg.softuni.controller;

import bg.softuni.constants.Messages;
import bg.softuni.framework.lifecycle.RequestMapping;
import bg.softuni.framework.lifecycle.component.Inject;
import bg.softuni.framework.lifecycle.controller.Controller;
import bg.softuni.framework.lifecycle.controller.UriParameter;
import bg.softuni.framework.lifecycle.request.RequestMethod;
import bg.softuni.model.product.Product;
import bg.softuni.model.shop.Shop;
import bg.softuni.provider.data.DataProvider;

/**
 * Created by RoYaL on 8/2/2016.
 */
@Controller
public class ShopController {

    @Inject
    private DataProvider db;

    @RequestMapping(value = "/shop/{type}/{productId}", method = RequestMethod.ADD)
    public String addProduct(@UriParameter("type") String type, @UriParameter("productId") int productId) {
        try {
            Shop shop = this.db.addProductToShop(type, productId);
            if (shop == null) {
                return String.format(
                        Messages.PRODUCT_DOES_NOT_EXIST,
                        productId
                );
            }

            return String.format(
                    Messages.PRODUCT_MOVED_OK,
                    productId,
                    shop.getClass().getSimpleName()
            );
        } catch (UnsupportedOperationException uoe) {
            return uoe.getMessage();
        }
    }

    @RequestMapping(value = "/shop/{type}", method = RequestMethod.GET)
    public String getProducts(@UriParameter("type") String type) {
        Iterable<Product> products = this.db.getShopProducts(type);

        StringBuilder sb = new StringBuilder();
        products.forEach(p -> sb.append(p.toString()).append("\r\n"));

        String result = sb.toString().trim();

        if (result.isEmpty()) {
            return Messages.PRODUCTS_CRTIERIA_NO;
        }

        return result;
    }



}
