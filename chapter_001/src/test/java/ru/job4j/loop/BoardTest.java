package ru.job4j.loop;

import org.junit.Test;

public class BoardTest {
    @Test
    public void board_3x3_String() {
        Board.paintString(3,3);
    }
    @Test
    public void board_5x5_String() {
        Board.paintString(5, 5);
    }
    @Test
    public void board_7x7_String() {
        Board.paintString(7,7);
    }

    @Test
    public void board_3x3() {
        Board.paint(3, 3);
    }
    @Test
    public void board_5x5() {
        Board.paint(5,5);
    }
    @Test
    public void board_7x7() {
        Board.paint(7, 7);
    }
}
