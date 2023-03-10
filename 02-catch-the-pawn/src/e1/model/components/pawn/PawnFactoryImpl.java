package e1.model.components.pawn;


import e1.model.elements.position.CartesianPosition;
import e1.model.utils.PAWN_TYPE;

public class PawnFactoryImpl implements PawnFactory {

    @Override
    public Pawn simplePawn(CartesianPosition<Integer> position) {
        return new AbstractPawn(PAWN_TYPE.PAWN, position) {
            @Override
            protected boolean canMove(CartesianPosition<Integer> position) {
                position.setX(position.getX()-this.actualPosition.getX());
                position.setY(position.getY()-this.actualPosition.getY());
                return Math.abs(position.getX())+Math.abs(position.getY())==1;
            }
        };
    }

    @Override
    public Pawn knight(CartesianPosition<Integer> position) {
        return new AbstractPawn(PAWN_TYPE.KNIGHT, position) {
            @Override
            protected boolean canMove(CartesianPosition<Integer> position) {
                position.setX(position.getX()-this.actualPosition.getX());
                position.setY(position.getY()-this.actualPosition.getY());
                return Math.abs(position.getX())+Math.abs(position.getY())==3;
            }
        };
    }
}
