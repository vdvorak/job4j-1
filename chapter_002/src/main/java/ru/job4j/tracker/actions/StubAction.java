package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

/**
 * Заглушка - Имитация действий для tracker.items
 * Нужна для тестов
 * @author Daniils Loputevs
 * @version $Id$
 * @since 25.10.19
 **/

public class StubAction extends BaseAction {
    /**
     * переменная отвечает за вызов метода, если он был вызван, то call >> = true
     */
    private boolean call; // по умолчанию должна быть false;

    public StubAction(int key, String name, boolean call) {
        super(key, name);
        this.call = call;
    }


    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}