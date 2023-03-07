package e1.components.pawn;

import e1.model.elements.position.CartesianPosition;
import e1.model.elements.position.CartesianPositionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimplePawnTest extends PawnTest{


    @BeforeEach
    void setUp() {
        super.initFactory();
        this.pawn = this.pawnFactory.simplePawn(position);
    }

    @Test
    void testSimpleMovement() {
        CartesianPosition<Integer> newPosition = new CartesianPositionImpl(X+1,Y);
        assertTrue(this.pawn.move(newPosition));
        assertEquals(this.pawn.position(),newPosition);
    }
}
