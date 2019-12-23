package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

/**
 * Создание заявки и добавление в tracker.items
 * @author Daniils Loputevs
 * @version $Id$
 * @since 23.12.19
 **/

public class Create extends BaseAction {

    public Create(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
//        output.accept("Enter name: "); // Если нужно вести текст вручную - v2
        tracker.add(new Item(input.askStr("")));
        System.out.println();
        return true;
    }
}