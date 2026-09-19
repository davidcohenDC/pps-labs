package e1.controller.engine;

import e1.model.components.pawn.Pawn;
import java.util.List;

public interface Engine {
    List<Pawn> generate();
}
