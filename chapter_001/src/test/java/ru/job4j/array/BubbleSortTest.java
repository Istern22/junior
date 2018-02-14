package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSortTest {
    @Test
    public void whenSortArrayOfTenElementsThanSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] notSortedArray = {8, 9, 5, 4, 7, 6, 2, 3, 1, 10};
        int[] sortedArray = bubbleSort.sort(notSortedArray);
        int[] expectArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(sortedArray, is(expectArray));
    }

    @Test
    public void whenSortArrayOfFiveElementsThanSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] notSortedArray = {8, 5, 5, 4, 4};
        int[] sortedArray = bubbleSort.sort(notSortedArray);
        int[] expectArray = {4, 4, 5, 5, 8};
        assertThat(sortedArray, is(expectArray));
    }
}
