package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest {

    @Test
    public void whenAllTrue() {
        assertThat(Check.mono(new boolean[] {true, true, true}), is(true));
    }

    @Test
    public void whenAllFalse() {
        assertThat(Check.mono(new boolean[] {false, false, false}), is(true));
    }

    @Test
    public void whenNoMono() {
        assertThat(Check.mono(new boolean[] {false, true, false}), is(false));
    }
}
