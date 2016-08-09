package bg.softuni.interfaces;

import bg.softuni.exceptions.NoSelectedCoreException;
import bg.softuni.exceptions.UnexistentCoreException;

public interface PowerPlant {

    Integer getCountOfCores();

    Integer getCountOfFragments();

    String getNextCoreName();

    Boolean hasSelectedCore();

    Core getCurrentlySelectedCore();

    void selectCore(String coreName) throws UnexistentCoreException;

    void attachCore(Core core);

    Core detachCore(String coreName) throws UnexistentCoreException;

    Core getCore(String coreName) throws UnexistentCoreException;

    Boolean containsCore(String coreName);

    void attachFragment(Fragment fragment) throws NoSelectedCoreException;

    Fragment detachFragment() throws NoSelectedCoreException;
}
