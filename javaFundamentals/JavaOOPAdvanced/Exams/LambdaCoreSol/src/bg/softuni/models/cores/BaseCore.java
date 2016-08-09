package bg.softuni.models.cores;

import bg.softuni.collection.LStack;
import bg.softuni.enums.CoreStatus;
import bg.softuni.enums.FragmentType;
import bg.softuni.interfaces.Core;
import bg.softuni.interfaces.Fragment;

public abstract class BaseCore implements Core {

    private String name;

    private Integer durability;

    private LStack<Fragment> stackedFragments;

    protected BaseCore(String name, Integer durability) {
        this.setName(name);
        this.setDurability(durability);
        this.stackedFragments = new LStack<Fragment>();
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String value) {
        this.name = value;
    }

    public Integer getDurability() {
        //THE CORE'S DURABILITY - THE CURRENT PRESSURE ON THE CORE
        //IF THE PRESSURE IS BELOW ZERO OR ZERO THE CORE'S DURABILITY WILL REMAIN AT MAXIMUM
        //BECAUSE THE .getCurrentPressure() METHOD WILL NOT RETURN A VALUE BELOW ZERO
        Long result = this.durability - this.getCurrentPressure();

        //THE DURABILITY SHOULD NOT FALL BELOW ZERO
        return result > 0 ? result.intValue() : 0;
    }

    protected void setDurability(Integer value) {
        this.durability = value;
    }

    public Integer getFragmentsCount() {
        return this.stackedFragments.size();
    }

    protected CoreStatus getStatus() {
        return this.getCurrentPressure() > 0 ? CoreStatus.CRITICAL : CoreStatus.NORMAL;
    }

    public Long getCurrentPressure() {
        Long totalPressure = 0L;

        for (Fragment fragment : this.stackedFragments) {
            if (fragment.getType().equals(FragmentType.Nuclear)) {
                totalPressure += fragment.getPressureAffection();
            } else {
                totalPressure -= fragment.getPressureAffection();
            }
        }

        //IF THE PRESSURE IS BELOW ZERO IT DOES NOT PRESENT ANY CHANGE TO THE CORE'S DURABILITY
        //THAT IS WHY, WE JUST RETURN ZERO
        return totalPressure > 0 ? totalPressure : 0;
    }

    public Fragment attachFragment(Fragment fragment) {
        Fragment result = this.stackedFragments.push(fragment);
        return result;
    }

    public Fragment detachFragment() {
        Fragment result = this.stackedFragments.pop();
        return result;
    }

    public Fragment peekFragment() {
        Fragment result = this.stackedFragments.peek();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("Core %s:", this.getName()) + System.lineSeparator());
        result.append(String.format("####Durability: %d", this.getDurability()) + System.lineSeparator());
        result.append(String.format("####Status: %s", this.getStatus()));

        return result.toString();
    }
}
