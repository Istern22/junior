package ru.job4j.exam;

import org.junit.Test;
import ru.job4j.exam.CoffeeMachine;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
    @Test
    public void whenChangeFifteen() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] change = {10, 5};
        assertThat(coffeeMachine.changes(50, 35), is(change));
    }

    @Test
    public void whenNoChange() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] change = {};
        assertThat(coffeeMachine.changes(50, 50), is(change));
    }

    @Test
    public void whenChangeEighteen() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] change = {10, 5, 2, 1};
        assertThat(coffeeMachine.changes(50, 32), is(change));
    }

    @Test
    public void whenChangeTwentyNine() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] change = {10, 10, 5, 2, 2};
        assertThat(coffeeMachine.changes(50, 21), is(change));
    }

    @Test
    public void whenChangeError() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] change = {};
        assertThat(coffeeMachine.changes(50, 100), is(change));
    }
}
