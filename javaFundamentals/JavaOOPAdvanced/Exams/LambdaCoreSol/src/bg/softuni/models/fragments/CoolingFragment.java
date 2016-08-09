package bg.softuni.models.fragments;

import bg.softuni.enums.FragmentType;
import bg.softuni.utilities.Constants;

public class CoolingFragment extends BaseFragment {
    public CoolingFragment(String name, Integer pressureAffection) {
        super(name, pressureAffection);
        this.setType(FragmentType.Cooling);
    }

    @Override
    protected void setPressureAffection(Integer value) {
        super.setPressureAffection(value * Constants.COOLING_FRAGMENT_PRESSURE_AFFECTION_INCREASE_FACTOR);
    }
}
