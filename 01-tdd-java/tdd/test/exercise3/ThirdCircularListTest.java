package exercise3;

import lab01.tdd.exercise3.ThirdCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

public class ThirdCircularListTest extends BasicThirdCircularListTest{

    @Override
    @BeforeEach
    void beforeEach() {
        this.circularList = new ThirdCircularList();
    }

    @Test
    void getFilteredElem() {
        this.populateList();
        Optional<Integer> value = this.circularList.filteredNext( i -> i == FIRST_ELEM);
        assertEquals(Optional.of(FIRST_ELEM),value);
        value = this.circularList.filteredNext( i -> i == 1000);
        assertEquals(Optional.empty(),value);
    }
}
