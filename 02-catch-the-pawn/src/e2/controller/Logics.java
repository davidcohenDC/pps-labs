package e2.controller;

import e2.Pair;

public interface Logics {

    boolean isMine(Pair<Integer, Integer> position);

    void flag(Pair<Integer, Integer> position);
}
