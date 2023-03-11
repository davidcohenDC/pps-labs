package e2.model;

import e2.Pair;
import e2.model.board.Board;
import e2.model.board.BoardImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private static final int SIZE = 3;
    private static final int MINES = 2;

    private static final Pair<Integer,Integer> FIRST_CLICK = new Pair<>(0,0);
    private Board board;

    private final List<Pair<Integer,Integer>> cells = new ArrayList<>(
            List.of(new Pair<>(0,0),
            new Pair<>(0,1), new Pair<>(0,2), new Pair<>(1,1),
            new Pair<>(1,2), new Pair<>(2,0), new Pair<>(2,1)));

    private final List<Pair<Integer,Integer>> mines = new ArrayList<>(
            List.of(new Pair<>(2,1), new Pair<>(2,2)));

    private final List<Optional<Integer>> values = new ArrayList<>(
            List.of(Optional.of(0),Optional.of(0),Optional.of(0),
                    Optional.of(1),Optional.of(2),Optional.of(2),
                    Optional.of(1),Optional.empty(),Optional.empty()));

    private final List<Boolean> beforeTrigger = new ArrayList<>(
            List.of(false,false,false,false,false,false,false,false,false));

    private final List<Boolean> afterTrigger = new ArrayList<>(
            List.of(true,true,true,false,false,false,false,false,false));


    @BeforeEach
    void setUp() {
        this.board = new BoardImpl(SIZE,MINES);
    }

    @Test
    void testBoardSize() {
        assertEquals(SIZE*SIZE, this.board.getSize());
        this.board = new BoardImpl(SIZE, mines);
        assertEquals(SIZE*SIZE, this.board.getSize());
    }

    @Test
    void testGetMineSize() {
        assertEquals(MINES, this.board.getMinesSize());
        this.board = new BoardImpl(SIZE, mines);
        assertEquals(MINES, this.board.getMinesSize());
    }


    @Test
    void testMinesPositions() {
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

    @Test
    void testGetMines() {
        this.board = new BoardImpl(SIZE,this.mines);
        assertTrue(this.mines.containsAll(this.board.getMines()));
    }

    @Test
    void testGetGrid() {
        this.board = new BoardImpl(SIZE,this.mines);
        List<Pair<Integer,Integer>> grid = new ArrayList<>(this.mines);
        grid.addAll(this.cells);
        assertTrue(grid.containsAll(this.board.getGrid()));
    }

    @Test
    void testGetCells() {
        this.board = new BoardImpl(SIZE,this.mines);
        assertTrue(this.cells.containsAll(this.board.getCells()));
    }

    @Test
    void testGetValues() {
        this.board = new BoardImpl(SIZE,this.mines);
        assertTrue(this.values.containsAll(this.board.getBoxValues()));
    }

    @Test
    void testGetTriggers() {
        this.board = new BoardImpl(SIZE,this.mines);
        assertTrue(this.values.containsAll(this.board.getBoxValues()));
    }

    @Test
    void testActivateTrigger() {
        this.board = new BoardImpl(SIZE,this.mines);
        assertFalse(this.board.isTrigger(FIRST_CLICK));
        this.board.activateTrigger(FIRST_CLICK);
        assertTrue(this.board.isTrigger(FIRST_CLICK));
    }

    @Test
    void testTriggersAfterClick() {
        this.board = new BoardImpl(SIZE,this.mines);
        assertTrue(this.beforeTrigger.containsAll(this.board.getTriggers()));
        this.board.activateTrigger(FIRST_CLICK);
        assertTrue(this.afterTrigger.containsAll(this.board.getTriggers()));
    }
}
