package ru.job4j.collections.list;

public class SimpleQueue<T> {

    SimpleStack<T> stack1 = new SimpleStack<>();
    SimpleStack<T> stack2 = new SimpleStack<>();

    public void push(T value) {
        stack1.push(value);
    }

    public T poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.poll());
            }
        }
        return stack2.poll();
    }
}
