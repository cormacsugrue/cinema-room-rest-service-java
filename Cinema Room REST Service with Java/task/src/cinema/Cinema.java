package cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final int rows;
    private final int columns;
    private final List<Seat> seats;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Cinema(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        seats = instantiateSeats();
    }

    private List<Seat> instantiateSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                Seat nextSeat = new Seat(i, j);
                seats.add(nextSeat);
            }
        }
        return seats;
    }
}
