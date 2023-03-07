package e1;

import org.junit.jupiter.api.BeforeEach;

public class SimplePawnTest extends PawnTest{

    @BeforeEach
    void setUp() {
        this.pawn = new AbstractPawn(INITIAL_POSITION) {
            @Override
            protected boolean canMove() {
                return true;
            };

            @Override
            protected void onMove() {

            }
        };
    }
}
