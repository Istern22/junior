package ru.job4j.paint;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("xxxx")
                                .append(System.lineSeparator())
                                .append("x  x")
                                .append(System.lineSeparator())
                                .append("xxxx")
                                .append(System.lineSeparator())
                                .toString()

                )
        );
    }
}

