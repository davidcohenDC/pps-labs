package e2.model;

public class BoardImpl implements Board{

    private int size;
    private int mines;

    public BoardImpl(int size, int mines) {
        this.size = size;
        this.mines = mines;
    }

    @Override
    public int size() {
        return this.size;
    }
    @Override
    public int getMines() {
        return this.mines;
    }
}
