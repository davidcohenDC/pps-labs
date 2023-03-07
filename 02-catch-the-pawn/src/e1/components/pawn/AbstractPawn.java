package e1.components.pawn;

import e1.components.position.CartesianPosition;

public abstract class AbstractPawn implements Pawn {

    protected CartesianPosition<Integer> actualPosition;

    public AbstractPawn(CartesianPosition<Integer> position) {
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
    public CartesianPosition<Integer> position() {
        return this.actualPosition;
    }

    protected abstract boolean canMove(CartesianPosition<Integer> position);

}
