package Emergency.prevention.system;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class GroupTest {
    @Test
    public void testPrintNameMax() throws Exception {
        Group group = new Group();
        String result = "NONE=0\n" +
                "MINOR=0\n" +
                "NORMAL=0\n" +
                "MAJOR=0\n" +
                "CRITICAL=0\n";
        assertTrue(result.equals(group.printNameMax()));
    }

    @Test
    public void testToString() throws Exception {
        Group group = new Group();
        String result = "NONE: 0 groups;\n" +
                "MINOR: 0 groups;\n" +
                "NORMAL: 0 groups;\n" +
                "MAJOR: 0 groups;\n" +
                "CRITICAL: 0 groups;\n";
        assertTrue(result.equals(group.toString()));
    }

    @Test
    public void testNoneAddRisk() throws Exception {
        Group none = new Group();
        none.addRisk(1);
        none.addRisk(2);
        String countResult = "NONE: 2 groups;\n";
        assertTrue(countResult.equals(none.getRisk(0).toString()));
        String maxResult = "NONE=2\n";
        assertTrue(maxResult.equals(none.getRisk(0).printNameMax()));
    }

    @Test
    public void testMinorAddRisk() throws Exception {
        Group minor = new Group();
        minor.addRisk(3);
        minor.addRisk(3);
        String result = "MINOR: 2 groups;\n";
        assertTrue(result.equals(minor.getRisk(1).toString()));
        String maxResult = "MINOR=3\n";
        assertTrue(maxResult.equals(minor.getRisk(1).printNameMax()));
    }

    @Test
    public void testNormalAddRisk() throws Exception {
        Group normal = new Group();
        normal.addRisk(7);
        normal.addRisk(6);
        normal.addRisk(5);
        String result = "NORMAL: 3 groups;\n";
        assertTrue(result.equals(normal.getRisk(2).toString()));
        String maxResult = "NORMAL=7\n";
        assertTrue(maxResult.equals(normal.getRisk(2).printNameMax()));
    }

    @Test
    public void testMajorAddRisk() throws Exception {
        Group major = new Group();
        major.addRisk(8);
        major.addRisk(13);
        String result = "MAJOR: 2 groups;\n";
        assertTrue(result.equals(major.getRisk(3).toString()));
        String maxResult = "MAJOR=13\n";
        assertTrue(maxResult.equals(major.getRisk(3).printNameMax()));
    }

    @Test
    public void testCriticalAddRisk() throws Exception {
        Group critical = new Group();
        critical.addRisk(14);
        critical.addRisk(100);
        String result = "CRITICAL: 2 groups;\n";
        assertTrue(result.equals(critical.getRisk(4).toString()));
        String maxResult = "CRITICAL=100\n";
        assertTrue(maxResult.equals(critical.getRisk(4).printNameMax()));
    }

    @Test
    public void testAddRisk() throws Exception {
        Group group = new Group();
        group.addRisk(1);
        group.addRisk(2);
        group.addRisk(5);
        group.addRisk(5);
        group.addRisk(5);
        group.addRisk(13);
        group.addRisk(14);
        group.addRisk(100);
        String countResult = "NONE: 2 groups;\n" +
                "MINOR: 0 groups;\n" +
                "NORMAL: 3 groups;\n" +
                "MAJOR: 1 groups;\n" +
                "CRITICAL: 2 groups;\n";
        assertTrue(countResult.equals(group.toString()));
        String maxResult = "NONE=2\n" +
                "MINOR=0\n" +
                "NORMAL=5\n" +
                "MAJOR=13\n" +
                "CRITICAL=100\n";
        assertTrue(maxResult.equals(group.printNameMax()));
    }


    @Test
    public void testReflexivityEquals() throws Exception {
        Group group = new Group();
        group.addRisk(11);
        group.addRisk(15);
        assertTrue(group.equals(group));
    }

    @Test
    public void testDifferentEquals() throws Exception {
        Group first = new Group();
        Group second = new Group();
        first.addRisk(2);
        assertFalse(first.equals(second));
        assertFalse(second.equals(first));
    }


    @Test
    public void testClone() throws Exception {
        Group group = new Group();
        group.addRisk(1);
        group.addRisk(2);
        Group clone = group.clone();
        assertTrue(group.equals(clone));
        clone.addRisk(4);
        assertFalse(group.equals(clone));
    }
}