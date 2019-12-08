package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        CityComparator cityComparator = new CityComparator();
        return profiles.stream().distinct().map(
                profile -> profile.getAddress()
        ).sorted(cityComparator).collect(Collectors.toList());
    }
}
