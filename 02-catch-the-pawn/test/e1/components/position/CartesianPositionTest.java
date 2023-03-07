package e1.components.position;

import e1.model.elements.Pair;
import e1.model.elements.position.CartesianPosition;
import e1.model.elements.position.CartesianPositionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartesianPositionTest {

    private static final int X = 0;

    private static final int Y = 0;

    private CartesianPosition<Integer> twoDimensionalPosition;

    @BeforeEach
    void setUp() {
        this.twoDimensionalPosition = new CartesianPositionImpl(X,Y);
    }

    @Test
    void testGetCoordinate() {
        assertEquals(new Pair<>(X,Y),this.twoDimensionalPosition.getCoordinates());
    }

    @Test
    void testGetX() {
        assertEquals(X,this.twoDimensionalPosition.getX());
    }

    @Test
    void testSetX() {
        this.twoDimensionalPosition.setX(2);
        assertEquals(2,this.twoDimensionalPosition.getX());
    }


    @Test
    void testGetY() {
        assertEquals(Y,this.twoDimensionalPosition.getX());
    }

    @Test
    void testSetY() {
        this.twoDimensionalPosition.setY(3);
        assertEquals(3,this.twoDimensionalPosition.getY());
    }

    @Test
    void testGetPairOfCoordinates() {
        assertEquals(new Pair<>(X,Y),this.twoDimensionalPosition.getCoordinates());
    }

}
