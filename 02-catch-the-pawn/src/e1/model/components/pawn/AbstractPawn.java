package e1.model.components.pawn;

import e1.model.elements.position.CartesianPosition;
import e1.model.utils.PAWN_TYPE;

import java.util.Objects;

public abstract class AbstractPawn implements Pawn {

    protected PAWN_TYPE pawnType;
    protected CartesianPosition<Integer> actualPosition;

    public AbstractPawn(PAWN_TYPE pawnType, CartesianPosition<Integer> position) {
        this.pawnType = pawnType;
        this.actualPosition = position;
    }

    @Override
    public boolean move(CartesianPosition<Integer> position) {
        if(this.canMove(position)) {
            this.actualPosition.setCoordinates(position);
            return true;
        }
        return false;
    }

    @Override
    public PAWN_TYPE getType() {
        return this.pawnType;
    }

    @Override
    public CartesianPosition<Integer> position() {
        return this.actualPosition;
    }

    protected abstract boolean canMove(CartesianPosition<Integer> position);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPawn that)) return false;
        return pawnType == that.pawnType && Objects.equals(actualPosition, that.actualPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pawnType, actualPosition);
    }
}
