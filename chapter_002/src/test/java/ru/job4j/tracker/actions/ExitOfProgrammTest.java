package ru.job4j.tracker.actions;

import org.junit.Test;
import ru.job4j.tracker.StubInput;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExitOfProgrammTest {

    @Test
    public void exitOfProgrammTestClassTest() {
        boolean expect = new ExitOfProgramm(1, "")
                .execute(new StubInput(new String[] {" "}), new Tracker());
        assertThat(expect, is(false));
    }
}