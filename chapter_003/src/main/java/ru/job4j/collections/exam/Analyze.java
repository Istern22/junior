package ru.job4j.collections.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Analyze {

    public Info diff(List<User> previous, List<User> current) {
        int deleted = 0;
        for (var userPrev : previous) {
            if (!current.contains(userPrev)) {
                deleted++;
            }
        }
        int added = 0;
        for (var userCurr : current) {
            if (!previous.contains(userCurr)) {
                added++;
            }
        }
        int changed = 0;
        return new Info(added, changed, deleted);
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            User user = (User) obj;
            return this.id == this.getId()
                    && this.name.equals(user.getName());
        }

        @Override
        public String toString() {
            return id + " " + name.toString();
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }
}