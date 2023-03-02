package lab01.tdd.exercise2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static lab01.tdd.utils.CollectionsUtils.reverse;

public class SecondCircularList implements CircularList<Integer>{

    private final List<Integer> list;

    public SecondCircularList() {
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
    public Iterator<Integer> forwardIterator() {
        return new CyclicIterator(list);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new CyclicIterator(reverse(list));
    }

}
