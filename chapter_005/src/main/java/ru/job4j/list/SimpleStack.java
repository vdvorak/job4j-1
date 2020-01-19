package ru.job4j.list;

public class SimpleStack<T> {
    private int size = 0;

    private SimpleLinkedList<T> collection = new SimpleLinkedList<>();

    public void push(T value) {
        collection.add(value);
        this.size++;
    }

    public T poll() {
        this.size--;
        return collection.delete();
    }
    public T peek() {
        this.size--;
        return collection.get(size);
    }
    public int getSize() {
        return this.size;
    }

}