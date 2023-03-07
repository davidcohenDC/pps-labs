package e1.components.pawn;

import e1.Pair;

public interface Pawn {

    void move(int x, int y);

    Pair<Integer,Integer> position();
}
