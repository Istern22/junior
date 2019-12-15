package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListToArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertListToArray list = new ConvertListToArray();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expected));
    }

    @Test
    public void when7ElementsThen8() {
        ConvertListToArray list = new ConvertListToArray();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7),
                2
        );
        int[][] expected = {
                {1, 2, 3, 4},
                {5, 6, 7, 0}
        };
        assertThat(result, is(expected));
    }

    @Test
    public void when3ElementsThen3() {
        ConvertListToArray list = new ConvertListToArray();
        int[][] result = list.toArray(
                List.of(5, 6, 7),
                3
        );
        int[][] expected = {
                {5},
                {6},
                {7}
        };
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoArrays() {
        ConvertListToArray convertList = new ConvertListToArray();
        List<int[]> list = List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5, 6}
                );
        List<Integer> result = convertList.convert(list);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expected));
    }

    @Test
    public void whenThreeArrays() {
        ConvertListToArray convertList = new ConvertListToArray();
        List<int[]> list = List.of(
                new int[]{1, 0},
                new int[]{0, 1, 0, 1},
                new int[]{0}
        );
        List<Integer> result = convertList.convert(list);
        List<Integer> expected = List.of(1, 0, 0, 1, 0, 1, 0);
        assertThat(result, is(expected));
    }
}
