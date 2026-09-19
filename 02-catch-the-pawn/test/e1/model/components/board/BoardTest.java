package e1.model.components.board;

import e1.controller.engine.AbstractEngine;
import e1.controller.engine.Engine;
import e1.controller.engine.EngineFactory;
import e1.controller.engine.EngineFactoryImpl;
import e1.model.components.pawn.Pawn;
import e1.model.components.pawn.PawnFactoryImpl;
import e1.model.elements.position.CartesianPosition;
import e1.model.elements.position.CartesianPositionImpl;
import e1.model.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    protected Board board;
    protected final static int X_PAWN = 0;
    protected final static int Y_PAWN = 0;
    protected final static int X_KNIGHT = 1;
    protected final static int Y_KNIGHT = 2;
    protected final CartesianPosition<Integer> pawnPosition = new CartesianPositionImpl(X_PAWN,Y_PAWN);
    protected final CartesianPosition<Integer> knightPosition = new CartesianPositionImpl(X_KNIGHT,Y_KNIGHT);

    @BeforeEach
    void initBoard() {
        this.board = new BoardImpl(new AbstractEngine(Constants.SIZE) {
            @Override
            protected List<Pawn> populatePawns(Callable<CartesianPosition<Integer>> randomEngine){
                return new ArrayList<>(List.of(
                        new PawnFactoryImpl().simplePawn(pawnPosition),
                        new PawnFactoryImpl().knight(knightPosition)));
            }
        }.generate());
    }


    @Test
    void testMovePawn() {
        this.board.getPawnByPosition(knightPosition).ifPresentOrElse( knight -> {
            this.board.getPawnByPosition(pawnPosition).ifPresentOrElse(pawn -> {
                assertEquals(Optional.empty(), this.board.movePawn(pawn, pawnPosition));
                assertEquals(Optional.of(pawn),this.board.movePawn(knight, pawnPosition));
            }, Assertions::fail);
        }, Assertions::fail);
    }


    @Test
    void testPawnByPosition() {
        this.board.getPawnByPosition(knightPosition).ifPresentOrElse( knight -> {
            this.board.getPawnByPosition(pawnPosition).ifPresentOrElse(pawn -> {
                assertEquals(Optional.empty(),this.board.getPawnByPosition(new CartesianPositionImpl(X_KNIGHT,Y_PAWN)));
            }, Assertions::fail);
        }, Assertions::fail);
    }
}
