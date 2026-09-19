package e1.controller.engine;

import e1.model.components.pawn.Pawn;
import e1.model.components.pawn.PawnFactoryImpl;
import e1.model.elements.position.CartesianPosition;
import e1.model.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class EngineFactoryImpl implements EngineFactory{

    @Override
    public Engine catchThePawn() {
        return new AbstractEngine(Constants.SIZE) {
            @Override
            public List<Pawn> populatePawns(Callable<CartesianPosition<Integer>> randomEngine) throws Exception {
                return new ArrayList<>(List.of(
                        new PawnFactoryImpl().simplePawn(randomEngine.call()),
                        new PawnFactoryImpl().knight(randomEngine.call())));
            }
        };
    }
}
