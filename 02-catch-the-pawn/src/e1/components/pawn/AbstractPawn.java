package e1.components.pawn;

import e1.Pair;

public abstract class AbstractPawn implements Pawn {

    protected Pair<Integer,Integer> position;

    public AbstractPawn(Pair<Integer,Integer> position) {
        this.position = position;
    }

    @Override
    public boolean move(int x, int y) {
        if(this.canMove(x,y)) {
            this.position = new Pair<>(x,y);
            return true;
        }
        return false;
    }

    @Override
    public Pair<Integer, Integer> position() {
        return this.position;
    }

    protected abstract boolean canMove(int x, int y);

}
