package ru.job4j.comparator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListCompareTest {
    @Test
    public void whenStringAreEqualThenZero() {
        ListCompare compare = new ListCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(result, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        ListCompare compare = new ListCompare();
        int result = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        ListCompare compare = new ListCompare();
        int result = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result, greaterThan(0));
    }

    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int result = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(result, lessThan(0));
    }
}
