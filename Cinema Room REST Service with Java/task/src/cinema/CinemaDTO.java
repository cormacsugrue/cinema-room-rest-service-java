package cinema;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CinemaDTO {
    private final int rows;
    private final int columns;
    private final List<SeatDTO> seats;

    public CinemaDTO(Cinema cinema) {
        this.rows = cinema.getRows();
        this.columns = cinema.getColumns();
        this.seats = cinema.getSeats().values().stream()
                .filter(seat -> seat.isAvailable())
                .sorted(Comparator
                        .comparing((Seat seat) -> seat.getPosition().getRow())
                        .thenComparing((Seat seat) -> seat.getPosition().getColumn()))
                .map(seat -> new SeatDTO(seat))
                .collect(Collectors.toList());
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<SeatDTO> getSeats() {
        return seats;
    }
}
