package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.function.Predicate;

public class SqlTracker implements Store {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedInsert = cn.prepareStatement(
                "INSERT INTO tracker (name, description) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedInsert.setString(1, item.getName());
            preparedInsert.setString(2, item.getDesc());
            preparedInsert.executeUpdate();
            try (ResultSet keys = preparedInsert.getGeneratedKeys()) {
                if (keys.next()) {
                    item.setId(keys.getString(1));
                }
            } catch (SQLException s) {
                s.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement preparedUpdate = cn.prepareStatement(
                "UPDATE tracker SET name = ?, description = ? WHERE id = ?")) {
            preparedUpdate.setString(1, item.getName());
            preparedUpdate.setString(2, item.getDesc());
            preparedUpdate.setInt(3, Integer.parseInt(id));
            if (preparedUpdate.executeUpdate() == 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement preparedDelete = cn.prepareStatement(
                "DELETE FROM tracker WHERE id = ?")) {
            preparedDelete.setInt(1, Integer.parseInt(id));
            if (preparedDelete.executeUpdate() == 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList();
        try (ResultSet resultSet = cn.createStatement().executeQuery("SELECT * FROM tracker;")) {
            while (true) {
                if (resultSet.next()) {
                    String resultId = resultSet.getString("id");
                    String resultName = resultSet.getString("name");
                    String resultDesc = resultSet.getString("description");
                    result.add(new Item(resultId, resultName, resultDesc));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {

        List<Item> result = new ArrayList();
        try (PreparedStatement preparedSelect = cn.prepareStatement(
                "SELECT * FROM tracker WHERE name = ?")) {
            preparedSelect.setString(1, key);
            try (ResultSet resultSet = preparedSelect.executeQuery()) {
                while (true) {
                    if (resultSet.next()) {
                        String resultId = resultSet.getString("id");
                        String resultName = resultSet.getString("name");
                        String resultDesc = resultSet.getString("description");
                        result.add(new Item(resultId, resultName, resultDesc));
                    } else {
                        break;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(String id) {

        Item result = null;

        try (PreparedStatement preparedSelect = cn.prepareStatement(
                "SELECT * FROM tracker WHERE id = ?")) {
            preparedSelect.setInt(1, Integer.parseInt(id));
            try (ResultSet resultSet = preparedSelect.executeQuery()) {
                if (resultSet.next()) {
                    String resultName = resultSet.getString("name");
                    String resultDesc = resultSet.getString("description");
                    result = new Item(id, resultName, resultDesc);
                }
            } catch (SQLException s) {
                s.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result == null ? null : result;
    }
}