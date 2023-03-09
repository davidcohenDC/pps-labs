package e1.controller.logics;

import e1.model.components.board.Board;
import e1.model.components.board.BoardImpl;
import e1.model.components.pawn.Pawn;
import e1.model.elements.position.CartesianPosition;
import e1.model.utils.PAWN_TYPE;

import java.util.List;
import java.util.Optional;

public class CatchThePawnLogics implements Logics{
    private final PAWN_TYPE pawnToCatch;
    private final PAWN_TYPE pawnToMove;

    public CatchThePawnLogics(PAWN_TYPE pawnToCatch, PAWN_TYPE pawnToMove) {
        this.pawnToCatch = pawnToCatch;
        this.pawnToMove = pawnToMove;
    }

    @Override
    public boolean hit(Pawn catchPawn) {
        return catchPawn.getType() == pawnToCatch;
    }
}