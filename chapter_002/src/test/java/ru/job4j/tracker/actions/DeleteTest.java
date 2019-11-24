package ru.job4j.tracker.actions;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.StubInput;
import ru.job4j.tracker.Tracker;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DeleteTest {

    @Test
    public void deleteItemActionClassTest() {
        // Подгатовка
        Tracker example = new Tracker();
        Item first = new Item("one");
        Item second = new Item("two");
        Item third = new Item("three");
        // Основной блок
        example.add(first);
        example.add(second);
        example.add(third);

        ArrayList<Item> test = new ArrayList();
        test.add(first);
        test.add(third);

        // Действие
        new Delete(1, "").execute(new StubInput(new String[] {second.getId() }), example);

        assertThat(example.findAll(), is(test));
    }
}