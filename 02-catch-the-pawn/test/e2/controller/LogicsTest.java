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

    private final Pair<Integer,Integer> FLAG_POSITION = new Pair<>(1,0);

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

//    @Test
//    void testToggleFlag() {
//        assertFalse(this.logics.isFlag(FLAG_POSITION));
//        this.logics.toggleFlag(FLAG_POSITION);
//        assertTrue(this.logics.isFlagged(FLAG_POSITION));
//    }
    @Test
    void testIsFlag() {
        assertFalse(this.logics.isFlag(FLAG_POSITION));
    }
}
