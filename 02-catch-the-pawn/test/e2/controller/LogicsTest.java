package e2.controller;

import e2.Pair;
import e2.model.board.Board;
import e2.model.board.BoardImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {

    private static final int SIZE = 5;
    private static final int MINES = 3;

    private Logics logics;

    private Board board;


    @BeforeEach
    void setUp() {
        this.board = new BoardImpl(SIZE,MINES);
        this.logics = new LogicsImpl(this.board);
    }

    @Test
    void testHit() {
        for (Pair<Integer,Integer> mines: this.board.getMines()) {
            assertTrue(this.logics.isMine(mines));
        }
    }

    @Test
    void testFlag() {
        Pair<Integer,Integer> position = new Pair<>(0,0);
        this.logics.flag(position);
    }
}
