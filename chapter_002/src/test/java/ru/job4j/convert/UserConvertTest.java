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
        List<User> list = new ArrayList<>();
        HashMap<Integer, User> result = new HashMap<>();
        list.add(new User(001, "ivan", "moscow"));
        list.add(new User(002, "svetlana", "ufa"));
        list.add(new User(003, "tatyana", "vladivostok"));
        result = convert.process(list);
        assertThat(result.get(003).getCity(), is("vladivostok"));
    }

    @Test
    public void whenOneUser() {
        UserConvert convert = new UserConvert();
        List<User> list = new ArrayList<>();
        HashMap<Integer, User> result = new HashMap<>();
        list.add(new User(001, "ivan", "moscow"));
        list.add(new User(001, "svetlana", "ufa"));
        result = convert.process(list);
        assertThat(result.get(001).getCity(), is("ufa"));
    }

}
