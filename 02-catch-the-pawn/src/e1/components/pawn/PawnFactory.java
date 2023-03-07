package e1.components.pawn;


import e1.components.position.CartesianPosition;

public interface PawnFactory {

    Pawn simplePawn(CartesianPosition<Integer> position);

    Pawn knight(CartesianPosition<Integer> position);
}
