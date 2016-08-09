package bg.softuni.controller;

import bg.softuni.constants.Messages;
import bg.softuni.framework.lifecycle.RequestMapping;
import bg.softuni.framework.lifecycle.component.Component;
import bg.softuni.framework.lifecycle.component.Inject;
import bg.softuni.framework.lifecycle.controller.Controller;
import bg.softuni.framework.lifecycle.controller.UriParameter;
import bg.softuni.framework.lifecycle.request.RequestMethod;
import bg.softuni.model.product.Product;
import bg.softuni.provider.data.DataProvider;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by RoYaL on 8/2/2016.
 */
@Controller
@Component
public class ProductController {

    @Inject
    private DataProvider db;

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getById(@UriParameter("id") int id) {
        Product product = this.db.getProductById(id);
        if (product == null) {
            return String.format(
                    Messages.PRODUCT_DOES_NOT_EXIST,
                    id
            );
        }

        return product.toString();
    }

    @RequestMapping(value = "/product/{size}/{name}/{type}", method = RequestMethod.ADD)
    public String addProduct(@UriParameter("size") int size, @UriParameter("name") String name, @UriParameter("type") String type) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Product addedProduct = this.db.addProduct(size, name, type);

        return String.format(
                Messages.PRODUCT_REGISTERED_OK,
                addedProduct.getId()
        );
    }

    @RequestMapping(value = "/product/{size}/{name}/{type}", method = RequestMethod.GET)
    public String getBySizeNameType(@UriParameter("size") int size, @UriParameter("name") String name, @UriParameter("type") String type) {
        Iterable<Product> result = this.db.getProductBySizeNameType(size, name, type);
        return getProductsResult(result);
    }

    @RequestMapping(value = "/product/{id}/{newName}/{newSize}", method = RequestMethod.EDIT)
    public String edit(@UriParameter("id") int id, @UriParameter("newName") String newName, @UriParameter("newSize") int newSize) {
        Product product = this.db.editProduct(id, newSize, newName);
        if (product == null) {
            return String.format(
                    Messages.PRODUCT_DOES_NOT_EXIST,
                    id
            );
        }

        return String.format(
                Messages.PRODUCT_EDITED_OK,
                id
        );
    }


    @RequestMapping(value = "/product/{size}/{name}", method = RequestMethod.GET)
    public String getBySizeName(@UriParameter("size") int size, @UriParameter("name") String name) {
        Iterable<Product> result = this.db.getProductBySizeName(size, name);
        return getProductsResult(result);
    }


    private String getProductsResult(Iterable<Product> result) {
        if (result == null) {
            return Messages.PRODUCTS_CRTIERIA_NO;
        }

        StringBuilder sb = new StringBuilder();
        result.forEach(p -> sb.append(p.toString()).append("\r\n"));

        return sb.toString().trim();
    }

}
