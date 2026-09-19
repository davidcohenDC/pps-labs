package e2.model.cell;

import e2.Pair;

import java.util.List;

public class CellImpl implements Cell {

    private int counter = 0;

    private boolean flag;

    private Pair<Integer,Integer> position;


    public CellImpl(Pair<Integer,Integer> position) {
        this.position = position;
    }

    public CellImpl(int counter) {
        this.counter = counter;
    }

    public CellImpl(Pair<Integer,Integer> position,int counter) {
        this.counter = counter;
        this.position = position;
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
