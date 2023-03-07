package e1;

public class PawnImpl extends AbstractPawn{

    public PawnImpl(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    protected boolean canMove() {
        return true;
    }

    @Override
    protected void onMove() {

    }

    @Override
    public Pair<Integer, Integer> position() {
        return this.position;
    }
}
