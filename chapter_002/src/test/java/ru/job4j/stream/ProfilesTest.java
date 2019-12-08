package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    public final static List<Address> ADDRESSES = List.of(
            new Address("Москва", "Гоголя", 1, 1),
            new Address("Москва", "Толстого", 1, 1),
            new Address("Казань", "Карла Маркса", 1, 1),
            new Address("Владивосток", "Набережная", 1, 1)
    );

    @Test
    public void whenMapProfiles() {
        Profiles profiles = new Profiles();
        List<Profile> profileList = ADDRESSES.stream().map(x -> new Profile(x)).collect(Collectors.toList());
        assertThat(profiles.collect(profileList), is(ADDRESSES));
    }
}
