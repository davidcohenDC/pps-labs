package lab01.tdd;

import java.util.*;

public class CircularListImpl implements CircularList {

    private final List<Optional<Integer>> list;
    private int actualIndex = 0;

    public CircularListImpl() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(int element) {
        list.add(Optional.of(element));
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if(list.isEmpty()) {
            return Optional.empty();
        }
        actualIndex += 1;
        correctBounds();
        return list.get(actualIndex);

    }

    @Override
    public Optional<Integer> previous() {
        if(list.isEmpty()) {
            return Optional.empty();
        }
        actualIndex -= 1;
        correctBounds();
        return list.get(actualIndex);
    }

    @Override
    public void reset() {
        this.list.clear();
        this.actualIndex = 0;
    }

    private void correctBounds() {
        if(actualIndex >= list.size()) {
            actualIndex = 0;
        } else if (actualIndex < 0) {
            actualIndex = list.size()-1;
        }

    }
}
