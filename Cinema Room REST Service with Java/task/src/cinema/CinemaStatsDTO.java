package cinema;

import java.util.Map;
import java.util.UUID;

public class CinemaStatsDTO {
    private final int income;
    private final int available;
    private final int purchased;

    public CinemaStatsDTO(Map<UUID, Ticket> tickets, Cinema cinema) {
        this.income = tickets.values().stream()
                .map(Ticket::getSeat)
                .mapToInt(Seat::getPrice)
                .sum();
        this.available = (int) cinema.getSeats().values().stream()
                .filter(Seat::isAvailable)
                .count();
        this.purchased = tickets.size();
    }

    public int getIncome() {
        return income;
    }

    public int getAvailable() {
        return available;
    }

    public int getPurchased() {
        return purchased;
    }
}
