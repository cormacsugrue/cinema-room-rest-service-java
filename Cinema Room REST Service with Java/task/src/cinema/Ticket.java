package cinema;

import java.util.UUID;

public class Ticket {
    private final UUID token;
    private final Seat seat;

    public Ticket(Seat seat) {
        token = UUID.randomUUID();
        this.seat = seat;
    }

    public UUID getToken() {
        return token;
    }

    public Seat getSeat() {
        return seat;
    }
}
