package cinema;

public class Seat {
    private final int row;
    private final int column;
    private int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
