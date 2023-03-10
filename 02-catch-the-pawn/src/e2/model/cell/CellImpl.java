package e2.model.cell;

public class CellImpl implements Cell {

    private int counter;


    public CellImpl(int counter) {
        this.counter = counter;
    }

    @Override
    public int getCounter() {
        return this.counter;
    }

}
