package e1;

public abstract class AbstractPawn implements Pawn{

    protected Pair<Integer,Integer> position;

    @Override
    public void move() {
        if(this.canMove()) {
            this.onMove();
        }
    }

    protected abstract boolean canMove();

    protected abstract void onMove();


}
