package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {
    private SimpleLinkedList<Integer> list;
    private Iterator iterator;

    @Before
    public void setUp() {
        list = new SimpleLinkedList<>();
        list.add(1); // third  - 2
        list.add(2); // second - 1
        list.add(3); // first  - 0
        iterator = list.iterator();
    }

    @Test
    public void add() {
        assertThat(list.getSize(), is(3));
    }
    @Test
    public void get() {
        assertThat(list.get(1), is(2));
    }
    @Test
    public void delete() {
        assertThat(list.delete(), is(3));
    }
    @Test
    public void addAll() {
        list.addAll(List.of(4, 5, 6, 7, 8, 9));
        assertThat(list.getSize(), is(9));
    }

    @Test
    public void iteratorHasNext() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }
    @Test
    public void iteratorNext() {
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(1));
    }

}