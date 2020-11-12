package ru.job4j.cache;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class BaseCacheTest {

    @Test
    public void whenAdd() {
        BaseCache cache = new BaseCache();
        cache.add(new Base(0, 0, "name"));
        assertThat(cache.get(0), is(new Base(0, 0, "name")));
    }

    @Test
    public void whenDelete() {
        BaseCache cache = new BaseCache();
        cache.add(new Base(0, 0,  "name"));
        cache.delete(new Base(0, 0, "name"));
        assertThat(cache.get(0), is(nullValue()));
    }

    @Test
    public void whenUpdate() {
        BaseCache cache = new BaseCache();
        cache.add(new Base(0, 0,  "name"));
        cache.update(new Base(0, 0, "name1"));
        assertThat(cache.get(0), is(new Base(0,  1, "name1")));
    }

    @Test
    public void whenUpdateInThreeThreads() throws InterruptedException {
        BaseCache cache = new BaseCache();
        cache.add(new Base(0, 0,  "name"));
        Thread first = new Thread(
                () -> cache.update(new Base(0, 0,  "name1"))
        );
        Thread second = new Thread(
                () -> cache.update(new Base(0, 0,  "name2"))
        );
        Thread third = new Thread(
                () -> cache.update(new Base(0, 0,  "name3"))
        );
        second.start();
        first.start();
        third.start();
        second.join();
        first.join();
        third.join();
        assertThat(cache.get(0), is(new Base(0,  1, "name1")));
    }
}