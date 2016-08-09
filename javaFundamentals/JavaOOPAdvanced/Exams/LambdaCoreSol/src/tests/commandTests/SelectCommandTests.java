package tests.commandTests;

import bg.softuni.commands.SelectCommand;
import bg.softuni.core.NuclearPowerPlant;
import bg.softuni.interfaces.Command;
import bg.softuni.interfaces.Core;
import bg.softuni.interfaces.PowerPlant;
import bg.softuni.models.cores.SystemCore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SelectCommandTests {

    private PowerPlant testNuclearPowerPlant;

    @Before
    public void setUp() {
        this.testNuclearPowerPlant = new NuclearPowerPlant();
    }

    @Test
    public void testSelect_withUnexistentCore_shouldReturnErrorMessage() {
        Command testCommand = new SelectCommand(this.testNuclearPowerPlant, "A");
        String actualMessage = testCommand.execute();

        String expectedMessage = "Failed to select Core A!";
        Assert.assertEquals("Select command does not work correctly!", expectedMessage, actualMessage);
    }

    @Test
    public void testSelect_withExistentCore_shouldReturnSuccessMessage() {
        Core dummyCore = new SystemCore("A", 20);
        this.testNuclearPowerPlant.attachCore(dummyCore);

        Command testCommand = new SelectCommand(this.testNuclearPowerPlant, "A");
        String actualMessage = testCommand.execute();

        String expectedMessage = "Currently selected Core A!";
        Assert.assertEquals("Select command does not work correctly!", expectedMessage, actualMessage);
    }

    @Test
    public void testSelect_withExistentCore_shouldSetCurrentlySelectedCoreCorrectly() {
        Core dummyCore = new SystemCore("A", 20);
        this.testNuclearPowerPlant.attachCore(dummyCore);

        Command testCommand = new SelectCommand(this.testNuclearPowerPlant, "A");
        testCommand.execute();

        Assert.assertEquals("Select command does not work correctly!", this.testNuclearPowerPlant.getCurrentlySelectedCore(), dummyCore);
    }
}
