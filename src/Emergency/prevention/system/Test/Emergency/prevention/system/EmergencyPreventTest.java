package Emergency.prevention.system;

import Matrix.Matrix;
import Matrix.Size;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmergencyPreventTest {

    @Test
    public void testOneFillFactor() throws Exception {
        EmergencyPrevent emergencyPrevent = new EmergencyPrevent(new Size(4, 4), 1);
        boolean[][] result = {{true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true}};
        Matrix matrixResult = new Matrix(result);
        Group group = new Group();
        group.addRisk(16);
        assertTrue(emergencyPrevent.getRisks().equals(group));
        assertTrue(emergencyPrevent.getSector().equals(matrixResult));
    }

    @Test
    public void testZeroFillFactor() throws Exception {
        EmergencyPrevent emergencyPrevent = new EmergencyPrevent(new Size(4, 4), 0);
        boolean[][] result = {{false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}};
        Matrix matrixResult = new Matrix(result);
        Group group = new Group();
        assertTrue(emergencyPrevent.getRisks().equals(group));
        assertTrue(emergencyPrevent.getSector().equals(matrixResult));
    }

    @Test
    public void testSquareRangeGroup() throws Exception {
        boolean[][] result = {{true, true, false, false},
                {false, false, true, false},
                {false, true, true, true},
                {false, false, true, true}};
        Matrix matrixResult = new Matrix(result);
        EmergencyPrevent emergencyPrevent = new EmergencyPrevent(matrixResult);
        Group group = new Group();
        group.addRisk(2);
        group.addRisk(6);
        assertTrue(emergencyPrevent.getRisks().equals(group));
    }

    @Test
    public void testWithParameterRangeGroup() throws Exception {
        EmergencyPrevent emergencyPrevent = new EmergencyPrevent(new Size(2, 2));
        emergencyPrevent.rangeGroup(1);
        Group risks = new Group();
        risks.addRisk(4);
        assertTrue(emergencyPrevent.getRisks().equals(risks));

        emergencyPrevent.rangeGroup(0);
        risks = new Group();
        assertTrue(emergencyPrevent.getRisks().equals(risks));
    }

    @Test
    public void testGetSize() throws Exception {

    }

    @Test
    public void testGetFillFactor() throws Exception {

    }

    @Test
    public void testGetGroup() throws Exception {

    }

    @Test
    public void testGetMatrixFillFactor() throws Exception {

    }

    @Test
    public void testPrintMatrixFillFactor() throws Exception {
        boolean[][] matrix = {{true, true, false, false},
                {false, false, false, false},
                {true, true, false, true},
                {true, false, true, true}};
        Matrix matrixResult = new Matrix(matrix);
        EmergencyPrevent emergencyPrevent = new EmergencyPrevent(matrixResult);
        String result = "Emergency Prevention System\n" +
                "\n" +
                "    0  1  2  3 \n" +
                " 0 |X||X| -  - \n" +
                " 1  -  -  -  - \n" +
                " 2 |X||X| - |X|\n" +
                " 3 |X| - |X||X|\n" +
                "\n" +
                "Risk group report:\n" +
                "\n" +
                "NONE: 1 groups;\n" +
                "MINOR: 2 groups;\n" +
                "NORMAL: 0 groups;\n" +
                "MAJOR: 0 groups;\n" +
                "CRITICAL: 0 groups;\n";
        assertTrue(emergencyPrevent.printMatrixFillFactor().equals(result));
    }

    @Test
    public void testToString() throws Exception {
        boolean[][] matrix = {{true, true, false, true},
                {false, false, true, false},
                {true, true, false, true},
                {true, true, true, true}};
        Matrix matrixResult = new Matrix(matrix);
        EmergencyPrevent emergencyPrevent = new EmergencyPrevent(matrixResult);
        String result = "4 x 4\n" +
                "0.0\n" +
                "NONE=2\n" +
                "MINOR=0\n" +
                "NORMAL=7\n" +
                "MAJOR=0\n" +
                "CRITICAL=0\n" +
                "Emergency Prevention System\n" +
                "\n" +
                "    0  1  2  3 \n" +
                " 0 |X||X| - |X|\n" +
                " 1  -  - |X| - \n" +
                " 2 |X||X| - |X|\n" +
                " 3 |X||X||X||X|\n" +
                "\n" +
                "Risk group report:\n" +
                "\n" +
                "NONE: 3 groups;\n" +
                "MINOR: 0 groups;\n" +
                "NORMAL: 1 groups;\n" +
                "MAJOR: 0 groups;\n" +
                "CRITICAL: 0 groups;\n";
        assertTrue(emergencyPrevent.toString().equals(result));
    }

}