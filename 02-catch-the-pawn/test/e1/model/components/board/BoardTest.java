package e1.model.components.board;

import e1.model.components.pawn.Pawn;
import e1.model.components.pawn.PawnFactoryImpl;
import e1.model.elements.position.CartesianPosition;
import e1.model.elements.position.CartesianPositionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    protected Board board;

    protected final CartesianPosition<Integer> pawnPosition = new CartesianPositionImpl(0,0);

    protected final CartesianPosition<Integer> knightPosition = new CartesianPositionImpl(1,2);

    protected final static int SIZE = 4;

    protected final Pawn simplePawn = new PawnFactoryImpl().simplePawn(pawnPosition);

    protected final Pawn knightPawn = new PawnFactoryImpl().knight(knightPosition);

    @BeforeEach
    void initBoard() {
        List<Pawn> pawns = new ArrayList<>();
        pawns.add(simplePawn);
        pawns.add(knightPawn);
        this.board = new BoardImpl(SIZE, pawns);
    }

    @Test
    void testMovePawn() {
        assertEquals(Optional.empty(),this.board.movePawn(simplePawn,pawnPosition));
        this.board.movePawn(simplePawn,knightPosition).ifPresent( it -> {
            assertEquals(knightPawn,it);
        });
    }

    @Test
    void testPawnByPosition() {
        this.board.getPawnByPosition(knightPosition).ifPresent( it -> {
            assertEquals(knightPawn, it);
        });

        this.board.getPawnByPosition(pawnPosition).ifPresent( it -> {
            assertEquals(simplePawn, it);
        });
    }
}
