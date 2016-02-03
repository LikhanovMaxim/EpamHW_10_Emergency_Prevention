package Emergency.prevention.system;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void testZeroMain() throws Exception {
        String[] args = {"-r", "3", "-c", "3", "-f", "0"};
        String result = "3 x 3\n" +
                "0.0\n" +
                "NONE=0\n" +
                "MINOR=0\n" +
                "NORMAL=0\n" +
                "MAJOR=0\n" +
                "CRITICAL=0\n" +
                "Emergency Prevention System\n" +
                "\n" +
                "    0  1  2 \n" +
                " 0  -  -  - \n" +
                " 1  -  -  - \n" +
                " 2  -  -  - \n" +
                "\n" +
                "Risk group report:\n" +
                "\n" +
                "NONE: 0 groups;\n" +
                "MINOR: 0 groups;\n" +
                "NORMAL: 0 groups;\n" +
                "MAJOR: 0 groups;\n" +
                "CRITICAL: 0 groups;\n";
        assertTrue(App.main(args).equals(result));
    }

    @Test
    public void testOneMain() throws Exception {
        String[] args = {"-r", "4", "-c", "2", "-f", "1"};
        String result = "4 x 2\n" +
                "1.0\n" +
                "NONE=0\n" +
                "MINOR=0\n" +
                "NORMAL=0\n" +
                "MAJOR=8\n" +
                "CRITICAL=0\n" +
                "Emergency Prevention System\n" +
                "\n" +
                "    0  1 \n" +
                " 0 |X||X|\n" +
                " 1 |X||X|\n" +
                " 2 |X||X|\n" +
                " 3 |X||X|\n" +
                "\n" +
                "Risk group report:\n" +
                "\n" +
                "NONE: 0 groups;\n" +
                "MINOR: 0 groups;\n" +
                "NORMAL: 0 groups;\n" +
                "MAJOR: 1 groups;\n" +
                "CRITICAL: 0 groups;\n";
        assertTrue(App.main(args).equals(result));
    }
}