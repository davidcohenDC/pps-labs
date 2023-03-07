package e1;

public abstract class AbstractPawn implements Pawn{

    protected Pair<Integer,Integer> position;

    public AbstractPawn(Pair<Integer,Integer> position) {
        this.position = position;
    }

    @Override
    public void move() {
        if(this.canMove()) {
            this.onMove();
        }
    }

    @Override
    public Pair<Integer, Integer> position() {
        return this.position;
    }

    protected abstract boolean canMove();

    protected abstract void onMove();


}
