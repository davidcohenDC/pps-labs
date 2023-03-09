package e2;

import e2.model.Board;
import e2.model.BoardImpl;
import org.junit.jupiter.api.BeforeEach;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        this.board = new BoardImpl();
    }
}
