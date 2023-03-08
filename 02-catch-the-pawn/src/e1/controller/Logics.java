package e1.controller;

import e1.model.components.pawn.Pawn;
import e1.model.elements.position.CartesianPosition;

public interface Logics{
    boolean hit(Pawn pawn, CartesianPosition<Integer> position);
}
