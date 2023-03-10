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
    public void flag(Pair<Integer, Integer> position) {

    }
}
