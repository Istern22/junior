package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrixToListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrixToList list = new ConvertMatrixToList();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expected = List.of(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expected));
    }

    @Test
    public void when3on3ArrayThenList9() {
        ConvertMatrixToList list = new ConvertMatrixToList();
        int[][] input = {
                {1, 2, 7},
                {3, 4, 5},
                {0, 0, 1}
        };
        List<Integer> expected = List.of(
                1, 2, 7, 3, 4, 5, 0, 0, 1
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expected));
    }
}