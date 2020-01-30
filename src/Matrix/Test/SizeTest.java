package Matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class SizeTest {

    @Test
    public void defaultConstructorGetRow() throws Exception {
        assertTrue(1 == new Size().getRow());
    }

    @Test
    public void constructorGetRow() throws Exception {
        assertTrue(2 == new Size(2, 3).getRow());
    }

    @Test
    public void defaultConstructorGetColumn() throws Exception {
        assertTrue(1 == new Size().getColumn());
    }

    @Test
    public void constructorGetColumn() throws Exception {
        assertTrue(3 == new Size(2, 3).getColumn());
    }

    @Test
    public void emptyEquals() throws Exception {
        assertTrue(new Size().equals(new Size()));
    }

    @Test
    public void reflexiveEquals() throws Exception {
        assertTrue(new Size(2, 3).equals(new Size(2, 3)));
    }

    @Test
    public void differDimenEquals() throws Exception {
        assertFalse(new Size(3, 3).equals(new Size(2, 3)));
        assertFalse(new Size(3, 3).equals(new Size(3, 2)));
    }

    @Test
    public void testCheckSquare() throws Exception {
        assertTrue(new Size(3, 3).checkSquare());
        assertFalse(new Size(2, 3).checkSquare());
    }

    @Test
    public void testEntryPosition() throws Exception {
        assertTrue(new Size(2, 2).entryPosition(0, 0));
        assertTrue(new Size(2, 2).entryPosition(1, 1));
    }
    @Test
    public void testExitEntryPosition() throws Exception {
        assertFalse(new Size(2, 2).entryPosition(-1, 0));
        assertFalse(new Size(2, 2).entryPosition(0, -1));
        assertFalse(new Size(2, 2).entryPosition(0, 21));
        assertFalse(new Size(2, 2).entryPosition(2, 1));
    }
}

