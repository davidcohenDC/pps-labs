package exercise2;

import lab01.tdd.exercise2.SecondCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static lab01.tdd.utils.CollectionsUtils.reverse;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.List;

class SecondCircularListTest extends BasicSecondCircularListTest {

    @Override
    @BeforeEach
    void beforeEach() {
        this.circularList = new SecondCircularList();
    }

    @Test
    void goForward() {
        this.populateList();
        Iterator<Integer> iter = this.circularList.forwardIterator();
        for (Integer elem :elements) {
            assertEquals(elem,iter.next());
        }
        for (Integer elem :elements) {
            assertEquals(elem,iter.next());
        }
    }

    @Test
    void goBackward() {
        this.populateList();
        Iterator<Integer> iter = this.circularList.backwardIterator();
        List<Integer> reversedElements = reverse(elements);
        for (Integer elem :reversedElements) {
            assertEquals(elem,iter.next());
        }
        for (Integer elem :reversedElements) {
            assertEquals(elem,iter.next());
        }
    }

}