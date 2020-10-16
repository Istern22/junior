package ru.job4j.solid.isp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MenuTreeTest {

    protected final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

   @Test
    public void whenCreateTwoLevelMenu() {
        Menu menu = new Menu("Edit", "File", "View");
        menu.add("File", "Open", "Close");
        menu.show();
        assertThat(output.toString(), is("Menu\r\nEdit\r\nFile\r\n-Close\r\n-Open\r\nView\r\n"));
    }

    @Test
    public void whenCreateThreeLevelMenu() {
        Menu menu = new Menu("Edit", "File", "View");
        menu.add("File", "Open", "Close");
        menu.add("Open", "Open Recent");
        menu.add("View", "Appearance");
        menu.show();
        assertThat(output.toString(), is("Menu\r\n"
                + "Edit\r\n"
                + "File\r\n"
                + "-Close\r\n"
                + "-Open\r\n"
                + "--Open Recent\r\n"
                + "View\r\n"
                + "-Appearance\r\n"));
    }

    @Test
    public void whenCreateFourLevelMenu() {
        Menu menu = new Menu("Edit", "File", "View");
        menu.add("File", "Open", "Close");
        menu.add("Open", "Open Recent");
        menu.add("View", "Appearance");
        menu.add("Open Recent", "One day old", "One month old");
        menu.show();
        assertThat(output.toString(), is("Menu\r\n"
                + "Edit\r\n"
                + "File\r\n"
                + "-Close\r\n"
                + "-Open\r\n"
                + "--Open Recent\r\n"
                + "---One month old\r\n"
                + "---One day old\r\n"
                + "View\r\n"
                + "-Appearance\r\n"));
    }
}