package bg.softuni.interfaces;

public interface Core {
    String getName();

    Integer getDurability();

    Integer getFragmentsCount();

    Long getCurrentPressure();

    Fragment attachFragment(Fragment fragment);

    Fragment detachFragment();

    Fragment peekFragment();
}