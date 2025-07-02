package cinema;

import java.util.Objects;

public class SeatPosition {
    private int row;
    private int column;

    public SeatPosition() {
    }

    public SeatPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SeatPosition that)) return false;

        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
