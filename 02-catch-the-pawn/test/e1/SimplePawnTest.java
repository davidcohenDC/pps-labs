package e1;

import org.junit.jupiter.api.BeforeEach;

public class SimplePawnTest extends PawnTest{

    @BeforeEach
    void setUp() {
        super.initFactory();
        this.pawn = this.pawnFactory.simplePawn();
    }
}
