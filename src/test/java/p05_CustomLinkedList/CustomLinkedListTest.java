package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    CustomLinkedList<String> customLinkedList;

    @Before
    public void setup() {
        customLinkedList = new CustomLinkedList<>();
    }

    @Test
    public void testAddSuccess() {
        customLinkedList.add("Pesho");
        assertEquals("Pesho", customLinkedList.get(0));
    }

    @Test
    public void test_Add_ToNotEmptyList() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Ivan");
        assertEquals("Ivan", customLinkedList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Get_ShouldThrow_ForMissingIndex() {
        customLinkedList.get(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Get_ShouldThrow_ForNegativeIndex() {
        customLinkedList.get(-4);
    }

}