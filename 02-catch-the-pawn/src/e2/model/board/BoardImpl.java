package e2.model.board;

import e2.Pair;
import e2.model.cell.Cell;
import e2.model.cell.CellImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class BoardImpl implements Board{

    private final int size;
    private List<Pair<Integer,Integer>> mines;
    private final Random random = new Random();

    private final List<Cell> cells = new ArrayList<>();

    public BoardImpl(int size, int mines) {
        this.size = size;
        this.mines = new ArrayList<>();
        this.mines = this.generateMines(mines);
    }

//    private List<Cell> generateCells() {
//        for (int i = 0; i < this.size; i++) {
//            for (int j = 0; j < this.size; j++) {
//                Pair<Integer,Integer> pos = new Pair<>(i,j);
//                if(this.mines.stream()
//                        .anyMatch(mine -> mine.getX().equals(pos.getX()) && mine.getX().equals(pos.getY()))) {
//                    this.cells.add(new CellImpl(pos,this.countAdiacentMines(pos)));
//                }
//            }
//        }
//        return this.cells;
//    }

//    private int countAdiacentMines(Pair<Integer, Integer> pos) {
//
//    }

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

    @Override
    public void setFlag(Pair<Integer, Integer> position) {

    }

}
