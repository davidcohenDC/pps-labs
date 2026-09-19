package e2.model.board;

import e2.Pair;
import java.util.List;
import java.util.Optional;

public interface Board {
    int getSize();

    int getMinesSize();

    List<Pair<Integer,Integer>> getMines();

    List<Pair<Integer,Integer>> getCells();

    List<Pair<Integer,Integer>> getGrid();

    List<Optional<Integer>> getBoxValues();

    List<Boolean> getTriggers();

    void setFlag(Pair<Integer,Integer> position, boolean flag);

    boolean getFlag(Pair<Integer,Integer> position);

    void activateTrigger(Pair<Integer,Integer> position);

    boolean isTrigger(Pair<Integer,Integer> position);



}
