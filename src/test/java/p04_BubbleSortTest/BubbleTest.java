package p04_BubbleSortTest;


import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    @Test
    public void testSort() {
        int[] numbers = {9, -5, 6, 1, 12, 100};
        Bubble.sort(numbers);
        int[] sortedArrayToCompare = {-5, 1, 6, 9, 12, 100};
        assertArrayEquals(sortedArrayToCompare, numbers);
    }

}