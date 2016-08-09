package bg.softuni.util;

import bg.softuni.model.shop.Bazaar;
import bg.softuni.model.shop.Mall;
import bg.softuni.model.shop.Shop;
import bg.softuni.model.shop.Store;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RoYaL on 8/3/2016.
 */
public class DatabaseUtils {

    public static Map<String, Shop> createPredefinedShops() {
        HashMap<String, Shop> shops = new HashMap<>();
        Mall mall = new Mall();
        Bazaar bazaar = new Bazaar(mall);
        Store store = new Store(bazaar);
        shops.put(mall.getClass().getSimpleName(), mall);
        shops.put(bazaar.getClass().getSimpleName(), bazaar);
        shops.put(store.getClass().getSimpleName(), store);

        return shops;
    }

}
