package ru.job4j.paint;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   x   ")
                                .append(System.lineSeparator())
                                .append("  xxx  ")
                                .append(System.lineSeparator())
                                .append(" xxxxx ")
                                .append(System.lineSeparator())
                                .append("xxxxxxx")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
