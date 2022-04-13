package CinemaRoomRestService.RestService.api.mapper;

import CinemaRoomRestService.RestService.domain.entity.CinemaRoom;
import CinemaRoomRestService.RestService.domain.entity.Seat;
import CinemaRoomRestService.RestService.domain.entity.TokenOfSeat;
import CinemaRoomRestService.RestService.api.dto.CinemaRoomDTO;
import CinemaRoomRestService.RestService.api.dto.SeatDTO;
import CinemaRoomRestService.RestService.api.dto.TokenOfSeatDTO;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {

    public CinemaRoomDTO toCinemaRoomDTO(CinemaRoom cinemaRoom) {
        return new CinemaRoomDTO.Builder()
                .withAllSeat(cinemaRoom.getAllSeats())
                .build();
    }

    public TokenOfSeatDTO toTokenOfSeatDTO(TokenOfSeat tokenOfSeat) {
        return new TokenOfSeatDTO.Builder()
                .withToken(tokenOfSeat.getToken())
                .withTicket(toSeatDTO(tokenOfSeat.getTicket()))
                .build();
    }

    public SeatDTO toSeatDTO(Seat seat) {
        return new SeatDTO.Builder()
                .withRow(seat.getRow())
                .withColumn(seat.getColumn())
                .withPrice(seat.getPrice())
                .build();
    }
}
