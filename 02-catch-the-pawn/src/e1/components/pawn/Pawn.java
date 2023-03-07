package e1.components.pawn;

import e1.components.position.CartesianPosition;

public interface Pawn {

    boolean move(CartesianPosition<Integer> position);

    CartesianPosition<Integer> position();
}
