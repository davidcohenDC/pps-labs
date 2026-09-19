package e1.model.components.board;

import e1.model.components.pawn.Pawn;
import e1.model.elements.position.CartesianPosition;
import java.util.Optional;

/**
 * The Board used for maintain the status of game pawns
 */
public interface Board {

    /**
     * Get the pawn by {@link CartesianPosition}
     * @param position of the pawn
     * @return the pawn if exist
     */
    Optional<Pawn> getPawnByPosition(CartesianPosition<Integer> position);

    /**
     * Move the pawn to desire position
     * @param pawn to move
     * @param position to go
     * @return the consumed {@link Pawn} if exist
     */
    Optional<Pawn> movePawn(Pawn pawn, CartesianPosition<Integer> position);
}
