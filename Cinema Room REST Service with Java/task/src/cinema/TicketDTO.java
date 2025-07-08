package cinema;

import java.util.Map;
import java.util.UUID;

public class TicketDTO {
    private final UUID token;
    private final SeatDTO ticket;

    public TicketDTO(Ticket ticket) {
        this.token = ticket.getToken();
        this.ticket = new SeatDTO(ticket.getSeat());
    }

    public UUID getToken() {
        return token;
    }

    public SeatDTO getTicket() {
        return ticket;
    }
}
