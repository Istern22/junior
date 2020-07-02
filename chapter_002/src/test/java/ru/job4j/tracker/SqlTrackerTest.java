package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    /*public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    @Test
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("testName", "testDesc"));
            assertThat(tracker.findByName("testName").size(), is(1));
        }
    }

    @Test
    public void updateItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("testName", "testDesc"));
            String id = tracker.findAll().get(0).getId();
            tracker.replace(id, new Item("newTestName", "newTestDesc"));
            assertThat(tracker.findByName("newTestName").size(), is(1));
        }
    }

    @Test
    public void deleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("testName", "testDesc"));
            String id = tracker.findAll().get(0).getId();
            tracker.delete(id);
            assertThat(tracker.findByName("newTestName").size(), is(0));
        }
    }

    @Test
    public void findByName() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("testName", "testDesc0"));
            tracker.add(new Item("testName", "testDesc1"));
            tracker.add(new Item("testName", "testDesc2"));
            assertThat(tracker.findByName("testName").size(), is(3));
        }
    }

    @Test
    public void findAllItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("testName0", "testDesc0"));
            tracker.add(new Item("testName1", "testDesc1"));
            tracker.add(new Item("testName2", "testDesc2"));
            assertThat(tracker.findAll().size(), is(3));
        }
    }

    @Test
    public void findById() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("testName0", "testDesc0"));
            String id = tracker.findAll().get(0).getId();
            assertThat(tracker.findById(id).getName(), is("testName0"));
        }
    }*/
}