package ru.job4j.pool;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RowColSumTest {

    @Test
    public void whenSumWithMatrix3() {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RowColSum.Sums[] sums = RowColSum.sum(matrix);
        assertThat(sums[0].getRowSum(), is(6));
        assertThat(sums[1].getRowSum(), is(15));
        assertThat(sums[2].getRowSum(), is(24));
        assertThat(sums[0].getColSum(), is(12));
        assertThat(sums[1].getColSum(), is(15));
        assertThat(sums[2].getColSum(), is(18));
    }

    @Test
    public void whenSumWithMatrix4() {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        RowColSum.Sums[] sums = RowColSum.sum(matrix);
        assertThat(sums[0].getRowSum(), is(10));
        assertThat(sums[1].getRowSum(), is(26));
        assertThat(sums[2].getRowSum(), is(42));
        assertThat(sums[3].getRowSum(), is(58));
        assertThat(sums[0].getColSum(), is(28));
        assertThat(sums[1].getColSum(), is(32));
        assertThat(sums[2].getColSum(), is(36));
        assertThat(sums[3].getColSum(), is(40));
    }

    @Test
    public void whenAsyncSumWithMatrix3() throws ExecutionException, InterruptedException {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RowColSum.Sums[] sums = RowColSum.asyncSum(matrix);
        assertThat(sums[0].getRowSum(), is(6));
        assertThat(sums[1].getRowSum(), is(15));
        assertThat(sums[2].getRowSum(), is(24));
        assertThat(sums[0].getColSum(), is(12));
        assertThat(sums[1].getColSum(), is(15));
        assertThat(sums[2].getColSum(), is(18));
    }

    @Test
    public void whenAsyncSumWithMatrix4() {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        RowColSum.Sums[] sums = RowColSum.sum(matrix);
        assertThat(sums[0].getRowSum(), is(10));
        assertThat(sums[1].getRowSum(), is(26));
        assertThat(sums[2].getRowSum(), is(42));
        assertThat(sums[3].getRowSum(), is(58));
        assertThat(sums[0].getColSum(), is(28));
        assertThat(sums[1].getColSum(), is(32));
        assertThat(sums[2].getColSum(), is(36));
        assertThat(sums[3].getColSum(), is(40));
    }

}