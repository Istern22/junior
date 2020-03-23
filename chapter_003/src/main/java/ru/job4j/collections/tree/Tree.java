package ru.job4j.collections.tree;

import java.util.*;

class Tree<E> implements SimpleTree<E>, Iterable {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    public boolean isBinary() {
        var isBinary = true;
        var it = iterator();
        while (it.hasNext() && isBinary) {
            isBinary = it.next().children.size() <= 2;
        }
        return isBinary;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        var parentNode = findBy(parent);
        var childNode = findBy(child);
        if (parentNode.isPresent() && !childNode.isPresent()) {
            parentNode.get().children.add(new Node<E>(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public Iterator<Node<E>> iterator() {

        return new Iterator() {

            private Queue<Node<E>> data = new LinkedList<>(Arrays.asList(root));

            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            @Override
            public Node<E> next() {
                var node = data.poll();
                data.addAll(node.children);
                return node;
            }
        };
    }
}
