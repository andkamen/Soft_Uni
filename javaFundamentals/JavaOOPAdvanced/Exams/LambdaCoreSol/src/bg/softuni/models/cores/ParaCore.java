package bg.softuni.models.cores;

import bg.softuni.utilities.Constants;

public class ParaCore extends BaseCore{
    public ParaCore(String name, Integer durability) {
        super(name, durability);
    }

    @Override
    public void setDurability(Integer value) {
        super.setDurability(value / Constants.PARA_CORE_DURABILITY_DECREASE_FACTOR);
    }
}
