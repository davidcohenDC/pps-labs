package e1.model.components.pawn;

import e1.model.elements.position.CartesianPosition;
import e1.model.elements.position.CartesianPositionImpl;
import e1.model.utils.PAWN_TYPE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimplePawnTest extends PawnTest{

    private final static int X_MOVEMENT = 1;
    private final static int Y_MOVEMENT = 0;

    @BeforeEach
    void setUp() {
        super.initFactory();
        this.pawn = this.pawnFactory.simplePawn(position);
    }

    @Test
    void testSimpleMovement() {
        CartesianPosition<Integer> newPosition = new CartesianPositionImpl(X+X_MOVEMENT,Y+Y_MOVEMENT);
        assertTrue(this.pawn.move(newPosition));
        assertEquals(this.pawn.position(),newPosition);
    }

    @Test
    void testGetType() {
        assertEquals(PAWN_TYPE.PAWN,this.pawn.getType());
    }
}
