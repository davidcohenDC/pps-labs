package lab01.tdd.exercise2;

import lab01.tdd.exercise1.BasicCircularList;

import java.util.Iterator;

/**
 * Represents a list of generics, with a built-in iterator that is bidirectional and circular.
 */
public interface CircularList<X> extends BasicCircularList {

    /**
     * Provides a cycle forward iterator.
     * @return a new {@link java.util.Iterator}, which yields next elements, circularly
     */
    Iterator<X> forwardIterator();

    /**
     * Provides a cycle backward iterator.
     * @return a new {@link java.util.Iterator}, which yields previous elements, circularly
     */
    Iterator<X> backwardIterator();

}
