package Matrix;

public class Size {
    private int row;
    private int column;

    Size() {
        row = 1;
        column = 1;
    }

    public Size(int row, int column) {
        if (row < 1 || column < 1) {
            this.row = 1;
            this.column = 1;
            assert false : "Wrong size matrix";
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

    public boolean equals(Object compareSize) {
        Size compare = (Size) compareSize;
        return row == compare.getRow() && column == compare.getColumn();
    }

    public boolean checkSquare() {
        return row == column;
    }

    public boolean entryPosition(int row, int column) {
        return (row >= 0 && column >= 0) && (row < this.row && column < this.column);
    }

    @Override
    public Size clone() {
        return new Size(this.row, this.column);
    }
}
