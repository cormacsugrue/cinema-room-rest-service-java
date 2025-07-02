package cinema;

public class SeatDTO {
    private final int row;
    private final int column;
    private final int price;

    public SeatDTO(Seat seat) {
        this.row = seat.getPosition().getRow();
        this.column = seat.getPosition().getColumn();
        this.price = seat.getPrice();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }
}
