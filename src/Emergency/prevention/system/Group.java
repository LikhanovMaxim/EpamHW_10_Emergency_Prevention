package Emergency.prevention.system;

public class Group {
    private static String[] name = {"NONE", "MINOR", "NORMAL", "MAJOR", "CRITICAL"};
    private static int[] border = {1, 2, 3, 4, 5, 7, 8, 13, 14, Integer.MAX_VALUE};
    private LevelRisk[] group;

    Group(int size, String[] name, int border[]) {
        group = new LevelRisk[size];
        for (int i = 0, j = 0; i < size; i++, j += 2) {
            group[i] = new LevelRisk(name[i], border[j], border[j + 1]);
        }
    }

    Group(int size) {
        group = new LevelRisk[size];
    }

    Group() {
        group = new LevelRisk[5];
        for (int i = 0, j = 0; i < 5; i++, j += 2) {
            group[i] = new LevelRisk(name[i], border[j], border[j + 1]);
        }
    }

    public int getSize() {
        return group.length;
    }

    public void setRisk(int index, LevelRisk risk) {
        group[index] = risk.clone();
    }

    public LevelRisk getRisk(int index) {
        if (index < 0 || index >= group.length) {
            assert false : "In the function getRisks index(" + index + ") went out for the interval"; //!!!!
        }
        return group[index].clone();
    }

    public void addRisk(int risk) {
        if (risk < 1) {
            assert false : "In the function 'addRisk' risk(" + risk + ") less than one";
            return;
        }
        for (LevelRisk levelRisk : group) {
            levelRisk.increment(risk);
        }
    }

    public String printNameMax() {
        String result = "";
        for (LevelRisk risk : group) {
            result += risk.printNameMax();
        }
        return result;
    }


    @Override
    public Group clone() {
        Group clone = new Group(group.length);
        for (int i = 0; i < group.length; i++) {
            clone.setRisk(i, group[i]);
        }
        return clone;
    }

    public boolean equals(Object obj) {
        Group compare = (Group) obj;
        if (getSize() != compare.getSize()) {
            return false;
        }
        for (int i = 0; i < getSize(); i++) {
            if (!getRisk(i).equals(compare.getRisk(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        for (LevelRisk risk : group) {
            result += risk.toString();
        }
        return result;
    }
}