package bg.softuni.models.fragments;

import bg.softuni.enums.FragmentType;
import bg.softuni.utilities.Constants;

public class NuclearFragment extends BaseFragment{

    public NuclearFragment(String name, Integer pressureAffection) {
        super(name, pressureAffection);
        this.setType(FragmentType.Nuclear);
    }

    @Override
    protected void setPressureAffection(Integer value) {
        super.setPressureAffection(value * Constants.NUCLEAR_FRAGMENT_PRESSURE_AFFECTION_INCREASE_FACTOR);
    }
}
