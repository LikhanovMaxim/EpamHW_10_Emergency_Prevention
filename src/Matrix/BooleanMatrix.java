package Matrix;

public interface BooleanMatrix {
    Size getSize();

    boolean getElement(Position position);

    boolean equals(Object compareMatrix);

    void setElement(Position position, boolean element);

    Matrix perform(Matrix other, OperationMatrix operationMatrix);

    boolean[] getRow(int rowIndex);

    boolean[] getColumn(int columnIndex);

}
