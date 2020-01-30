package Matrix;

public class Matrix implements BooleanMatrix {
    private boolean[][] elements;
    private Size size;

    public Matrix(Size size) {
        this.size = new Size(size.getRow(), size.getColumn());
        elements = new boolean[this.size.getRow()][this.size.getColumn()];
    }

    public Matrix(boolean[][] elements) {
        if (elements == null) {
            this.elements = new boolean[1][1];
            this.size = new Size(1, 1);
            return;
        }
        this.size = new Size(elements.length, elements[0].length);
        this.elements = elements.clone();
    }

    @Override
    public Size getSize() {
        return size.clone();
    }

    @Override
    public boolean getElement(Position position) {
        if (position.entrySize(size)) {
            return elements[position.getRow()][position.getColumn()];
        } else {
            assert false : "Wrong position. getElement";
            return false;
        }
    }

    @Override
    public void setElement(Position position, boolean element) {
        if (position.entrySize(size)) {
            elements[position.getRow()][position.getColumn()] = element;
        } else {
            assert false : "Wrong position. setElement";
        }
    }

    @Override
    public boolean equals(Object compareMatrix) {
        Matrix compare = (Matrix) compareMatrix;
        if (compare == null) {
            return false;
        }
        if (elements == null && compare.elements == null) {
            return true;
        }
        if (elements == null || compare.elements == null) {
            return false;
        }
        if (!size.equals(compare.size)) {
            return false;
        }
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                if (getElement(new Position(i, j)) != compare.getElement(new Position(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Matrix perform(Matrix other, OperationMatrix operationMatrix) {
        if (other == null) {
            assert false : "perform. Matrix other = null";
            return null;
        }
        if (other.elements == null) {
            assert false : "perform. Matrix other.elements = null";
            return null;
        }
        if (!size.equals(other.getSize())) {
            return new Matrix(new Size());
        }
        Matrix add = new Matrix(size);
        boolean sum;
        for (int i = 0; i < size.getRow(); i++) {
            for (int j = 0; j < size.getColumn(); j++) {
                sum = operationMatrix.calculation(getElement(new Position(i, j)), other.getElement(new Position(i, j)));
                add.setElement(new Position(i, j), sum);
            }
        }
        return add;
    }


    @Override
    public boolean[] getRow(int rowIndex) {
        if (!(new Position(rowIndex, 0).entrySize(size))) {
            assert false : "Wrong rowIndex";
        }
        return elements[rowIndex].clone();
    }

    @Override
    public boolean[] getColumn(int columnIndex) {
        if (!(new Position(0, columnIndex).entrySize(size))) {
            assert false : "Wrong columnIndex";
        }
        boolean[] columnToMas = new boolean[size.getRow()];
        for (int i = 0; i < elements.length; i++) {
            columnToMas[i] = elements[i][columnIndex];
        }
        return columnToMas;
    }


    @Override
    public String toString() {
        String result = "";
        for (boolean[] element : elements) {
            result += "{";
            for (int columns = 0; columns < elements[0].length; columns++) {
                result += element[columns] + " ";
            }
            result += "}\n";
        }
        result += "";
        return result;
    }

    @Override
    public Matrix clone() {
        Matrix clone = new Matrix(size);
        for (int row = 0; row < size.getRow(); row++) {
            for (int column = 0; column < size.getColumn(); column++) {
                clone.setElement(new Position(row, column), this.getElement(new Position(row, column)));
            }
        }
        return clone;
    }
}

