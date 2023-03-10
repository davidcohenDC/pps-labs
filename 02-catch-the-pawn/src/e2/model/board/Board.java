package e2.model.board;

import e2.Pair;
import java.util.List;
import java.util.Optional;

public interface Board {
    int getSize();

    int getMinesSize();

    List<Pair<Integer,Integer>> getMines();

    void setFlag(Pair<Integer,Integer> position);

//    Optional<Pair<Integer,Integer>> getFlag(Pair<Integer,Integer> position);


}
