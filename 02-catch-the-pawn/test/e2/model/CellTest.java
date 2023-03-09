package e2.model;

import e2.model.cell.Cell;
import e2.model.cell.CellImpl;
import org.junit.jupiter.api.BeforeEach;


public class CellTest {

    private Cell cell;

    @BeforeEach
    void setUp() {
        this.cell = new CellImpl();
    }

}
