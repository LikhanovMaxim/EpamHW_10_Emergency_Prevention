package Emergency.prevention.system;

import Matrix.Size;
import org.apache.commons.cli.*;

public class Parser {
    private Size size;
    private double fillFactor;

    public void emergencyPrevent(String[] args) throws ParseException {
        if (args == null || args.length == 0) {
            assert false : "Wrong args in function 'divideBinaryOperation'";
        }
        Options options = new Options();
        options.addOption(OptionBuilder.
                withLongOpt("row").
                isRequired().
                withType(PatternOptionBuilder.NUMBER_VALUE).
                hasArg().
                withDescription("row").
                withArgName("row").
                create("r"));
        options.addOption(OptionBuilder.
                withLongOpt("column").
                isRequired().
                withType(PatternOptionBuilder.NUMBER_VALUE).
                hasArg().
                withDescription("column").
                withArgName("column").
                create("c"));
        options.addOption(OptionBuilder.
                withLongOpt("fill_factor").
                isRequired().
                withType(PatternOptionBuilder.NUMBER_VALUE).
                hasArg().
                withDescription("fill factor").
                withArgName("fillFactor").
                create("f"));
        CommandLineParser commandLineParser = new PosixParser();
        CommandLine commandLine = commandLineParser.parse(options, args);
        int row = Integer.parseInt(commandLine.getOptionValue("row"));
        int column = Integer.parseInt(commandLine.getOptionValue("column"));
        size = new Size(row, column);
        fillFactor = Double.parseDouble(commandLine.getOptionValue("fill_factor"));
        if (fillFactor < 0 || fillFactor > 1) {
            throw new ParseException("fill factor(" + fillFactor + ") is not int the [0;1]");
        }
    }

    public Size getSize() {
        return size;
    }

    public double getFillFactor() {
        return fillFactor;
    }
}
