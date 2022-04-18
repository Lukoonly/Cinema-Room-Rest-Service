package CinemaRoomRestService.RestService.api.mapper;

import CinemaRoomRestService.RestService.api.dto.StatisticsDTO;
import CinemaRoomRestService.RestService.domain.entity.CinemaRoom;
import CinemaRoomRestService.RestService.domain.entity.Seat;
import CinemaRoomRestService.RestService.domain.entity.Statistics;
import CinemaRoomRestService.RestService.domain.entity.TokenOfSeat;
import CinemaRoomRestService.RestService.api.dto.CinemaRoomDTO;
import CinemaRoomRestService.RestService.api.dto.SeatDTO;
import CinemaRoomRestService.RestService.api.dto.TokenOfSeatDTO;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {

    public CinemaRoomDTO toCinemaRoomDTO(CinemaRoom cinemaRoom) {
        return CinemaRoomDTO
                .builder()
                .allSeats(cinemaRoom.getAllSeats())
                .build();
    }

    public TokenOfSeatDTO toTokenOfSeatDTO(TokenOfSeat tokenOfSeat) {
        return TokenOfSeatDTO.builder()
                .token(tokenOfSeat.getToken())
                .ticket(toSeatDTO(tokenOfSeat.getTicket()))
                .build();
    }

    public SeatDTO toSeatDTO(Seat seat) {
        return SeatDTO.builder()
                .row(seat.getRow())
                .column(seat.getColumn())
                .price(seat.getPrice())
                .build();
    }

    public StatisticsDTO toStatisticsDTO(Statistics statistics) {
        return StatisticsDTO
                .builder()
                .availableSeats(statistics.getAvailableSeats())
                .currentIncome(statistics.getCurrentIncome())
                .purchasedTickets(statistics.getPurchasedTickets())
                .build();
    }
}
