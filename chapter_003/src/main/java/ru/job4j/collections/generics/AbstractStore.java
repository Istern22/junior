package ru.job4j.collections.generics;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> data;

    @Override
    public void add(T model) {
        if (data == null) {
            data = new SimpleArray<>();
        }
        data.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        var index = 0;
        var it = data.iterator();
        while (it.hasNext()) {
            it.next();
            if (data.get(index).getId().equals(id)) {
                data.set(index, model);
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        var index = 0;
        var it = data.iterator();
        while (it.hasNext()) {
            it.next();
            if (data.get(index).getId().equals(id)) {
                data.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        T result;
        var it = data.iterator();
        while (it.hasNext()) {
            result = (T) it.next();
            if (result.getId().equals(id)) {
                return result;
            }
        }
        return null;
    }
}
