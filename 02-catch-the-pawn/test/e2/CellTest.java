package e2;

import e2.model.Cell;
import e2.model.CellImpl;
import org.junit.jupiter.api.BeforeEach;


public class CellTest {

    private Cell cell;

    @BeforeEach
    void setUp() {
        this.cell = new CellImpl();
    }


}
