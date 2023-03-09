package e2.model.board;

import e1.model.elements.Pair;
import java.util.List;

public interface Board {
    int getSize();

    int getMinesSize();

    List<Pair<Integer,Integer>> getMines();

}
