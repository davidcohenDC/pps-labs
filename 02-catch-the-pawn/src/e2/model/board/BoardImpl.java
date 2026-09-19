package e2.model.board;

import e2.Pair;
import e2.model.box.Box;
import e2.model.box.Cell;
import e2.model.box.Mine;
import java.util.*;
import java.util.stream.Collectors;

public class BoardImpl implements Board{

    private final int size;

    private final Map<Pair<Integer,Integer>, Box> grid;

    private final Map<Pair<Integer,Integer>, Box> mines;

    private final Random random = new Random();

    public BoardImpl(int size, int mines) {
        this.size = size;
        this.mines = this.generateMinesGrid(mines);
        this.grid = this.generateCellGrid();
//        this.selectedBox = this.grid.keySet()
//                .stream()
//                .collect(Collectors.toMap(pos -> pos, k -> false));
    }

    public BoardImpl(int size, List<Pair<Integer,Integer>> mines) {
        this.size = size;
        this.mines = mines.stream().collect(Collectors.toMap(pos -> pos, k -> new Mine()));
        this.grid = this.generateCellGrid();
//        this.selectedBox = this.grid.keySet()
//                .stream()
//                .collect(Collectors.toMap(pos -> pos, k -> false));
    }

    private Map<Pair<Integer,Integer>,Box> generateMinesGrid(int mines) {
        Map<Pair<Integer,Integer>,Box> minesMap = new HashMap<>();
        for (int i = 0; i < mines; i++) {
            Pair<Integer,Integer> position = this.generateNewRandomPosition();
            minesMap.put(position,new Mine());
        }
        return minesMap;
    }

    private Map<Pair<Integer,Integer>,Box> generateCellGrid() {
        if(this.mines.isEmpty()) {
            throw new IllegalCallerException();
        }
        Map<Pair<Integer,Integer>,Box> grid = new HashMap<>(this.mines);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Pair<Integer,Integer> position = new Pair<>(i,j);
                grid.putIfAbsent(position, new e2.model.box.Cell(this.calculateCounter(position)));
            }
            Pair<Integer,Integer> position = this.generateNewRandomPosition();
            grid.put(position,new Mine());
        }

        return grid;
    }

    private int calculateCounter(Pair<Integer,Integer> position) {
        return (int) this.mines.entrySet()
                .stream()
                .filter(entry -> inRange(entry.getKey().getX(), position.getX()) &&
                inRange(entry.getKey().getY(),position.getY())).count();
    }

    private void openNeighbour(Pair<Integer,Integer> position) {
        if(this.grid.get(position).getTrigger()) {
            return;
        }
        Map<Pair<Integer,Integer>, Box> map = new HashMap<>(this.grid);
        map.entrySet()
                .stream()
                .filter(value -> value.getValue().getValue().isPresent()) //controllo che esista il valore
                .filter(value -> value.getValue().getValue().get() == 0) //filtro che sono zero
                .filter(entry -> inRange(entry.getKey().getX(), position.getX()) && //filtro quelli che sono vicini a questo
                        inRange(entry.getKey().getY(),position.getY()))
                .forEach(entry -> {
                            this.grid.get(entry.getKey()).setTrigger(true);
                            this.openNeighbour(position);
                });
    }

    private boolean inRange(int actual, int target) {
        return actual >= target -1 && actual <= target + 1;
    }

    private Pair<Integer, Integer> generateNewRandomPosition() {
        Pair<Integer,Integer> position = new Pair<>(this.random.nextInt(this.size),this.random.nextInt(this.size));
        if(this.grid != null  && this.grid.size() == (this.size*this.size)) {
            throw new IllegalCallerException();
        } else if(this.mines != null && !this.mines.containsKey(position)) {
            return this.generateNewRandomPosition();
        } else {
            return position;
        }
    }

    @Override
    public int getSize() {
        return this.grid.size();
    }
    @Override
    public int getMinesSize() {
        return this.mines.size();
    }

    @Override
    public List<Pair<Integer, Integer>> getMines() {
        return this.mines.keySet().stream().toList();
    }

    @Override
    public List<Pair<Integer, Integer>> getCells() {
        return this.grid.keySet()
                .stream()
                .filter(key -> key.getClass().isInstance(Cell.class)).toList();
    }

    @Override
    public List<Pair<Integer, Integer>> getGrid() {
        return this.grid.keySet().stream().toList();
    }

    @Override
    public List<Optional<Integer>> getBoxValues() {
        return this.grid.values().stream().map(Box::getValue).toList();
    }

    @Override
    public List<Boolean> getTriggers() {
        return this.grid.values().stream().map(Box::getTrigger).toList();
    }

    @Override
    public void setFlag(Pair<Integer, Integer> position, boolean flag) {
        this.grid.get(position).setFlag(flag);
    }

    @Override
    public boolean getFlag(Pair<Integer, Integer> position) {
        return this.grid.get(position).getFlag();
    }

    @Override
    public void activateTrigger(Pair<Integer, Integer> position) {
        this.openNeighbour(position);
    }

    @Override
    public boolean isTrigger(Pair<Integer, Integer> position) {
        return this.grid.get(position).getTrigger();
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

//    private List<Mine> generateMines(int mines) {
//        for (int i = 0; i < mines; i++) {
//            this.grid.put(this.generateRandomMinePosition(), new Mine());
//            this.mines.add(this.generateRandomMinePosition());
//        }
//        return this.mines;
//    }

    //    private Integer getCounterValue(int row, int col) {
//        int counter = 0;
//        for (int i = -1; i < 2; i++) {
//            for (int j = -1; j < 2; j++) {
//                Pair<Integer,Integer> position = new Pair<>(row+i,col+j);
//                if(i != 0 && j != 0) {
//                    if(this.grid.get(position).getClass().equals(Mine.class)) {
//                        counter = counter + 1;
//                    }
//                }
//            }
//        }
//        return counter;
//    }

}
