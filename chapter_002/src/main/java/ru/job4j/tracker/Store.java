package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public interface Store extends AutoCloseable {
    void init();
    Item add(Item item) throws SQLException;
    boolean replace(String id, Item item) throws SQLException;
    boolean delete(String id) throws SQLException;
    List<Item> findAll() throws SQLException;
    List<Item> findByName(String key) throws SQLException;
    Item findById(String id) throws SQLException;
}