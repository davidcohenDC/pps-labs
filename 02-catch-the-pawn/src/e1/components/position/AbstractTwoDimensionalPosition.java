package e1.components.position;

import e1.Pair;

public abstract class AbstractTwoDimensionalPosition<X> implements Position{

    protected X x;

    protected X y;

    public AbstractTwoDimensionalPosition(X x, X y) {
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
    public abstract Object getCoordinates();
}
