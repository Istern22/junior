package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = arrayDuplicate.remove(array);
        String[] expected = {"Привет", "Мир", "Супер"};
        assertThat(result, arrayContainingInAnyOrder(expected));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateTwo() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = {"hi", "hi", "no", "java", "util", "util", "no", "java"};
        String[] result = arrayDuplicate.remove(array);
        String[] expected = {"hi", "no", "java", "util"};
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
}
