package wasteDisposal.models.garbage;

import wasteDisposal.Annotations.Burnable;

@Burnable
public class BurnableGarbage extends Garbage {

    public BurnableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
