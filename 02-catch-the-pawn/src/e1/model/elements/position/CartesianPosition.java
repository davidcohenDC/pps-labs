package e1.model.elements.position;
public interface CartesianPosition<X> {

    X getX();

    X getY();

    void setX(X x);

    void setY(X y);

    void setCoordinates(CartesianPosition<Integer> position);

    Object getCoordinates();

}
