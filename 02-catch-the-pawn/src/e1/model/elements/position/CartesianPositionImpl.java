package e1.model.elements.position;

import e1.model.elements.Pair;

import java.util.Objects;

public class CartesianPositionImpl implements CartesianPosition<Integer> {

    private int X;

    private int Y;

    public CartesianPositionImpl(int x, int y) {
        X = x;
        Y = y;
    }

    @Override
    public Pair<Integer,Integer> getCoordinates() {
        return new Pair<>(X,Y);
    }

    @Override
    public Integer getX() {
        return this.X;
    }

    @Override
    public void setX(Integer x) {
        this.X = x;
    }

    @Override
    public Integer getY() {
        return this.Y;
    }

    @Override
    public void setY(Integer y) {
        this.Y = y;
    }

    @Override
    public void setCoordinates(CartesianPosition<Integer> position) {
        this.X = position.getX();
        this.Y = position.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartesianPositionImpl that)) return false;
        return X == that.X && Y == that.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
