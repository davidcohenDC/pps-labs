package e2.controller;

import e2.model.board.BoardImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogicsTest {

    private static final int SIZE = 5;
    private static final int MINES = 3;

    Logics logics;


    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(new BoardImpl(SIZE,MINES));
    }

    @Test
    void test() {
        //TODO
    }
}
