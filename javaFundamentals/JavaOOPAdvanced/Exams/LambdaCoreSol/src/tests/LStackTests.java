package tests;

import bg.softuni.collection.LStack;
import bg.softuni.interfaces.Fragment;
import bg.softuni.models.fragments.NuclearFragment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LStackTests {

    private LStack<Fragment> testStack;

    @Before
    public void setUp() {
        this.testStack = new LStack<Fragment>();
    }

    @Test
    public void testadditionOfElement_withOneElement_shouldWorkFine() {
        Fragment dummyFragment = new NuclearFragment("Test", 1);

        this.testStack.push(dummyFragment);

        for (Fragment fragment : testStack) {
            Assert.assertEquals("Addition of elements in LStack does not work properly!", dummyFragment, fragment);
        }
    }

    @Test
    public void testSizeOfStack_withTwoElements_shouldReturnCorrectValue() {

        Fragment dummyFragment = new NuclearFragment("Test", 1);
        Fragment anotherDummyFragment = new NuclearFragment("Test2", 1);

        this.testStack.push(dummyFragment);
        this.testStack.push(anotherDummyFragment);

        Integer stackSize = this.testStack.size();
        Assert.assertEquals("Size retrieval of LStack does not work properly!", 2, stackSize.intValue());
    }

    @Test
    public void testElementRemoval_removeWithTwoElements_shouldDecreaseStackSize() {
        Fragment dummyFragment = new NuclearFragment("Test", 1);
        Fragment anotherDummyFragment = new NuclearFragment("Test2", 1);

        this.testStack.push(dummyFragment);
        this.testStack.push(anotherDummyFragment);

        this.testStack.pop();

        Integer stackSize = this.testStack.size();
        Assert.assertEquals("Removal of elements in LStack does not work properly!", 1, stackSize.intValue());
    }

    @Test
    public void testElementRemoval_removeWithTwoElements_shouldReturnTopElement() {
        Fragment dummyFragment = new NuclearFragment("Test", 1);
        Fragment anotherDummyFragment = new NuclearFragment("Test2", 1);

        this.testStack.push(dummyFragment);
        this.testStack.push(anotherDummyFragment);

        Fragment removedElement = this.testStack.pop();

        Assert.assertEquals("Removal of elements in LStack does not work properly!", removedElement, anotherDummyFragment);
    }

    @Test
    public void testPeek_peekWithOneElement_shouldReturnElement() {
        Fragment dummyFragment = new NuclearFragment("Test", 1);

        this.testStack.push(dummyFragment);

        Fragment peekedFragment = this.testStack.peek();

        Assert.assertEquals("Peeking of elements in LStack does not work properly!", peekedFragment, dummyFragment);
    }

    @Test
    public void testPeek_peekWithOneElement_shouldNotDecreaseSizeOfStack() {
        Fragment dummyFragment = new NuclearFragment("Test", 1);

        this.testStack.push(dummyFragment);

        Fragment peekedFragment = this.testStack.peek();

        Integer stackSize = this.testStack.size();
        Assert.assertEquals("Peeking of elements in LStack does not work properly!", 1, stackSize.intValue());
    }

    @Test
    public void testPeek_peekWithTwoElements_shouldReturnTopElement() {
        Fragment dummyFragment = new NuclearFragment("Test", 1);
        Fragment anotherDummyFragment = new NuclearFragment("Test2", 1);

        this.testStack.push(dummyFragment);
        this.testStack.push(anotherDummyFragment);

        Fragment removedElement = this.testStack.peek();

        Assert.assertEquals("Peeking of elements in LStack does not work properly!", removedElement, anotherDummyFragment);
    }

    @Test
    public void testIsEmpty_withZeroElements_shouldReturnTrue() {
        Boolean isEmpty = this.testStack.isEmpty();
        Assert.assertEquals("IsEmpty check in LStack does not work properly!", true, isEmpty);
    }

    @Test
    public void testIsEmpty_withTwoElements_shouldReturnFalse() {
        Fragment dummyFragment = new NuclearFragment("Test", 1);
        Fragment anotherDummyFragment = new NuclearFragment("Test2", 1);

        this.testStack.push(dummyFragment);
        this.testStack.push(anotherDummyFragment);

        Boolean isEmpty = this.testStack.isEmpty();
        Assert.assertEquals("IsEmpty check in LStack does not work properly!", false, isEmpty);
    }
}