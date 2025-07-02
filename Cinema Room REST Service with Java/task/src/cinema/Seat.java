package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    private final String id;
    private final int row;
    private final int column;
    private int price;

    private boolean isAvailable = true;

    public Seat(int row, int column) {
        id = "r" + row + "s" + column;
        this.row = row;
        this.column = column;
        this.price = price;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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
