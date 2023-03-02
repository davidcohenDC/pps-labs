package lab01.tdd.exercise3;

import java.util.*;
import java.util.function.Predicate;

public class ThirdCircularList implements CircularList<Integer>{

    private List<Integer> list;

    public ThirdCircularList() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
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
    public Optional<Integer> filteredNext(Predicate<? super Integer> predicate) {
        for (Integer elem: list) {
            if(predicate.test(elem)) {
                return Optional.of(elem);
            }
        }
        return Optional.empty();
    }
}
