package ru.job4j.collections.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class StoreTest {
    @Test
    public void whenCreateUserStoreAndFillIt() {
        UserStore userStore = new UserStore();
        userStore.add(new User("000"));
        userStore.add(new User("001"));
        userStore.add(new User("002"));
        userStore.add(new User("003"));
        userStore.add(new User("004"));
        userStore.add(new User("005"));
        assertThat(userStore.findById("001"), is(new User("001")));
        assertThat(userStore.findById("005"), is(new User("005")));
    }

    @Test
    public void whenCreateUserStoreAndReplaceIt() {
        UserStore userStore = new UserStore();
        userStore.add(new User("000"));
        userStore.add(new User("001"));
        userStore.add(new User("002"));
        userStore.add(new User("003"));
        userStore.add(new User("004"));
        userStore.add(new User("005"));
        userStore.replace("001", new User("111"));
        userStore.replace("005", new User("555"));
        assertThat(userStore.findById("111"), is(new User("111")));
        assertThat(userStore.findById("555"), is(new User("555")));
        assertThat(userStore.replace("111", new User("999")), is(true));
        assertThat(userStore.replace("556", new User("666")), is(false));
    }

    @Test
    public void whenCreateUserStoreAndDeleteIt() {
        UserStore userStore = new UserStore();
        userStore.add(new User("000"));
        userStore.add(new User("001"));
        userStore.add(new User("002"));
        userStore.add(new User("003"));
        userStore.add(new User("004"));
        userStore.add(new User("005"));
        userStore.delete("005");
        assertThat(userStore.findById("005"), is(nullValue()));
        userStore.delete("000");
        assertThat(userStore.findById("000"), is(nullValue()));
        assertThat(userStore.delete("001"), is(true));
        assertThat(userStore.delete("010"), is(false));
    }
}
