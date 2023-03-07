package e1.components.position;

import e1.Pair;

public class TwoDimensionalPosition<X> implements Position{

    private X x;

    private X y;

    public TwoDimensionalPosition(X x, X y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public X getY() {
        return y;
    }

    public void setY(X y) {
        this.y = y;
    }

    @Override
    public Object getCoordinates() {
        return new Pair<>(x,y);
    }
}
