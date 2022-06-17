package CinemaRoomRestService.RestService.api.mappers;

import CinemaRoomRestService.RestService.api.dto.SeatDTO;
import CinemaRoomRestService.RestService.domain.entity.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {

    public SeatDTO toSeatDTO(Seat seat) {
        return SeatDTO.builder()
                .row(seat.getRow())
                .column(seat.getColumn())
                .price(seat.getPrice())
                .build();
    }
}