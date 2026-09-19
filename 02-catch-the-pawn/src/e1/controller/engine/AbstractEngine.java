package e1.controller.engine;

import e1.model.components.pawn.Pawn;
import e1.model.elements.position.CartesianPosition;
import e1.model.elements.position.CartesianPositionImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public abstract class AbstractEngine implements Engine{

    private final int size;
    private final Random random = new Random();
    private final List<CartesianPosition<Integer>> positions = new ArrayList<>();

    public AbstractEngine(int size) {
        this.size = size;
    }

    @Override
    public List<Pawn> generate(){
        try {
            return this.populatePawns(this::randomEmptyPosition);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private CartesianPosition<Integer> randomEmptyPosition() {
        CartesianPosition<Integer> pos = new CartesianPositionImpl(this.random.nextInt(size), this.random.nextInt(size));
        // the recursive call below prevents clash with an existing paw
        if (positions.stream().anyMatch(p -> p.equals(pos))) {
            return randomEmptyPosition();
        } else {
            this.positions.add(pos);
            return pos;
        }

    }

    protected abstract List<Pawn> populatePawns(Callable<CartesianPosition<Integer>> randomEngine) throws Exception;

}
