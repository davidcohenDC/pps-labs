package e2.model;

public class BoardImpl implements Board{

    private int size;

    public BoardImpl() {
    }

    public BoardImpl(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return this.size;
    }
}
