package e2.model.cell;

public class CellImpl implements Cell {

    private final int counter;

    private boolean flag;


    public CellImpl(int counter) {
        this.counter = counter;
    }

    @Override
    public int getCounter() {
        return this.counter;
    }

    @Override
    public boolean isFlag() {
        return this.flag;
    }

    @Override
    public void toggleFlag() {
        this.flag = !this.flag;
    }

}
