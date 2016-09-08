package wasteDisposal.models.garbage;

import wasteDisposal.Annotations.Recyclable;

@Recyclable
public class RecyclableGarbage extends Garbage {

    public RecyclableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
