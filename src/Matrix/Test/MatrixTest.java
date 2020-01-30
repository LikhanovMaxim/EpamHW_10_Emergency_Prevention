package Matrix;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatrixTest {
    @Test
    public void testMatrix() throws Exception {
        Matrix mat = new Matrix(new Size(2, 2));
        boolean[][] resultMat = {{false, false},
                {false, false}};
        Matrix result = new Matrix(resultMat);
        assertTrue(mat.equals(result));
    }

    @Test
    public void defaultConstructionMatrix() throws Exception {
        Size size = new Size();
        Matrix mat = new Matrix(size);
        boolean[][] resultMat = new boolean[1][1];
        Matrix result = new Matrix(resultMat);
        assertTrue(mat.equals(result));
    }

    @Test
    public void testGetElement() throws Exception {
        boolean[][] matrix = {{false, false},
                {false, true}};
        Matrix mat = new Matrix(matrix);
        assertTrue(mat.getElement(new Position(1, 1)));
    }

    @Test
    public void testSetElement() throws Exception {
        boolean[][] mat = {{true, true, true},
                {false, true, true}};
        Matrix matrix = new Matrix(mat);
        boolean[][] resultMat = {{true, true, true},
                {true, true, true}};
        Matrix result = new Matrix(resultMat);
        matrix.setElement(new Position(1, 0), true);
        assertTrue(matrix.equals(result));
    }

    @Test
    public void testGetSize() throws Exception {
        boolean[][] mat = {{true, true, true},
                {false, true, true}};
        Matrix matrix = new Matrix(mat);
        Size size = matrix.getSize();
        assertTrue(size.getRow() == 2);
        assertTrue(size.getColumn() == 3);
    }

    @Test
    public void emptyEquals() throws Exception {
        Matrix mat = new Matrix(new Size());
        boolean[][] matEmpty = {{false}};
        Matrix matrixEmpty = new Matrix(matEmpty);
        assertTrue(mat.equals(matrixEmpty));
    }

    @Test
    public void reflexiveEquals() throws Exception {
        boolean[][] matA = {{true, true, true},
                {true, true, true},
                {true, true, true}};
        Matrix result = new Matrix(matA);
        assertTrue(result.equals(result));
    }

    @Test
    public void differDimenEquals() throws Exception {
        boolean[][] square = {{false, false},
                {false, true}};
        boolean[][] rectangular = {{true},
                {true}};
        Matrix squareMat = new Matrix(square);
        Matrix rectangularMat = new Matrix(rectangular);
        assertFalse(squareMat.equals(rectangularMat));
        assertFalse(rectangularMat.equals(squareMat));
    }

    @Test
    public void sameDimenEquals() throws Exception {
        boolean[][] firstSquare = {{true, true, true},
                {true, true, true},
                {true, true, true}};
        boolean[][] secondSquare = {{false, false, false},
                {false, false, false},
                {false, false, false}};
        Matrix firstSquareMat = new Matrix(firstSquare);
        Matrix secondSquareMat = new Matrix(secondSquare);
        assertFalse(firstSquareMat.equals(secondSquareMat));
        assertFalse(secondSquareMat.equals(firstSquareMat));
    }

    @Test
    public void differDimenAddPerformOperation() throws Exception {
        OperationMatrix operation = new Disjunction();
        boolean[][] matA = {{false, false},
                {false, true}};
        Matrix matrixA = new Matrix(matA);
        boolean[][] matB = {{true},
                {true}};
        Matrix matrixB = new Matrix(matB);
        Matrix result = new Matrix(new Size());
        assertTrue(matrixA.perform(matrixB, operation).equals(result));
        matrixA = new Matrix(matA);
        assertTrue(matrixB.perform(matrixA, operation).equals(result));
    }

    @Test
    public void sameDimenAddPerformOperation() throws Exception {
        OperationMatrix operation = new Disjunction();
        boolean[][] matA = {{false, false},
                {true, true}};
        Matrix matrixA = new Matrix(matA);
        boolean[][] matB = {{false, true},
                {false, true}};
        Matrix matrixB = new Matrix(matB);
        boolean[][] result = {{false, true},
                {true, true}};
        Matrix matrixResult = new Matrix(result);
        assertTrue(matrixResult.equals(matrixA.perform(matrixB, operation)));
        matrixA = new Matrix(matA);
        assertTrue(matrixResult.equals(matrixB.perform(matrixA, operation)));
    }

    @Test
    public void firstGetRow() throws Exception {
        boolean[][] matrix = {{false, true, true},
                {true, false, true},
                {true, true, false}};
        Matrix mat = new Matrix(matrix);
        boolean[] result = {false, true, true};
        assertTrue(Arrays.equals(result, mat.getRow(0)));
    }

    @Test
    public void middleGetRow() throws Exception {
        boolean[][] matrix = {{false, true, true},
                {true, false, true},
                {true, true, false}};
        Matrix mat = new Matrix(matrix);
        boolean[] result = {true, false, true};
        assertTrue(Arrays.equals(result, mat.getRow(1)));
    }

    @Test
    public void lastGetRow() throws Exception {
        boolean[][] matrix = {{false, true, true},
                {true, false, true},
                {true, true, false}};
        Matrix mat = new Matrix(matrix);
        boolean[] result = {true, true, false};
        assertTrue(Arrays.equals(result, mat.getRow(2)));
    }

    @Test
    public void firstGetColumn() throws Exception {
        boolean[][] mat = {{false, true, true},
                {true, false, true}};
        Matrix matrix = new Matrix(mat);
        boolean[] result = {false, true};
        assertTrue(Arrays.equals(result, matrix.getColumn(0)));
    }

    @Test
    public void middleGetColumn() throws Exception {
        boolean[][] mat = {{false, true, true},
                {true, false, true}};
        Matrix matrix = new Matrix(mat);
        boolean[] result = {true, false};
        assertTrue(Arrays.equals(result, matrix.getColumn(1)));
    }

    @Test
    public void lastGetColumn() throws Exception {
        boolean[][] mat = {{false, true, true},
                {true, false, true}};
        Matrix matrix = new Matrix(mat);
        boolean[] result = {true, true};
        assertTrue(Arrays.equals(result, matrix.getColumn(2)));
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        boolean[][] matA = {{false, true, true},
                {true, false, true},
                {true, true, false}};
        Matrix matrixA = new Matrix(matA);
        Matrix result = matrixA.clone();
        assertTrue(result.equals(matrixA));
        result.setElement(new Position(1, 1), true);
        assertFalse(result.equals(matrixA));
    }
}
