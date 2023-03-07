package e1.model.components.pawn;


import e1.model.elements.position.CartesianPosition;

public class PawnFactoryImpl implements PawnFactory {

    @Override
    public Pawn simplePawn(CartesianPosition<Integer> position) {
        return new AbstractPawn(position) {
            @Override
            protected boolean canMove(CartesianPosition<Integer> position) {
                return Math.abs(position.getX())+Math.abs(position.getY())==1;
            }
        };
    }

    @Override
    public Pawn knight(CartesianPosition<Integer> position) {
        return new AbstractPawn(position) {
            @Override
            protected boolean canMove(CartesianPosition<Integer> position) {
                return Math.abs(position.getX())+Math.abs(position.getY())==3;
            }
        };
    }
}
