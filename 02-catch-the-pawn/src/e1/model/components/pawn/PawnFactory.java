package e1.model.components.pawn;


import e1.model.elements.position.CartesianPosition;

public interface PawnFactory {

    Pawn simplePawn(CartesianPosition<Integer> position);

    Pawn knight(CartesianPosition<Integer> position);
}
