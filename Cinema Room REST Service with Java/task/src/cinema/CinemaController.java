package cinema;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CinemaController {
    private final int CINEMA_ROW_AMOUNT = 9;
    private final int CINEMA_COLUMN_AMOUNT = 9;
    Cinema cinema = new Cinema(CINEMA_ROW_AMOUNT, CINEMA_COLUMN_AMOUNT, 4);


    @GetMapping("/seats")
    public CinemaDTO getSeats() {
        return new CinemaDTO(cinema);
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTicket(@RequestBody @Valid SeatPosition seatPosition) {

//        // validate the request param
//        if (seatPosition.getRow() < 1 || seatPosition.getRow() > CINEMA_ROW_AMOUNT || seatPosition.getColumn() < 1 || seatPosition.getColumn() > CINEMA_COLUMN_AMOUNT) {
//            // return 400 status code
//            return ResponseEntity
//                    .badRequest()
//                    .body(Map.of("error", "The number of a row or a column is out of bounds!"));
//        }

        // Retrieve seat at seatPosition anf format to seatDTO
        Seat seat = cinema.getSeats().get(seatPosition);
        SeatDTO seatDTO = new SeatDTO(seat);

        if (seat.isAvailable()) {
            // response 200 successful and return SeatDTO
            seat.setAvailable(false);
            return ResponseEntity
                    .ok(seatDTO);

        }

        throw new TicketNotAvailableException("The ticket has been already purchased!");
    }

}
