package e2.model;

import e1.model.elements.Pair;
import e1.model.elements.position.CartesianPosition;
import e1.model.elements.position.CartesianPositionImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardImpl implements Board{

    private final int size;
    private List<Pair<Integer,Integer>> mines;

    private final Random random = new Random();

    public BoardImpl(int size, int mines) {
        this.size = size;
        this.mines = new ArrayList<>();
        this.mines = this.generateMines(mines);
    }

    private List<Pair<Integer, Integer>> generateMines(int mines) {
        for (int i = 0; i < mines; i++) {
            this.mines.add(this.generateRandomMinePosition());
        }
        return this.mines;
    }

    private Pair<Integer, Integer> generateRandomMinePosition() {
        Pair<Integer,Integer> position = new Pair<>(this.random.nextInt(this.size),this.random.nextInt(this.size));
        if(this.mines.stream().anyMatch(mine -> mine == position)) {
            return this.generateRandomMinePosition();
        } else {
            return position;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }
    @Override
    public int getMinesSize() {
        return this.mines.size();
    }

    @Override
    public List<Pair<Integer, Integer>> getMines() {
        return this.mines;
    }
}
