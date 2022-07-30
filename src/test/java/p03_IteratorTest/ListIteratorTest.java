package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest{

    private ListIterator listIterator;

    private static final String[] NAMES = {"Angel", "Mariya", "Deya", "Emanuil"};

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_CreatListIterator_WithNull_ShouldThrow() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void test_HasNext() {
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
        listIterator.move();
    }

    @Test
    public void test_Move_HasNextMove_NoNextMove() {
        for (int i = 0; i < NAMES.length - 1; i++) {
            assertTrue(listIterator.move());
        }
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void test_Print_WithNoElements_ShouldThrow() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void test_Print_WithElements() {
        int index = 0;
        while (listIterator.hasNext()) {
            assertEquals(NAMES[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }
}