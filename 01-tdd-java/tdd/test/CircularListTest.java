import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListImpl();
    }

    @Test
    void addElement() {
        int element = 5;
        circularList.add(element);
        assertEquals(1,circularList.size());
    }

    @Test
    void nextElement() {
        circularList.add(5);
        circularList.add(3);
        assertEquals(Optional.of(3),circularList.next());
    }

    @Test
    void cycleSingleElementForward() {
        circularList.add(3);
        for (int i = 0; i < 100; i++) {
            assertEquals(Optional.of(3),circularList.next());
        }
    }

    @Test
    void cycleElementsForwards() {
        circularList.add(3);
        circularList.add(4);
        circularList.add(2);
        for (int i = 0; i < 11; i++) {
            circularList.next();
        }
        assertEquals(Optional.of(3),circularList.next());
    }

    @Test
    void prevElement() {
        circularList.add(5);
        circularList.add(3);
        assertEquals(Optional.of(3),circularList.previous());
    }

    @Test
    void cycleSingleElementBackwards() {
        circularList.add(3);
        for (int i = 0; i < 100; i++) {
            assertEquals(Optional.of(3),circularList.next());
        }
    }

    @Test
    void cycleElementsBackwards() {
        circularList.add(3);
        circularList.add(4);
        circularList.add(2);
        for (int i = 0; i < 11; i++) {
            circularList.next();
        }
        assertEquals(Optional.of(3),circularList.next());
    }

    @Test
    void clearList() {
        circularList.add(3);
        circularList.add(4);
        circularList.add(2);
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
