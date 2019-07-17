package ru.job4j.profession;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DentistTest {
    @Test
    public void getNameDentist() {
        Profession dentist = new Profession("Petr", "Arsentev", "high", 110285);
        String name = dentist.getName();
        assertThat(name, is("Petr"));
    }
}
