package bg.softuni.provider.data;

import bg.softuni.constants.Messages;
import bg.softuni.framework.lifecycle.component.Component;
import bg.softuni.framework.lifecycle.component.Inject;
import bg.softuni.framework.lifecycle.order.Order;
import bg.softuni.model.product.Product;
import bg.softuni.model.shop.Mall;
import bg.softuni.model.shop.Shop;
import bg.softuni.provider.type.TypeProvider;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by RoYaL on 8/2/2016.
 */
@Component
public class ShopDatabase implements DataProvider {

    private Map<Integer, Product> productsById;
    private Map<Integer, Map<String, Set<Product>>> productsBySizeName;
    private Map<Integer, Map<String, Map<Class, Set<Product>>>> productsBySizeNameType;

    private Map<String, Shop> shops;

    @Inject
    private TypeProvider provider;

    public ShopDatabase() {
        this.productsById = new LinkedHashMap<>();
        this.productsBySizeName = new LinkedHashMap<>();
        this.productsBySizeNameType = new LinkedHashMap<>();
        this.shops = new HashMap<>();
    }

    /**
     * In case you do want to instantiate the db by yourself
     * and provide shops from the outside.
     * Otherwise the ShopDatabase.initialize() method will pre-fill them
     *
     * @see ShopDatabase#initialize()
     * @param shops
     */
    public ShopDatabase(Map<String, Shop> shops) {
        this();
        this.shops = shops;
    }

    @Override
    public Product addProduct(int size, String name, String type) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int id = this.productsById.size() + 1;
        Product product = (Product)this.getClassByAbstractType(Product.class, type)
                .getConstructors()[0]
                .newInstance(id, size, name);

        this.productsById.put(
                product.getId(),
                product
        );

        this.addToNestedStructures(product);

        return product;
    }

    @Override
    public Product getProductById(int id) {
        return this.productsById.getOrDefault(id, null);
    }

    @Override
    public Iterable<Product> getProductBySizeName(int size, String name) {
        try {
            return this.productsBySizeName.get(size).get(name);
        } catch (NullPointerException npe) {
            return null;
        }
    }

    @Override
    public Iterable<Product> getProductBySizeNameType(int size, String name, String type) {
        try {
            return this.productsBySizeNameType.get(size).get(name).get(this.getClassByAbstractType(Product.class, type));
        } catch (NullPointerException npe) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public Product editProduct(int id, int newSize, String newName) {
        Product product = this.getProductById(id);
        if (product == null) {
            return null;
        }

        this.removeOldData(product);

        product.setSize(newSize);
        product.setName(newName);

        this.addToNestedStructures(product);

        return product;
    }

    private void removeOldData(Product product) {
        this.productsBySizeName.get(product.getSize()).get(product.getName()).remove(product);
        this.productsBySizeNameType.get(product.getSize()).get(product.getName()).get(product.getClass()).remove(product);
    }

    public Shop addProductToShop(String shopType, int productId) {
        Product product = this.getProductById(productId);
        if (product == null) {
            return null;
        }

        Shop shop = this.shops.get(shopType);

        if (product.getShop() != null) {
            throw new UnsupportedOperationException(
                    String.format(
                            Messages.PRODUCT_BELONGS_TO_SHOP,
                            productId,
                            product.getShop().getClass().getSimpleName()
                    )
            );
        }

        product.setShop(shop);

        return shop.addProduct(product);
    }

    public Iterable<Product> getShopProducts(String shopType) {
        Shop shop = this.shops.get(shopType);

        return shop.getProducts();
    }

    private Class getClassByAbstractType(Class abstractType, String toType) throws ClassNotFoundException {
        String fullQualifiedName = abstractType.getName();
        String simpleName = abstractType.getSimpleName();
        String resultName =
                fullQualifiedName.replace("." + simpleName, "." + toType);

        return Class.forName(resultName);
    }

    private void addToNestedStructures(Product product) {
        this.productsBySizeName.putIfAbsent(product.getSize(), new LinkedHashMap<>());
        this.productsBySizeNameType.putIfAbsent(product.getSize(), new LinkedHashMap<>());

        this.productsBySizeName.get(product.getSize())
                .putIfAbsent(product.getName(), new LinkedHashSet<>());
        this.productsBySizeNameType.get(product.getSize())
                .putIfAbsent(product.getName(), new LinkedHashMap<>());

        this.productsBySizeNameType.get(product.getSize()).get(product.getName())
                .putIfAbsent(product.getClass(), new LinkedHashSet<>());

        this.productsBySizeNameType.get(product.getSize()).get(product.getName())
                .get(product.getClass()).add(product);

        this.productsBySizeName.get(product.getSize()).get(product.getName())
                .add(product);
    }

    private void initialize() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * Take all classes with @Order annotation
         * (Mall, Bazaar, Store has respectively:
         *      @Order(1)
         *      @Order(2)
         *      @Order(3)
         */
        Class[] shopClasses
                = this.provider.getClassesByAnnotation(Order.class);

        /**
         * Filter all classes by @Order annotation
         * to these that are subclasses of Shop interface
         * @see Shop
         *
         * Then sort them by the value of @Order
         * in ascending order
         * @see Order#value()
         * @see Mall
         */
        shopClasses = Arrays.stream(shopClasses)
                .filter(Shop.class::isAssignableFrom)
                .sorted((c1, c2) -> {
                    long orderLeft = ((Order)c1.getAnnotation(Order.class)).value();
                    long orderRight = ((Order)c2.getAnnotation(Order.class)).value();

                    return Long.compare(orderLeft, orderRight);
                })
                .toArray(Class[]::new);


        Shop successor = null;
        for (Class shopClass : shopClasses) {
            Constructor constructor = shopClass.getConstructors()[0];
            int paramSize = constructor.getParameterCount();
            /**
             * If the constructor is parameterless,
             * instantiate it with no arguments.
             * Otherwise instantiate it with the successor
             * instance from the last iteration
             */
            Shop currentShop = paramSize > 0 ? (Shop)constructor.newInstance(successor) : (Shop)constructor.newInstance();

            this.shops.put(shopClass.getSimpleName(), currentShop);
            successor = currentShop;
        }
    }
}
