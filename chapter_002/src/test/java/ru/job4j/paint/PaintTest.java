package ru.job4j.paint;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PaintTest {
    /**
     * Получаем ссылку на стандартный вывод в консоль.
     * Создаем буфер для хранения вывода.
     * Заменяем стандартный вывод на вывод в память для тестирования.
     * Выполняем действие, пишущее в консоль.
     * Проверяем результат вычисления.
     * Возвращаем обратно стандартный вывод в консоль.
     */
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
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
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
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
        System.setOut(stdout);
    }
}
