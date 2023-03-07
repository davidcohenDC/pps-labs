package e1.components.position;

import e1.Pair;

public class TwoDimensionalPositionImpl extends AbstractTwoDimensionalPosition<Integer>{

    public TwoDimensionalPositionImpl(Integer integer, Integer y) {
        super(integer, y);
    }

    @Override
    public Pair<Integer,Integer> getCoordinates() {
        return new Pair<>(x,y);
    }
}
