package lab01.tdd.exercise3;

import lab01.tdd.exercise1.BasicCircularList;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Represents a list of generics, with a built-in filter
 */
public interface CircularList<X> extends BasicCircularList {

    /**
     * Finds and returns the next element that satisfies a given condition.
     */
    Optional<X> filteredNext(Predicate<? super X> predicate);

}
