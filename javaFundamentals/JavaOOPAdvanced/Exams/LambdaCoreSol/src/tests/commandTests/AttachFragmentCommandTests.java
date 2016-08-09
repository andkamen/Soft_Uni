package tests.commandTests;

import bg.softuni.commands.AttachFragmentCommand;
import bg.softuni.core.NuclearPowerPlant;
import bg.softuni.enums.FragmentType;
import bg.softuni.exceptions.UnexistentCoreException;
import bg.softuni.interfaces.Command;
import bg.softuni.interfaces.Core;
import bg.softuni.interfaces.PowerPlant;
import bg.softuni.models.cores.SystemCore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AttachFragmentCommandTests {

    private PowerPlant testNuclearPowerPlant;

    @Before
    public void setUp() {
        this.testNuclearPowerPlant = new NuclearPowerPlant();
    }

    @Test
    public void testAttach_withUnselectedCore_shouldReturnFailureMessage() {
        Command testCommand = new AttachFragmentCommand(this.testNuclearPowerPlant, FragmentType.Nuclear, "Test", 1);
        String actualMessage = testCommand.execute();

        String expectedMessage = "Failed to attach Fragment Test!";
        Assert.assertEquals("AttachFragment command does not work correctly!", expectedMessage, actualMessage);
    }

    @Test
    public void testAttach_withInvalidPressureAffection_shouldReturnFailureMessage() throws UnexistentCoreException {
        Core dummyCore = new SystemCore("A", 100);
        this.testNuclearPowerPlant.attachCore(dummyCore);
        this.testNuclearPowerPlant.selectCore("A");

        Command testCommand = new AttachFragmentCommand(this.testNuclearPowerPlant, FragmentType.Nuclear, "Test", -1);
        String actualMessage = testCommand.execute();

        String expectedMessage = "Failed to attach Fragment Test!";
        Assert.assertEquals("AttachFragment command does not work correctly!", expectedMessage, actualMessage);
    }

    @Test
    public void testAttach_withSelectedCore_shouldReturnSuccessMessage() throws UnexistentCoreException {
        Core dummyCore = new SystemCore("A", 100);
        this.testNuclearPowerPlant.attachCore(dummyCore);
        this.testNuclearPowerPlant.selectCore("A");

        Command testCommand = new AttachFragmentCommand(this.testNuclearPowerPlant, FragmentType.Nuclear, "Test", 1);
        String actualMessage = testCommand.execute();

        String expectedMessage = "Successfully attached Fragment Test to Core A!";
        Assert.assertEquals("AttachFragment command does not work correctly!", expectedMessage, actualMessage);
    }
}
