package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    public final static List<Address> ADDRESSES = List.of(
            new Address("Владивосток", "Набережная", 1, 1),
            new Address("Казань", "Карла Маркса", 1, 1),
            new Address("Москва", "Гоголя", 1, 1)
    );

    public final static List<Profile> PROFILES = List.of(
            new Profile(new Address("Москва", "Гоголя", 1, 1)),
            new Profile(new Address("Москва", "Гоголя", 1, 1)),
            new Profile(new Address("Казань", "Карла Маркса", 1, 1)),
            new Profile(new Address("Владивосток", "Набережная", 1, 1))
    );

    @Test
    public void whenMapProfiles() {
        Profiles profiles = new Profiles();
        assertThat(profiles.collect(PROFILES), is(ADDRESSES));
    }
}
