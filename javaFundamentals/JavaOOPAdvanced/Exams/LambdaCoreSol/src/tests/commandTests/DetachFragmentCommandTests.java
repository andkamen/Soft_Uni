package tests.commandTests;

import bg.softuni.commands.DetachFragmentCommand;
import bg.softuni.core.NuclearPowerPlant;
import bg.softuni.exceptions.UnexistentCoreException;
import bg.softuni.interfaces.Command;
import bg.softuni.interfaces.Core;
import bg.softuni.interfaces.Fragment;
import bg.softuni.interfaces.PowerPlant;
import bg.softuni.models.cores.SystemCore;
import bg.softuni.models.fragments.NuclearFragment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DetachFragmentCommandTests {

    private PowerPlant testNuclearPowerPlant;

    @Before
    public void setUp() {
        this.testNuclearPowerPlant = new NuclearPowerPlant();
    }

    @Test
    public void testDetach_withNoSelectedCore_shouldReturnFailureMessage() {
        Command testCommand = new DetachFragmentCommand(this.testNuclearPowerPlant);
        String actualMessage = testCommand.execute();

        String expectedMessage = "Failed to detach Fragment!";
        Assert.assertEquals("DetachFragment command does not work correctly!", expectedMessage, actualMessage);
    }

    @Test
    public void testDetach_withSelectedCore_withNoFragments_shouldReturnFailureMessage() throws UnexistentCoreException {
        Core dummyCore = new SystemCore("A", 100);
        this.testNuclearPowerPlant.attachCore(dummyCore);
        this.testNuclearPowerPlant.selectCore("A");

        Command testCommand = new DetachFragmentCommand(this.testNuclearPowerPlant);
        String actualMessage = testCommand.execute();

        String expectedMessage = "Failed to detach Fragment!";
        Assert.assertEquals("DetachFragment command does not work correctly!", expectedMessage, actualMessage);
    }

    @Test
    public void testDetach_withSelectedCore_withOneFragment_shouldReturnSuccessMessage() throws UnexistentCoreException {
        Core dummyCore = new SystemCore("A", 100);
        Fragment dummyFragment = new NuclearFragment("Test", 1);
        dummyCore.attachFragment(dummyFragment);

        this.testNuclearPowerPlant.attachCore(dummyCore);
        this.testNuclearPowerPlant.selectCore("A");

        Command testCommand = new DetachFragmentCommand(this.testNuclearPowerPlant);
        String actualMessage = testCommand.execute();

        String expectedMessage = "Successfully detached Fragment Test from Core A!";
        Assert.assertEquals("DetachFragment command does not work correctly!", expectedMessage, actualMessage);
    }

    @Test
    public void testDetach_withSelectedCore_withTwoFragments_shouldDetachTopFragment() throws UnexistentCoreException {
        Core dummyCore = new SystemCore("A", 100);
        Fragment dummyFragment = new NuclearFragment("Test", 1);
        Fragment anotherDummyFragment = new NuclearFragment("Test2", 1);
        dummyCore.attachFragment(dummyFragment);
        dummyCore.attachFragment(anotherDummyFragment);

        this.testNuclearPowerPlant.attachCore(dummyCore);
        this.testNuclearPowerPlant.selectCore("A");

        Command testCommand = new DetachFragmentCommand(this.testNuclearPowerPlant);
        String actualMessage = testCommand.execute();

        String expectedMessage = "Successfully detached Fragment Test2 from Core A!";
        Assert.assertEquals("DetachFragment command does not work correctly!", expectedMessage, actualMessage);
    }
}
