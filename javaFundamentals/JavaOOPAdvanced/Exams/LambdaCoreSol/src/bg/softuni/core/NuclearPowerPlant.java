package bg.softuni.core;

import bg.softuni.exceptions.NoSelectedCoreException;
import bg.softuni.exceptions.UnexistentCoreException;
import bg.softuni.interfaces.Core;
import bg.softuni.interfaces.Fragment;
import bg.softuni.interfaces.PowerPlant;
import bg.softuni.utilities.Constants;
import bg.softuni.utilities.Messages;

import java.util.LinkedHashMap;
import java.util.Map;

public class NuclearPowerPlant implements PowerPlant {

    private Core currentlySelectedCore;

    private LinkedHashMap<String, Core> powerPlantCores;

    private String currentCoreName;

    public NuclearPowerPlant() {
        this.powerPlantCores = new LinkedHashMap<String, Core>();
        this.currentlySelectedCore = null;
    }

    public Integer getCountOfCores() {
        Integer result = this.powerPlantCores.size();
        return result;
    }

    public Integer getCountOfFragments() {
        Integer countOfFragments = 0;

        for (Map.Entry<String, Core> coreEntry : this.powerPlantCores.entrySet()) {
            countOfFragments += coreEntry.getValue().getFragmentsCount();
        }

        return countOfFragments;
    }


    private void updateCurrentCoreName() {
        Character oldValue = this.getCurrentCoreName().charAt(0);
        this.setCurrentCoreName((char) (oldValue + Constants.CORE_NEXT_NAME_UPDATE_VALUE) + Constants.EMPTY_STRING);
    }


    public String getNextCoreName() {
        String result = this.getCurrentCoreName();
        this.updateCurrentCoreName();

        return result;
    }

    protected String getCurrentCoreName() {
        if (this.currentCoreName == null) {
            this.setCurrentCoreName(Constants.INITIAL_CORE_NAME);
        }

        return this.currentCoreName;
    }

    protected void setCurrentCoreName(String value) {
        this.currentCoreName = value;
    }

    public Boolean hasSelectedCore() {
        Boolean result = this.currentlySelectedCore != null;
        return result;
    }

    public Core getCurrentlySelectedCore() {
        Core result = this.currentlySelectedCore;
        return result;
    }

    public void selectCore(String coreName) throws UnexistentCoreException {
        if (!this.containsCore(coreName)) {
            throw new UnexistentCoreException(String.format(Messages.FAILURE_CORE_SELECT_MESSAGE, coreName));
        }

        this.currentlySelectedCore = this.getCore(coreName);
    }

    public void attachCore(Core core) {
        this.powerPlantCores.put(core.getName(), core);
    }

    public Core detachCore(String coreName) throws UnexistentCoreException {
        if (!this.containsCore(coreName)) {
            throw new UnexistentCoreException(String.format(Messages.FAILURE_CORE_REMOVE_MESSAGE, coreName));
        }

        Core result = this.powerPlantCores.remove(coreName);

        if(this.currentlySelectedCore.equals(result)) {
            this.currentlySelectedCore = null;
        }

        return result;
    }

    public Core getCore(String coreName) throws UnexistentCoreException {
        if (!this.containsCore(coreName)) {
            throw new UnexistentCoreException(String.format(Messages.FAILURE_CORE_RETRIEVE_MESSAGE, coreName));
        }

        Core result = this.powerPlantCores.get(coreName);
        return result;
    }

    public Boolean containsCore(String coreName) {
        Boolean result = this.powerPlantCores.containsKey(coreName);
        return result;
    }

    public void attachFragment(Fragment fragment) throws NoSelectedCoreException {
        if (!this.hasSelectedCore()) {
            throw new NoSelectedCoreException();
        }

        this.getCurrentlySelectedCore().attachFragment(fragment);
    }

    public Fragment detachFragment() throws NoSelectedCoreException {
        if (!this.hasSelectedCore()) {
            throw new NoSelectedCoreException();
        }

        return this.getCurrentlySelectedCore().detachFragment();
    }

    protected Long getTotalSystemDurability() {
        Long totalSystemDurability = 0L;

        for (Map.Entry<String, Core> coreEntry : powerPlantCores.entrySet()) {
            totalSystemDurability += coreEntry.getValue().getDurability();
        }

        return totalSystemDurability;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Lambda Core Power Plant Status:" + System.lineSeparator());
        result.append(String.format("Total Durability: %d", this.getTotalSystemDurability()) + System.lineSeparator());
        result.append(String.format("Total Cores: %d", this.getCountOfCores()) + System.lineSeparator());
        result.append(String.format("Total Fragments: %d", this.getCountOfFragments()) + System.lineSeparator());

        for (Map.Entry<String, Core> coreEntry : powerPlantCores.entrySet()) {
            result.append(coreEntry.getValue().toString() + System.lineSeparator());
        }

        return result.toString().trim();
    }
}
