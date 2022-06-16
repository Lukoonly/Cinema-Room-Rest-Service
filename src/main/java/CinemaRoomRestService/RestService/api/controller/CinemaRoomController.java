package CinemaRoomRestService.RestService.api.controller;

import CinemaRoomRestService.RestService.api.dto.StatisticsDTO;
import CinemaRoomRestService.RestService.api.dto.CinemaRoomDTO;
import CinemaRoomRestService.RestService.api.dto.TokenOfSeatDTO;
import CinemaRoomRestService.RestService.api.mappers.CinemaRoomMapper;
import CinemaRoomRestService.RestService.api.mappers.SeatMapper;
import CinemaRoomRestService.RestService.api.mappers.StatisticsMapper;
import CinemaRoomRestService.RestService.api.mappers.TokenOfSeatMapper;
import CinemaRoomRestService.RestService.service.BookingService;
import CinemaRoomRestService.RestService.domain.entity.Seat;
import CinemaRoomRestService.RestService.domain.entity.TokenOfSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CinemaRoomController {

    private final BookingService bookingService;
    @Autowired
    SeatMapper seatMapper;
    @Autowired
    CinemaRoomMapper cinemaRoomMapper;
    @Autowired
    StatisticsMapper statisticsMapper;
    @Autowired
    TokenOfSeatMapper tokenOfSeatMapper;

    @Autowired
    public CinemaRoomController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/seats")
    public CinemaRoomDTO getSeatInfo() {
        return cinemaRoomMapper.toCinemaRoomDTO(bookingService.getSeatInfo());
    }

    @PostMapping("/purchase")
    public @ResponseBody
    TokenOfSeatDTO bookingOfSeat(@RequestBody Seat reqSeat) {
        return tokenOfSeatMapper.toTokenOfSeatDTO(bookingService.bookingOfSeat(reqSeat));
    }

    @PostMapping("/return")
    public @ResponseBody
    CinemaRoomRestService.RestService.api.dto.SeatDTO returnOfSeat(@RequestBody TokenOfSeat reqToken) {
        return seatMapper.toSeatDTO(bookingService.returnOfSeat(reqToken));
    }

    @PostMapping("/stats")
    public @ResponseBody
    StatisticsDTO getStatistics(@RequestParam(required = false) String password) {
        return statisticsMapper.toStatisticsDTO(bookingService.getStatistics(password));
    }
}