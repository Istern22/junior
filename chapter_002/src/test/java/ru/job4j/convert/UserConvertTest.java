package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenThreeUsers() {
        UserConvert convert = new UserConvert();
        List<User> list = List.of(
                new User(001, "ivan", "moscow"),
                new User(002, "svetlana", "ufa"),
                new User(003, "tatyana", "vladivostok")
        );
        HashMap<Integer, User> result = convert.process(list);
        assertThat(result.get(003).getCity(), is("vladivostok"));
    }

    @Test
    public void whenOneUser() {
        UserConvert convert = new UserConvert();
        List<User> list = List.of(
                new User(001, "ivan", "moscow"),
                new User(001, "svetlana", "ufa")
        );
        HashMap<Integer, User> result = convert.process(list);
        assertThat(result.get(001).getCity(), is("ufa"));
    }

}
