package e1.components.pawn;

import e1.model.elements.position.CartesianPosition;
import e1.model.elements.position.CartesianPositionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class KnightTest extends PawnTest{

    @BeforeEach
    void setUp() {
        super.initFactory();
        this.pawn = this.pawnFactory.knight(position);
    }
    @Test
    void testSimpleMovement() {
        CartesianPosition<Integer> newPosition = new CartesianPositionImpl(X+1,Y+2);
        assertTrue(this.pawn.move(newPosition));
        assertEquals(this.pawn.position(),newPosition);
    }
}
