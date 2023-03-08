package e1.controller;

import e1.model.components.board.Board;
import e1.model.components.board.BoardImpl;
import e1.model.components.pawn.Pawn;
import e1.model.elements.position.CartesianPosition;
import e1.model.utils.PAWN_TYPE;
import java.util.LinkedList;
import java.util.Optional;

public class CatchThePawn implements Logics{
    private final Board board;
    private final PAWN_TYPE pawnToCatch;

    public CatchThePawn(int size, LinkedList<Pawn> pawns, PAWN_TYPE pawnToCatch) {
        this.board = new BoardImpl(size,pawns);
        this.pawnToCatch = pawnToCatch;
    }

    @Override
    public boolean hit(Pawn pawn, CartesianPosition<Integer> position) {
        Optional<Pawn> catchPawn = this.board.movePawn(pawn, position);
        return catchPawn.filter(cpawn -> cpawn.getType() == pawnToCatch).isPresent();
    }
}

//        board.getPawn(pawnType).ifPresent(value -> value.move(position));
//        return board.knock(pawnToCatch,position);