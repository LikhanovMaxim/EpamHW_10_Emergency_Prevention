package Emergency.prevention.system;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LevelRiskTest {

    @Test
    public void testIncrement() throws Exception {
        LevelRisk levelRisk = new LevelRisk("NONE", 1, 4);
        assertTrue(levelRisk.getCount() == 0);
        assertTrue(levelRisk.getMax() == 0);
        levelRisk.increment(2);
        levelRisk.increment(4);
        levelRisk.increment(1);
        levelRisk.increment(0);
        levelRisk.increment(100);
        assertTrue(levelRisk.getCount() == 3);
        assertTrue(levelRisk.getMax() == 4);
    }

    @Test
    public void testGetMax() throws Exception {
        LevelRisk levelRisk = new LevelRisk("NONE", 4, 6);
        assertTrue(levelRisk.getMax() == 0);
        levelRisk.increment(4);
        assertTrue(levelRisk.getMax() == 4);
        levelRisk.increment(6);
        assertTrue(levelRisk.getMax() == 6);
    }

    @Test
    public void testGetCount() throws Exception {
        LevelRisk levelRisk = new LevelRisk("NONE", 10, 20);
        assertTrue(levelRisk.getCount() == 0);
        levelRisk.increment(12);
        assertTrue(levelRisk.getCount() == 1);
        levelRisk.increment(13);
        levelRisk.increment(16);
        assertTrue(levelRisk.getCount() == 3);
    }


    @Test
    public void testReflexivityEquals() throws Exception {
        LevelRisk levelRisk = new LevelRisk("NONE", 10, 20);
        levelRisk.increment(11);
        levelRisk.increment(15);
        assertTrue(levelRisk.equals(levelRisk));
    }

    @Test
    public void testDifferentNameEquals() throws Exception {
        LevelRisk firstRisk = new LevelRisk("MINOR", 10, 20);
        firstRisk.increment(11);
        firstRisk.increment(15);
        LevelRisk secondRisk = new LevelRisk("NONE", 10, 20);
        assertFalse(firstRisk.equals(secondRisk));
        assertFalse(secondRisk.equals(firstRisk));
    }

    @Test
    public void testDifferentLeftBorderEquals() throws Exception {
        LevelRisk firstRisk = new LevelRisk("NONE", 2, 20);
        firstRisk.increment(11);
        firstRisk.increment(15);
        LevelRisk secondRisk = new LevelRisk("NONE", 10, 20);
        assertFalse(firstRisk.equals(secondRisk));
        assertFalse(secondRisk.equals(firstRisk));
    }

    @Test
    public void testDifferentRightBorderEquals() throws Exception {
        LevelRisk firstRisk = new LevelRisk("NONE", 10, 20);
        firstRisk.increment(11);
        firstRisk.increment(15);
        LevelRisk secondRisk = new LevelRisk("NONE", 10, 21);
        assertFalse(firstRisk.equals(secondRisk));
        assertFalse(secondRisk.equals(firstRisk));
    }

    @Test
    public void testClone() throws Exception {
        LevelRisk levelRisk = new LevelRisk("NONE", 10, 20);
        levelRisk.increment(11);
        levelRisk.increment(15);
        LevelRisk clone = levelRisk.clone();
        assertTrue(levelRisk.equals(clone));
        clone.increment(14);
        assertFalse(levelRisk.equals(clone));
    }

    @Test
    public void testPrintNameMax() throws Exception {
        LevelRisk levelRisk = new LevelRisk("NONE", 10, 20);
        levelRisk.increment(11);
        levelRisk.increment(15);
        String result = "NONE=15\n";
        assertTrue(levelRisk.printNameMax().equals(result));
    }

    @Test
    public void testToString() throws Exception {
        LevelRisk levelRisk = new LevelRisk("NONE", 10, 20);
        levelRisk.increment(11);
        levelRisk.increment(15);
        String result = "NONE: 2 groups;\n";
        assertTrue(levelRisk.toString().equals(result));
    }
}