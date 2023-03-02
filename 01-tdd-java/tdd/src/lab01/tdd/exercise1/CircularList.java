package lab01.tdd.exercise1;

import java.util.Optional;

/**
 * Represents a list of integers, with a built-in iterator that is bidirectional and circular.
 */
public interface CircularList extends BasicCircularList{

    /**
     * Provides the next element of the list, as given by the built-in iterator.
     * @return the next element of the list, or an empty optional if the list is empty
     */
    Optional<Integer> next();

    /**
     * Provides the previous element of the list. Its behaviour is dual of the next() method.
     * @return the previous element into the list
     */
    Optional<Integer> previous();

    /**
     * Reset the position of current element back to the first one of the list.
     * Note the first one is the first added to the list.
     */
    void reset();
}
