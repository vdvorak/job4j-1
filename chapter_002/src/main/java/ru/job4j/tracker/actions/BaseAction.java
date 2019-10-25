package ru.job4j.tracker.actions;

import ru.job4j.tracker.UserAction;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }
//
//    @Override
//    public int key() {
//        return this.key;
//    }
//
//    @Override
//    public String info() {
//        return String.format("%s : %s", this.key, this.name);
//    }
}