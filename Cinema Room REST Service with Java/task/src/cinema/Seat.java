package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    private final SeatPosition position;
    private int price;

    private boolean isAvailable = true;

    public Seat(int row, int column) {
        this.position = new SeatPosition(row, column);
        this.price = price;
    }

    @JsonIgnore
    public boolean isAvailable() {
        return isAvailable;
    }

    public SeatPosition getPosition() {
        return position;
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


}
