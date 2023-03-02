package exercise1;

import lab01.tdd.exercise1.FirstCircularList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * The test suite for testing the FirstCircularList implementation
 */
public class FirstCircularListTest extends BasicFirstCircularListTest {

    @Override
    @BeforeEach
    void beforeEach() {
        this.circularList = new FirstCircularList();
    }

    @Test
    void prevElement() {
        this.populateList();
        assertEquals(Optional.of(LAST_ELEM),circularList.previous());
    }
    @Test
    void nextElement() {
        this.populateList();
        assertEquals(Optional.of(SECOND_ELEM),circularList.next());
    }

    @Test
    void cycleSingleElementForward() {
        this.circularList.add(FIRST_ELEM);
        for (int i = 0; i < circularList.size(); i++) {
            assertEquals(Optional.of(FIRST_ELEM),circularList.next());
        }
    }

    @Test
    void cycleElementsForwards() {
        this.populateList();
        for (int i = 0; i < circularList.size(); i++) {
            circularList.next();
        }
        assertEquals(Optional.of(SECOND_ELEM),circularList.next());
    }

    @Test
    void cycleSingleElementBackwards() {
        circularList.add(FIRST_ELEM);
        for (int i = 0; i < 100; i++) {
            assertEquals(Optional.of(FIRST_ELEM),circularList.previous());
        }
    }

    @Test
    void cycleElementsBackwards() {
        this.populateList();
        for (int i = 0; i < circularList.size(); i++) {
            circularList.previous();
        }
        assertEquals(Optional.of(SECOND_ELEM),circularList.next());
    }

    @Test
    void clearList() {
        this.populateList();
        circularList.next();
        circularList.next();
        circularList.next();
        circularList.previous();
        circularList.reset();
        assertEquals(Optional.of(SECOND_ELEM), circularList.next());
    }

    @Test
    void cycleBackAndForward() {
        this.populateList();
        for (int i = 0; i < circularList.size(); i++) {
            circularList.previous();
            circularList.next();
        }
        assertEquals(Optional.of(SECOND_ELEM),circularList.next());
    }
}
