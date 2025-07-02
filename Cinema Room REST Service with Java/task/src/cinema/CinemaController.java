package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CinemaController {
    Cinema cinema = new Cinema(9, 9, 4);


    @GetMapping("/seats")
    public CinemaDTO getSeats() {
        return new CinemaDTO(cinema);
    }



}
