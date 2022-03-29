package CinemaRoomRestService.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaRoomController {
    BookingService bookingService;

    @Autowired
    public CinemaRoomController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/seats")
    public CinemaRoom getSeatInfo() {
        return bookingService.getSeatInfo();
    }

    @PostMapping("/purchase")
    public @ResponseBody
    ResponseEntity<?> bookingOfSeat(@RequestBody Seat reqSeat) {
        return bookingService.bookingOfSeat(reqSeat);
    }

    @PostMapping("/return")
    public @ResponseBody
    ResponseEntity<?> returnOfSeat(@RequestBody TokenOfSeat reqToken) {
        return bookingService.returnOfSeat(reqToken);
    }

    @PostMapping("/stats")
    public @ResponseBody
    ResponseEntity<?> getStatistics(@RequestParam(required = false) String password) {
        return bookingService.getStatistics(password);
    }
}