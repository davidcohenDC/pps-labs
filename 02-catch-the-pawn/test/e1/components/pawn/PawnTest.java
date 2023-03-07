package e1.components.pawn;

import e1.components.position.CartesianPosition;
import e1.components.position.CartesianPositionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class PawnTest {

    protected static final int X = 0;
    protected static final int Y = 0;

    protected Pawn pawn;

    protected PawnFactory pawnFactory;

    protected final CartesianPosition<Integer> position = new CartesianPositionImpl(X,Y);

    @BeforeEach
    void initFactory() {
        this.pawnFactory = new PawnFactoryImpl();
    }

    @Test
    void testInitialStaticPosition() {
        assertEquals(position.getCoordinates(),this.pawn.position().getCoordinates());
    }
}
