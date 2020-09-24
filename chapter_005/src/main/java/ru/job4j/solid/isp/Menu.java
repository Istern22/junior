package ru.job4j.solid.isp;

import javax.swing.*;
import java.util.*;

public class Menu implements Iterable {

    private Item root;

    public Menu(String ... data) {
        this.root = new Item("Menu");
        for (var item : data) {
            Item it = new Item(item);
            this.root.children.add(it);
        }
    }

    public boolean add(String parent, String ... children) {
        boolean result = false;
        var parentItem = find(parent);
        if (parentItem.data != null) {
            for (var child : children) {
                Item add = new Item(child);
                add.level = parentItem.level + "-";
                parentItem.children.add(add);
                result = true;
            }
        }
        return result;
    }

    public Item find(String name) {
        Item result = null;
        Queue<Item> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Item item = data.poll();
            if (item.data.equals(name)) {
                result = item;
                break;
            }
            data.addAll(item.children);
        }
        return result;
    }

    public void show()  {
        Iterator it = iterator();
        while (it.hasNext()) {
            Menu.Item item = (Menu.Item) it.next();
            System.out.print(item.getLevel() + item.getData() + "\r\n");
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            private LinkedList<Item> data = new LinkedList<>(Arrays.asList(root));

            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            @Override
            public Item next() {
                var item = data.poll();
                if (item.data.equals("Menu")) {
                    data.addAll(item.children);
                } else {
                    for (var child : item.children) {
                        data.add(0, child);
                    }
                }
                return item;
            }
        };
    }

    public class Item {

        private String data;
        private String level;
        private ArrayList<Item> children = new ArrayList<>();
        private Action action;

        public Item(String data) {
            this.data = data;
            level = "";
        }

        public String getData() {
            return data;
        }

        public String getLevel() {
            return level;
        }

        public Action getAction() {
            return action;
        }
    }
}
