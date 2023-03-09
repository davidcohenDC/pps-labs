package e2;

import e1.model.elements.Pair;
import e2.model.Board;
import e2.model.BoardImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private static final int SIZE = 5;
    private static final int MINES = 3;
    private Board board;

    @BeforeEach
    void setUp() {
        this.board = new BoardImpl(SIZE,MINES);
    }

    @Test
    void testBoardSize() {
        assertEquals(SIZE, this.board.getSize());
    }

    @Test
    void testGetMineSize() {
        assertEquals(MINES, this.board.getMinesSize());
    }

    @Test
    void testGetMines() {
        assertTrue(this.board.getMines()
                .stream()
                .allMatch(mine -> mine.getX() <= SIZE && mine.getY() <= SIZE));
    }

    @Test
    void testNoDuplicateMines() {
        Set<Pair<Integer,Integer>> items = new HashSet<>();
        assertEquals(0,this.board.getMines()
                .stream()
                .filter(n -> !items.add(n))
                .collect(Collectors.toSet()).size());
    }
}
