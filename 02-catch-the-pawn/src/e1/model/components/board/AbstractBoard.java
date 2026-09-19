package e1.model.components.board;

import e1.model.components.pawn.Pawn;
import java.util.List;

public abstract class AbstractBoard implements Board {

    protected List<Pawn> pawns;

    public AbstractBoard(List<Pawn> pawns) {
        this.pawns = pawns;
    }

}
