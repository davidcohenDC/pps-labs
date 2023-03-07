package e1;


public class PawnFactoryImpl implements PawnFactory {

    @Override
    public Pawn simplePawn() {
        return new AbstractPawn(new Pair<>(0,0)) {
            @Override
            protected boolean canMove() {
                return false;
            }

            @Override
            protected void onMove() {

            }
        };
    }
}
