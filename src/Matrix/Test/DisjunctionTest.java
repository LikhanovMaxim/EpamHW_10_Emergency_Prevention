package Matrix;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisjunctionTest {

    @Test
    public void positiveNumberCalculation() throws Exception {
        OperationMatrix operation = new Disjunction();
        assertTrue(operation.calculation(true, true));
    }

    @Test
    public void negativeNumbersCalculation() throws Exception {
        OperationMatrix operation = new Disjunction();
        assertTrue(operation.calculation(true, false));
        assertTrue(operation.calculation(false, true));
    }

    @Test
    public void differentSignCalculation() throws Exception {
        OperationMatrix operation = new Disjunction();
        assertFalse(operation.calculation(false, false));
    }
}