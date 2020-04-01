package ru.job4j.collections.tree;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void when6ElWithDuplicatesFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(2, 2);
        assertThat(tree.findBy(1).isPresent(), is(true));
        assertThat(tree.findBy(2).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void whenAddThenBinary() {
        var tree = new Tree<>(0);
        tree.add(0, 1);
        tree.add(0, 2);
        tree.add(1, 4);
        tree.add(1, 5);
        tree.add(5, 6);
        assertThat(tree.isBinary(), is(true));
    }
    @Test
    public void whenAddThenNotBinary() {
        var tree = new Tree<>(0);
        tree.add(0, 1);
        tree.add(0, 2);
        tree.add(1, 4);
        tree.add(1, 5);
        tree.add(5, 6);
        tree.add(5, 7);
        tree.add(5, 8);
        assertThat(tree.isBinary(), is(false));
    }
}