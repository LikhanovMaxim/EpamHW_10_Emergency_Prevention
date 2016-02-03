package Emergency.prevention.system;

import Matrix.Size;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ParserTest {

    @Test
    public void testGetSize() throws Exception {
        String[] args = {"-r", "2", "-c", "2", "-f", "0.5"};
        Parser parser = new Parser();
        parser.emergencyPrevent(args);
        assertTrue(parser.getSize().equals(new Size(2, 2)));
    }

    @Test
    public void testGetFillFactor() throws Exception {
        String[] args = {"-r", "2", "-c", "2", "-f", "0.5"};
        Parser parser = new Parser();
        parser.emergencyPrevent(args);
        assertTrue(parser.getFillFactor() == 0.5);
    }
}