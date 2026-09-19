package e1.model.components.pawn;

import e1.model.elements.position.CartesianPosition;
import e1.model.elements.position.CartesianPositionImpl;
import e1.model.utils.PAWN_TYPE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class KnightTest extends PawnTest{

    private final static int X_MOVEMENT = 1;
    private final static int Y_MOVEMENT = 2;

    @BeforeEach
    void setUp() {
        super.initFactory();
        this.pawn = this.pawnFactory.knight(position);
    }
    @Test
    void testSimpleMovement() {
        CartesianPosition<Integer> newPosition = new CartesianPositionImpl(X+X_MOVEMENT,Y+Y_MOVEMENT);
        assertTrue(this.pawn.move(newPosition));
        assertEquals(this.pawn.position(),newPosition);
    }

    @Test
    void testGetType() {
        assertEquals(PAWN_TYPE.KNIGHT,this.pawn.getType());
    }
}
