package e1;

import e1.components.pawn.Pawn;
import e1.components.pawn.PawnFactory;
import e1.components.pawn.PawnFactoryImpl;
import e1.components.position.Position;
import e1.components.position.TwoDimensionalPositionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class PawnTest {

    private static final int X = 0;
    private static final int Y = 0;


    protected Pawn pawn;

    protected PawnFactory pawnFactory;

    protected final Position initialPosition = new TwoDimensionalPositionImpl(X,Y);

    @BeforeEach
    void initFactory() {
        this.pawnFactory = new PawnFactoryImpl();
    }

    @Test
    void testInitialStaticPosition() {
        assertEquals(initialPosition.getCoordinates(),this.pawn.position());
    }
}
