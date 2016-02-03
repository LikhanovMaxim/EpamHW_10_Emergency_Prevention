package Matrix;

public class Position {
    private int row;
    private int column;

    Position() {
        row = 0;
        column = 0;
    }

    public Position(int row, int column) {
        if (row < 0 || column < 0) {
            this.row = 0;
            this.column = 0;
            assert false : "Wrong size position";
        } else {
            this.row = row;
            this.column = column;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean entrySize(Size size) {
        if (row < size.getRow() && column < size.getColumn()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getRow() + " " + getColumn();
    }
}
