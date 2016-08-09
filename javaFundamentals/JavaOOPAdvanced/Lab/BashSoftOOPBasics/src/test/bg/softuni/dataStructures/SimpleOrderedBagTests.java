package test.bg.softuni.dataStructures;

import main.bg.softuni.dataStructures.SimpleSortedList;
import main.bg.softuni.dataStructures.contracts.SimpleOrderedBag;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class SimpleOrderedBagTests {

    private SimpleOrderedBag<String> names;

    @Before
    public void setUp() {
        this.names = new SimpleSortedList<>(String.class);
    }

    @Test
    public void testEmptyCtor() {
        int expectedCapacity = 16;
        int expectedSize = 0;

        this.names = new SimpleSortedList<>(String.class);
        assertEquals(expectedCapacity, this.names.capacity());
        assertEquals(expectedSize, this.names.size());

    }

    @Test
    public void testCtorWithInitialCapacity() {
        int expectedCapacity = 20;
        int expectedSize = 0;

        this.names = new SimpleSortedList<>(String.class, 20);
        assertEquals(expectedCapacity, this.names.capacity());
        assertEquals(expectedSize, this.names.size());
    }

    @Test
    public void testCtorWithInitialComparer() {
        int expectedCapacity = 16;
        int expectedSize = 0;

        this.names = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER);
        assertEquals(expectedCapacity, this.names.capacity());
        assertEquals(expectedSize, this.names.size());
    }

    @Test
    public void testCtorWithAllParams() {
        int expectedCapacity = 30;
        int expectedSize = 0;

        this.names = new SimpleSortedList<>(String.class,
                String.CASE_INSENSITIVE_ORDER,
                30);
        assertEquals(expectedCapacity, this.names.capacity());
        assertEquals(expectedSize, this.names.size());
    }


    @Test
    public void testAddIncreasesSize() {
        int expectedSize = 1;

        this.names.add("Nasko");
        assertEquals(expectedSize, this.names.size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddNullThrows() {
        this.names.add(null);
    }

    @Test
    public void testAddUnsortedDataIsHeldSorted() {
        String[] expected = {"Balkan", "Georgi", "Rosen"};

        this.names.add("Rosen");
        this.names.add("Georgi");
        this.names.add("Balkan");

        int index = 0;
        for (String name : names) {
            assertEquals(expected[index++], name);
        }
    }

    @Test
    public void testAddingMoreThanInitialCapacity() {
        int unexpectedCapacity = 16;
        int expectedSize = 17;

        for (int i = 0; i < 17; i++) {
            this.names.add("Test");
        }

        assertEquals(expectedSize, this.names.size());
        assertNotEquals(unexpectedCapacity, this.names.capacity());
    }

    @Test
    public void testAddingAllFromCollectionIncreasesSize() {
        int expectedSize = 2;

        this.names.addAll(Arrays.asList("Test", "Test"));

        assertEquals(expectedSize, this.names.size());
    }

    @Test(expected = NullPointerException.class)
    public void testAddingAllFromNullThrows() {

        this.names.addAll(Arrays.asList("Test", null));
    }

    @Test
    public void testAddAllKeepsSorted() {
        String[] expected = {"Balkan", "Georgi", "Rosen"};

        this.names.addAll(Arrays.asList("Rosen", "Balkan", "Georgi"));
        int index = 0;
        for (String name : names) {
            assertEquals(expected[index++], name);
        }
    }

    @Test
    public void testRemoveValidElementDecreasesSize() {
        int expectedSize = 2;
        this.names.addAll(Arrays.asList("Rosen", "Balkan", "Georgi"));
        this.names.remove("Rosen");

        assertEquals(expectedSize, this.names.size());
    }

    @Test
    public void testRemoveValidElementRemovesSelectedOne() {
        String removedElement = "Rosen";
        this.names.addAll(Arrays.asList("Rosen", "Balkan", "Georgi"));
        this.names.remove("Rosen");

        for (String name : names) {
            assertNotEquals(removedElement, name);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testRemovingNullThrowsException() {
        this.names.remove(null);
    }

    @Test
    public void testJoinWorksFine() {
        String expectedResult = "Balkan, Georgi, Rosen";
        this.names.addAll(Arrays.asList("Rosen", "Balkan", "Georgi"));
        String actualResult = this.names.joinWith(", ");
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = NullPointerException.class)
    public void testJoinWithNull() {
        this.names.addAll(Arrays.asList("Rosen", "Balkan", "Georgi"));
        String actualResult = this.names.joinWith(null);
    }

}

