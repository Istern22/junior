package ru.job4j.solid.tdd;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleGeneratorTest {

    @Test
    public void whenGenerateSuccess() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = Map.of("name", "Petr", "subject", "you");
        String string = "I am a ${name}, Who are ${subject}?";
        assertThat(generator.produce(string, map), is("I am a Petr, Who are you?"));
    }

    @Test
    public void whenGenerateFail() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = Map.of("name", "Petr", "subject", "you", "surname", "Arsentev");
        String string = "I am a ${name}, Who are ${subject}?";
        assertThat(generator.produce(string, map), is(new Exception()));
    }

    @Test
    public void whenGenerateFailElse() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = Map.of("subject", "you");
        String string = "I am a ${name}, Who are ${subject}?";
        assertThat(generator.produce(string, map), is(new Exception()));
    }

}