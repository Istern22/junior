package ru.job4j.storage;

import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;

@ThreadSafe
public class UserStorage {

    private HashMap<Integer, Integer> users = new HashMap<>();

    public synchronized boolean add(User user) {
        Integer add = users.putIfAbsent(user.getId(), user.getAmount());
        return add != null;
    }

    public synchronized boolean update(User user) {
        Integer update = users.put(user.getId(), user.getAmount());
        return update != null;
    }

    public synchronized boolean delete(User user) {
        Integer remove = users.remove(user.getId());
        return remove != null;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        if (users.containsKey(fromId)
                && users.containsKey(toId)
                && users.get(fromId) >= amount) {
            users.put(fromId, users.get(fromId) - amount);
            users.put(toId, users.get(toId) + amount);
            return true;
        }
        return false;
    }

    public synchronized HashMap<Integer, Integer> getUsers() {
        return users;
    }
}
