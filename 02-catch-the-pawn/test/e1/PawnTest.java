package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

abstract class PawnTest {

    protected Pawn pawn;

    protected final static Pair<Integer,Integer> INITIAL_POSITION = new Pair<>(0,0);

    @Test
    void testInitialPosition() {
        assertEquals(INITIAL_POSITION,this.pawn.position());
    }

}
