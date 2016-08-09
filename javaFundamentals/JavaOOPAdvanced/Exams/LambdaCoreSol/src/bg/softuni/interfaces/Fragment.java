package bg.softuni.interfaces;

import bg.softuni.enums.FragmentType;

public interface Fragment {
    String getName();

    FragmentType getType();

    Integer getPressureAffection();
}
