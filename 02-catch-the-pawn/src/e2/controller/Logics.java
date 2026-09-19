package e2.controller;

import e2.Pair;

public interface Logics {

    boolean isMine(Pair<Integer, Integer> position);

    void toggleFlag(Pair<Integer, Integer> position);

    boolean isFlagged(Pair<Integer, Integer> position);

    boolean isFlag(Pair<Integer, Integer> flagPosition);
}
