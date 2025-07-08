package cinema;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class CinemaController {
    private final int CINEMA_ROW_AMOUNT = 9;
    private final int CINEMA_COLUMN_AMOUNT = 9;
    Cinema cinema = new Cinema(CINEMA_ROW_AMOUNT, CINEMA_COLUMN_AMOUNT, 4);
    Map<UUID, Ticket> tickets = new HashMap<>();


    @GetMapping("/seats")
    public CinemaDTO getSeats() {
        return new CinemaDTO(cinema);
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTicket(@RequestBody @Valid SeatPosition seatPosition) {

        // Retrieve seat at seatPosition and format to seatDTO
        Seat seat = cinema.getSeats().get(seatPosition);

        if (seat.isAvailable()) {
            // response 200 successful and return SeatDTO
            seat.setAvailable(false);
            Ticket ticket = new Ticket(seat);
            tickets.put(ticket.getToken(),ticket);
            TicketDTO ticketDTO = new TicketDTO(ticket);
            return ResponseEntity
                    .ok(ticketDTO);

        }

        throw new TicketNotAvailableException("The ticket has been already purchased!");
    }

}
