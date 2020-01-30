package Matrix;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositionTest {

    @Test
    public void defaultConstructorGetRow() throws Exception {
        assertTrue(0 == new Position().getRow());
    }

    @Test
    public void constructorGetRow() throws Exception {
        assertTrue(2 == new Position(2, 3).getRow());
    }

    @Test
    public void defaultConstructorGetColumn() throws Exception {
        assertTrue(0 == new Position().getColumn());
    }

    @Test
    public void constructorGetColumn() throws Exception {
        assertTrue(3 == new Position(2, 3).getColumn());
    }

    @Test
    public void testEntryPosition() throws Exception {
        assertTrue(new Position(2, 2).entrySize(new Size(3, 3)));
    }

    @Test
    public void wrongEntryPosition() throws Exception {
        assertFalse(new Position(2, 3).entrySize(new Size(3, 3)));
    }

    @Test
    public void testToSting() throws Exception {
        String result = "2 3";
        assertTrue(result.equals(new Position(2, 3).toString()));
    }
}