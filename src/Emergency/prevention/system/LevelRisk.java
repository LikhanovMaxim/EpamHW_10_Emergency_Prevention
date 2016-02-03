package Emergency.prevention.system;

public class LevelRisk {
    private String name;
    private int count;
    private int max;
    private int leftBound;
    private int rightBound;

    public LevelRisk(String name, int leftBound, int rightBound) {
        if (name == null) {
            assert false : "In the constructor LevelRisk name=null";
        }
        this.name = name;
        if (leftBound > rightBound) {
            assert false : "In the constructor LevelRisk left bound (" + leftBound + ") less than right bound (" + rightBound + ")";
        }
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        count = 0;
        max = 0;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public String getName() {
        return name;
    }

    public void increment(int element) {
        if (element >= leftBound && element <= rightBound) {
            if (this.max < element) {
                this.max = element;
            }
            count++;
        }
    }

    public String printNameMax() {
        return getName() + "=" + getMax() + "\n";
    }

    @Override
    public String toString() {
        return getName() + ": " + getCount() + " groups;\n";
    }

    @Override
    public LevelRisk clone() {
        LevelRisk clone = new LevelRisk(getName(), leftBound, rightBound);
        clone.setCount(count);
        clone.setMax(max);
        return clone;
    }

    public boolean equals(Object obj) {
        LevelRisk compare = (LevelRisk) obj;
        return name.equals(compare.getName()) && count == compare.getCount() && max == compare.getMax();
    }
}
