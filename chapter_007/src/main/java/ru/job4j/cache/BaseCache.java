package ru.job4j.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BaseCache {

    private ConcurrentHashMap<Integer, Base> map = new ConcurrentHashMap<>();

    public void add(Base model) {
        map.put(model.getId(), model);
    }

    public Base get(int id) {
        return map.get(id);
    }

    public void update(Base model) {
        map.computeIfPresent(model.getId(),
                (id, item) -> {
            int current = model.getVersion();
            if (item.getVersion() != current) {
                throw new OptimisticException();
            }
            model.setVersion(++current);
            return model;
        });
    }

    public boolean delete(Base model) {
        Base item = map.remove(model.getId());
        return item != null;
    }
}
