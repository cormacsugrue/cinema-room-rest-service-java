package cinema;

import java.util.List;
import java.util.stream.Collectors;

public class CinemaDTO {
    private final int rows;
    private final int columns;
    private final List<Seat> seats;

    public CinemaDTO(Cinema cinema) {
        this.rows = cinema.getRows();
        this.columns = cinema.getColumns();
        this.seats = cinema.getSeats().stream()
                .filter(seat -> seat.isAvailable())
                .collect(Collectors.toList());
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
