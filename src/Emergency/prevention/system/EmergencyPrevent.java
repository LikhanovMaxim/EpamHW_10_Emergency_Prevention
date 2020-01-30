package Emergency.prevention.system;

import Matrix.Matrix;
import Matrix.Position;
import Matrix.Size;

import java.util.Stack;

public class EmergencyPrevent {
    private Matrix sector;
    private Group risks;
    private double fillFactor;
    Stack<Position> positions;

    public EmergencyPrevent(Matrix sectorObservation) { //уже заполненная матрица
        assert !(sectorObservation == null) : "In the constructor EmergencyPrevent sectorObservation=null";
        risks = new Group();
        this.sector = sectorObservation.clone();
        rangeGroup();
    }

    public EmergencyPrevent(Size fieldObservation, double fillFactor) {
        if (fillFactor < 0 || fillFactor > 1) {
            assert false : "In the constructor EmergencyPrevent fillFactor(" + fillFactor + ")";
        }
        risks = new Group();
        this.fillFactor = fillFactor;
        sector = new Matrix(fieldObservation);
        fillMatrix();
        rangeGroup();
    }

    public EmergencyPrevent(Size fieldObservation) { //предполагаем, что размер не будет меняться ->  use rangeGroup(double fillFactor)
        risks = new Group();
        fillFactor = -1;
        sector = new Matrix(fieldObservation);
    }

    public Size getSize() {
        return sector.getSize().clone();
    }

    public double getFillFactor() {
        return fillFactor;
    }

    public Group getRisks() {
        return risks.clone();
    }

    public Matrix getSector() {
        return sector.clone();
    }

    private void fillMatrix() {
        for (int row = 0; row < sector.getSize().getRow(); row++) {
            for (int column = 0; column < sector.getSize().getColumn(); column++) {
                if (fillFactor + Math.random() > 1) {
                    sector.setElement(new Position(row, column), true);
                } else {
                    sector.setElement(new Position(row, column), false);
                }
            }
        }
    }

    public void rangeGroup(double fillFactor) {
        if (fillFactor < 0 || fillFactor > 1) {
            assert false : "In the function rangeGroup fillFactor(" + fillFactor + ")";
        }
        risks = new Group();
        this.fillFactor = fillFactor;
        fillMatrix();
        rangeGroup();
    }

    private void rangeGroup() {
        Matrix copySector = sector.clone();
        for (int row = 0; row < sector.getSize().getRow(); row++) {
            for (int column = 0; column < sector.getSize().getColumn(); column++) {
                if (sector.getElement(new Position(row, column))) {
                    exploreGroup(new Position(row, column));
                }
            }
        }
        sector = copySector.clone();
    }

    private void exploreGroup(Position position) {
        Position cur;
        int count;
        positions = new Stack<>();
        positions.push(position);
        sector.setElement(position, false);
        for (count = 0; !positions.empty(); count++) {
            cur = positions.pop();
            positionsAround(cur);
        }
        risks.addRisk(count);
    }

    private void positionsAround(Position cur) {//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (sector.getSize().entryPosition(cur.getRow(), cur.getColumn() - 1) && sector.getElement(new Position(cur.getRow(), cur.getColumn() - 1))) {
            positions.push(new Position(cur.getRow(), cur.getColumn() - 1));
            sector.setElement(new Position(cur.getRow(), cur.getColumn() - 1), false);
        }
        if (sector.getSize().entryPosition(cur.getRow(), cur.getColumn() + 1) && sector.getElement(new Position(cur.getRow(), cur.getColumn() + 1))) {
            positions.push(new Position(cur.getRow(), cur.getColumn() + 1));
            sector.setElement(new Position(cur.getRow(), cur.getColumn() + 1), false);
        }
        if (sector.getSize().entryPosition(cur.getRow() - 1, cur.getColumn()) && sector.getElement(new Position(cur.getRow() - 1, cur.getColumn()))) {
            positions.push(new Position(cur.getRow() - 1, cur.getColumn()));
            sector.setElement(new Position(cur.getRow() - 1, cur.getColumn()), false);
        }
        if (sector.getSize().entryPosition(cur.getRow() + 1, cur.getColumn()) && sector.getElement(new Position(cur.getRow() + 1, cur.getColumn()))) {
            positions.push(new Position(cur.getRow() + 1, cur.getColumn()));
            sector.setElement(new Position(cur.getRow() + 1, cur.getColumn()), false);
        }
    }


    public String printMatrixFillFactor() {
        if (fillFactor == -1) {
            return "Fill_Factor not defined. Please use the function 'rangeGroup(double fillFactor)'";
        }
        String result = "Emergency Prevention System\n\n   ";
        for (int column = 0; column < sector.getSize().getColumn(); column++) {
            result += " " + column + " ";
        }
        result += "\n";
        for (int row = 0; row < sector.getSize().getRow(); row++) {
            result += " " + row + " ";
            for (int column = 0; column < sector.getSize().getColumn(); column++) {
                if (sector.getElement(new Position(row, column))) {
                    result += "|X|";
                } else {
                    result += " - ";
                }
            }
            result += "\n";
        }
        result += "\nRisk group report:\n\n";
        result += risks.toString();
        return result;
    }

    @Override
    public String toString() {
        if (fillFactor == -1) {
            return "Fill_Factor not defined. Please use the function 'rangeGroup(double fillFactor)'";
        }
        String result = sector.getSize().getRow() + " x " + sector.getSize().getColumn() + "\n";
        result += fillFactor + "\n";
        result += risks.printNameMax();
        result += printMatrixFillFactor();
        return result;
    }
}
