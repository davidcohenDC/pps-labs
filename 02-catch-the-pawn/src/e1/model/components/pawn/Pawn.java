package e1.model.components.pawn;

import e1.model.elements.position.CartesianPosition;

public interface Pawn {

    boolean move(CartesianPosition<Integer> position);

    CartesianPosition<Integer> position();
}
