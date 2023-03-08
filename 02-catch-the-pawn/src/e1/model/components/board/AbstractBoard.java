package e1.model.components.board;

import e1.model.components.pawn.Pawn;
import java.util.List;

public abstract class AbstractBoard implements Board {

    protected int size;
    protected List<Pawn> pawns;

    public AbstractBoard(int size, List<Pawn> pawns) {
        this.size = size;
        this.pawns = pawns;
    }

}
