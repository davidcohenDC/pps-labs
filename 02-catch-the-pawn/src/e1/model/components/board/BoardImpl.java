package e1.model.components.board;

import e1.model.components.pawn.Pawn;
import e1.model.elements.position.CartesianPosition;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BoardImpl extends AbstractBoard {

    public BoardImpl(List<Pawn> pawns) {
        super(pawns);
    }

    @Override
    public Optional<Pawn> getPawnByPosition(CartesianPosition<Integer> position) {
        return this.pawns.stream().filter(pawn -> pawn.position().getX() == position.getX() && pawn.position().getY() == position.getY()).findFirst();
    }

    @Override
    public Optional<Pawn> movePawn(Pawn pawn, CartesianPosition<Integer> position) {
        Optional<Pawn> pawnToRemove = this.getPawnByPosition(position);
        if(pawn.move(position)) {   //the pawn move
            if(pawnToRemove.isPresent()) {  //other pawn was in that position
                this.pawns.remove(pawnToRemove.get());  //remove
                return pawnToRemove;    //and return
            }
        }
        return Optional.empty();
    }
}
