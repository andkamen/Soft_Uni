package bg.softuni.model.product;

/**
 * Created by RoYaL on 8/2/2016.
 */
public class BigProduct extends ProductAbstract {

    private static final double SIZE_MODIFIER = 2;

    public BigProduct(int id, int size, String name) {
        super(id, size, name);
    }

    public void setSize(int size) {
        super.setSize((int)(size * SIZE_MODIFIER));
    }
}
