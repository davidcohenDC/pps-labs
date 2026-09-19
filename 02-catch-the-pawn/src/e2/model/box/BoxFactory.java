package e2.model.box;

import e2.Pair;

public interface BoxFactory {

    Box mine();

    Box cell(int counter);
}
