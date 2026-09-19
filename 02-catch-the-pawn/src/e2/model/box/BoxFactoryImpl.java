package e2.model.box;

import e2.Pair;

public class BoxFactoryImpl implements BoxFactory{

    @Override
    public Box mine() {
        return new Mine();
    }

    @Override
    public Box cell(int counter) {
        return new Cell(counter);
    }
}
