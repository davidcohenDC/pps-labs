package exercise1;

import lab01.tdd.exercise1.FirstCircularList;
import lab01.tdd.exercise1.CircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class BasicFirstCircularListTest {

    protected CircularList circularList;

    protected static final int FIRST_ELEM = 9;
    protected static final int SECOND_ELEM = 3;
    protected static final int LAST_ELEM = 4;

    protected List<Integer> elements;

    protected void populateList() {
        this.elements = new ArrayList<>(List.of(FIRST_ELEM,SECOND_ELEM,LAST_ELEM));
        for (Integer element : elements) {
            circularList.add(element);
        }
    }

    @BeforeEach
    void beforeEach() {
        this.circularList = new FirstCircularList();
    }

    @Test
    void addElements() {
        this.populateList();
    }

    @Test
    void getSize() {
        assertEquals(0,this.circularList.size());
        this.populateList();
        assertEquals(elements.size(),this.circularList.size());
    }

    @Test
    void checkIfEmpty() {
        assertTrue(this.circularList.isEmpty());
        this.populateList();
        assertFalse(this.circularList.isEmpty());
    }
}
