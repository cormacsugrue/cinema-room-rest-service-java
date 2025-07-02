package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Cinema {
    private final int rows;
    private final int columns;
    private final ConcurrentMap<String, Seat> seats;

    private final int FRONT_ROW_SEAT_PRICE = 10;
    private final int BACK_ROW_SEAT_PRICE = 8;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public ConcurrentMap<String, Seat> getSeats() {
        return seats;
    }

    public Cinema(int rows, int columns, int rowPricingDivide) {
        this.rows = rows;
        this.columns = columns;
        seats = instantiateSeats();
        setSeatRowPrice(0, rowPricingDivide, FRONT_ROW_SEAT_PRICE);
        setSeatRowPrice(rowPricingDivide, rows, BACK_ROW_SEAT_PRICE);
    }

    private ConcurrentMap<String, Seat> instantiateSeats() {
        ConcurrentMap<String, Seat> seats = new ConcurrentHashMap<>();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                Seat nextSeat = new Seat(i, j);
                seats.put(nextSeat.getId(), nextSeat);
            }
        }
        return seats;
    }

    private void setSeatRowPrice(int fromRow, int toRow, int price) {
        seats.values().stream().filter(x -> x.getRow() > fromRow && x.getRow() <= toRow)
                .forEach(x -> x.setPrice(price));
    }
}
