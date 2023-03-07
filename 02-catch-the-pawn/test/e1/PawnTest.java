package e1;

import e1.components.pawn.Pawn;
import e1.components.pawn.PawnFactory;
import e1.components.pawn.PawnFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

abstract class PawnTest {

    protected Pawn pawn;

    protected PawnFactory pawnFactory;

    protected final static Pair<Integer,Integer> INITIAL_POSITION = new Pair<>(0,0);

    @BeforeEach
    void initFactory() {
        this.pawnFactory = new PawnFactoryImpl();
    }

    @Test
    void testInitialStaticPosition() {
        assertEquals(INITIAL_POSITION,this.pawn.position());
    }
}
