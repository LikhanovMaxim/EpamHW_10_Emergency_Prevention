package Emergency.prevention.system;

import org.apache.commons.cli.ParseException;

public class App {
    public static String main(String[] args) {
        EmergencyPrevent emergencyPrevent = null;
        try {
            Parser parser = new Parser();
            parser.emergencyPrevent(args);
            emergencyPrevent = new EmergencyPrevent(parser.getSize(), parser.getFillFactor());
        } catch (ParseException e) {
            System.out.println("'" + args + "' no commands of this type. See '--help'.");
        } finally {
            assert emergencyPrevent != null;
            return emergencyPrevent.toString();
        }

    }
}
