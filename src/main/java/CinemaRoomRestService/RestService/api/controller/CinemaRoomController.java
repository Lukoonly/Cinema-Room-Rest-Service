package CinemaRoomRestService.RestService.api.controller;

import CinemaRoomRestService.RestService.api.dto.StatisticsDTO;
import CinemaRoomRestService.RestService.api.dto.CinemaRoomDTO;
import CinemaRoomRestService.RestService.api.dto.SeatDTO;
import CinemaRoomRestService.RestService.api.dto.TokenOfSeatDTO;
import CinemaRoomRestService.RestService.api.mapper.SeatMapper;
import CinemaRoomRestService.RestService.service.BookingService;
import CinemaRoomRestService.RestService.domain.entity.Seat;
import CinemaRoomRestService.RestService.domain.entity.TokenOfSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaRoomController {
    BookingService bookingService;
    @Autowired
    SeatMapper mapper;

    @Autowired
    public CinemaRoomController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/seats")
    public CinemaRoomDTO getSeatInfo() {
        return mapper.toCinemaRoomDTO(bookingService.getSeatInfo());
    }

    @PostMapping("/purchase")
    public @ResponseBody
    TokenOfSeatDTO bookingOfSeat(@RequestBody Seat reqSeat) {
        return mapper.toTokenOfSeatDTO(bookingService.bookingOfSeat(reqSeat));
    }

    @PostMapping("/return")
    public @ResponseBody
    SeatDTO returnOfSeat(@RequestBody TokenOfSeat reqToken) {
        return mapper.toSeatDTO(bookingService.returnOfSeat(reqToken));
    }

    @PostMapping("/stats")
    public @ResponseBody
    StatisticsDTO getStatistics(@RequestParam(required = false) String password) {
        return mapper.toStatisticsDTO(bookingService.getStatistics(password));
    }
}