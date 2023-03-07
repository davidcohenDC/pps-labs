package e1.components.pawn;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest extends PawnTest{

    @BeforeEach
    void setUp() {
        super.initFactory();
        this.pawn = this.pawnFactory.knight();
    }
    @Test
    void testSimpleMovement() {
        Pair<Integer,Integer> position = new Pair<>(this.pawn.position().getX()+1,this.pawn.position().getY()+2);
        assertTrue(this.pawn.move(position.getX(),position.getY()));
        assertEquals(this.pawn.position(),position);
    }
}
