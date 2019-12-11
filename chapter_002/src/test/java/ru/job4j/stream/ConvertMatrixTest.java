package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrixTest {
    @Test
    public void whenConvertMatrix() {
        ConvertMatrix convertMatrix = new ConvertMatrix();
        List<List<Integer>> matrix = List.of(
                List.of(1, 2, 3, 4),
                List.of(0, 1, 2, 3),
                List.of(0, 0, 1, 2)
        );

        assertThat(convertMatrix.convertMatrix(matrix), is(List.of(1, 2, 3, 4, 0, 1, 2, 3, 0, 0, 1, 2)));
    }
}
