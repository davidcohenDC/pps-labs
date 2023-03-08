package e1.model.components.pawn;

import e1.model.elements.position.CartesianPosition;
import e1.model.utils.PAWN_TYPE;

public interface Pawn {

    boolean move(CartesianPosition<Integer> position);

    CartesianPosition<Integer> position();

    PAWN_TYPE getType();
}
