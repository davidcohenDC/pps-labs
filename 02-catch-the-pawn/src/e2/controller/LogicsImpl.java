package e2.controller;

import e2.Pair;
import e2.model.board.Board;

public class LogicsImpl implements Logics {

    private final Board board;

    public LogicsImpl(Board board) {
        this.board = board;
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> position) {
        return this.board.getMines().stream()
                .anyMatch(mine -> mine.getX().equals(position.getX()) && mine.getY().equals(position.getY()));
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> position) {
//
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> position) {
        return false;
    }
//
//    @Override
//    public boolean isFlagged(Pair<Integer, Integer> position) {
//        return this.board.getFlag(position).isPresent();
//    }

    @Override
    public boolean isFlag(Pair<Integer, Integer> flagPosition) {
        return false;
    }
}
