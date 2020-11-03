package ru.job4j;

import org.junit.Test;
import ru.job4j.storage.User;
import ru.job4j.storage.UserStorage;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {

    @Test
    public void whenTransferSuccess() {
        UserStorage storage = new UserStorage();
        storage.add(new User(1, 100));
        storage.add(new User(2, 200));
        storage.transfer(1, 2, 50);
        assertThat(storage.getUsers().get(1), is(50));
        assertThat(storage.getUsers().get(2), is(250));
    }
}