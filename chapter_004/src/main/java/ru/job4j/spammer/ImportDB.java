package ru.job4j.spammer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties config;
    private String dump;

    public ImportDB(Properties config, String dump) {
        this.config = config;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dump))) {
            reader.lines().forEach(x -> {
                String[] lines = x.split(";");
                users.add(new User(lines[0], lines[1]));
            });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(config.getProperty("jdbc.driver"));
        try (Connection cn = DriverManager.getConnection(
                config.getProperty("jdbc.url"),
                config.getProperty("jdbc.username"),
                config.getProperty("jdbc.password"))) {
            for (User user : users) {
                try (PreparedStatement statement = cn.prepareStatement("INSERT INTO spammer (name, email) VALUES (?, ?)")) {
                    statement.setString(1, user.name);
                    statement.setString(2, user.email);
                    statement.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (FileInputStream in = new FileInputStream("./chapter_004/src/main/resources/app.properties")) {
            config.load(in);
        }
        ImportDB db = new ImportDB(config, "./chapter_004/src/main/resources/dump.txt");
        db.save(db.load());
    }
}
