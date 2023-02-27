import lab01.tdd.CircularList;
import lab01.tdd.BasicCircularList;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    private static final int FIRST_ELEM = 9;
    private static final int SECOND_ELEM = 3;

    private static final int LAST_ELEM = 4;

    private List<Integer> elements;

    private void populateList() {
        this.elements = new ArrayList<>(List.of(FIRST_ELEM,SECOND_ELEM,7,2,7,8,LAST_ELEM));
        for (Integer element : elements) {
            circularList.add(element);
        }
    }

    @BeforeEach
    void beforeEach() {
        this.circularList = new BasicCircularList();

    }

    @Test
    void addElement() {
        this.populateList();
        assertEquals(elements.size(),circularList.size());
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
    void prevElement() {
        this.populateList();
        assertEquals(Optional.of(LAST_ELEM),circularList.previous());
    }

    @Test
    void cycleSingleElementBackwards() {
        circularList.add(FIRST_ELEM);
        for (int i = 0; i < 100; i++) {
            assertEquals(Optional.of(FIRST_ELEM),circularList.next());
        }
    }

    @Test
    void cycleElementsBackwards() {
        this.populateList();
        for (int i = 0; i < circularList.size(); i++) {
            circularList.next();
        }
        assertEquals(Optional.of(SECOND_ELEM),circularList.next());
    }

    @Test
    void clearList() {
        this.populateList();
        circularList.reset();
        assertEquals(0, circularList.size());
    }


    @Test
    void checkIfEmpty() {
        this.clearList();
        assertTrue(circularList.isEmpty());
    }

    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

}
