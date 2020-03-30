package ru.job4j.collections.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analyze {

    public Info difference(List<User> previous, List<User> current) {
        int deleted = 0;
        int changed = 0;
        var prevMap = previous.stream().collect(Collectors.toMap(User::getId, User::getName));
        var currMap = current.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (var prev : prevMap.entrySet()) {
            if (currMap.get(prev.getKey()) == null) {
                deleted++;
            } else if (!currMap.get(prev.getKey()).equals(prev.getValue())) {
                changed++;
            }
        }
        int added = currMap.size() - prevMap.size() + deleted;
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
            return this.id == user.getId()
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

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Info info = (Info) obj;
            return this.added == info.getAdded()
                    && this.changed == info.getChanged()
                    && this.deleted == info.getDeleted();
        }
    }

}