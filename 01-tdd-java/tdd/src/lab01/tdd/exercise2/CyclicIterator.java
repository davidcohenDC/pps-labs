package lab01.tdd.exercise2;

import java.util.Iterator;
import java.util.List;

public class CyclicIterator implements Iterator<Integer> {

    private final List<Integer> elements;
    private Iterator<Integer> iterator;

    public CyclicIterator(List<Integer> elements) {
        this.elements = elements;
        this.iterator = elements.listIterator();
    }

    @Override
    public boolean hasNext() {
        if(!iterator.hasNext()) {
            iterator = elements.listIterator();
        }
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        if(!iterator.hasNext()) {
            iterator = elements.listIterator();
        }
        return iterator.next();
    }
}
