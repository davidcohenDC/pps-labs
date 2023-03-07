package e1.components.pawn;


import e1.Pair;

public class PawnFactoryImpl implements PawnFactory {

    @Override
    public Pawn simplePawn() {
        return new AbstractPawn(new Pair<>(0,0)) {
            @Override
            protected boolean canMove(int x, int y) {
                return Math.abs(x)+Math.abs(y)==1;
            }
        };
    }
}
