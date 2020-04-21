package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ShellTest {

    @Test
    public void whenChangeDirectoryInOneStep() {
        var shell = new Shell();
        shell.cd("/a/b/c/d/e");
        assertThat(shell.path(), is("/a/b/c/d/e"));
    }

    @Test
    public void whenChangeDirectoryInFourSteps() {
        var shell = new Shell();
        shell.cd("/a/b/c/d/e");
        shell.cd("..");
        shell.cd("./");
        shell.cd("..");
        assertThat(shell.path(), is("/a/b/c"));
    }

    @Test
    public void whenChangeDirectoryInTwoSteps() {
        var shell = new Shell();
        shell.cd("/a");
        shell.cd("..");
        assertThat(shell.path(), is("/"));
    }

    @Test
    public void whenChangeDirectoryInThreeSteps() {
        var shell = new Shell();
        shell.cd("/a");
        shell.cd("../c/d/e");
        shell.cd("./../../f/g/../h");
        assertThat(shell.path(), is("/c/f/h"));
    }

    @Test
    public void whenAbortCurrentDirectory() {
        var shell = new Shell();
        shell.cd("/a");
        shell.cd("//lib///");
        assertThat(shell.path(), is("/lib"));
    }
}