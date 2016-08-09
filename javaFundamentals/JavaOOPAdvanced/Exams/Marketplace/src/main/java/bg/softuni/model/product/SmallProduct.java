package bg.softuni.model.product;

/**
 * Created by RoYaL on 8/2/2016.
 */
public class SmallProduct extends ProductAbstract {

    private static final double SIZE_MODIFIER = 0.5;

    public SmallProduct(int id, int size, String name) {
        super(id, size, name);
    }

    public void setSize(int size) {
        super.setSize((int)(size * SIZE_MODIFIER));
    }
}
