package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListToArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertListToArray list = new ConvertListToArray();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
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
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
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
                Arrays.asList(5, 6, 7),
                3
        );
        int[][] expected = {
                {5},
                {6},
                {7}
        };
        assertThat(result, is(expected));
    }
}
