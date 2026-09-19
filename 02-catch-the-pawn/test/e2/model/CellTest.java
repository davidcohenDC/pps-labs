package e2.model;

import e2.model.box.Box;
import e2.model.cell.Cell;
import e2.model.cell.CellImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private Cell cell;

    private static final int VALUE = 3;

    @BeforeEach
    void setUp() {
        this.cell = new CellImpl(VALUE);
    }

    @Test
    void testGetValue() {
       assertEquals(VALUE,this.cell.getCounter());
    }

    @Test
    void testSetFlag() {
        assertFalse(this.cell.isFlag());
        this.cell.toggleFlag();
        assertTrue(this.cell.isFlag());
        this.cell.toggleFlag();
        assertFalse(this.cell.isFlag());
        List<Box> boxes = new ArrayList<>();
        boxes.add(new e2.model.box.Cell(1));

    }
}
