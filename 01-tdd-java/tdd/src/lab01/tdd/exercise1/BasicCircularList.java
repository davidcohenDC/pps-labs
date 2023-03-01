package lab01.tdd.exercise1;

import java.util.*;

public class BasicCircularList implements CircularList {

    private final List<Optional<Integer>> list;
    private int actualIndex = 0;

    public BasicCircularList() {
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
        this.incrementIndex();
        return list.get(actualIndex);

    }

    @Override
    public Optional<Integer> previous() {
        if(list.isEmpty()) {
            return Optional.empty();
        }
       this.decrementIndex();
        return list.get(actualIndex);
    }

    @Override
    public void reset() {
        this.actualIndex = 0;
    }

    private void incrementIndex() {
        actualIndex += 1;
        if(actualIndex >= list.size()) {
            actualIndex = 0;
        }
    }

    private void decrementIndex() {
        this.actualIndex -= 1;
        if (actualIndex < 0) {
            actualIndex = list.size()-1;
        }
    }
}
