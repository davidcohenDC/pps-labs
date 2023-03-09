package e2.controller;

import e2.model.board.Board;
import e2.model.board.BoardImpl;

public class LogicsImpl implements Logics {

    private final Board board;

    public LogicsImpl(BoardImpl board) {
        this.board = board;
    }

}
