package CinemaRoomRestService.RestService.api.mappers;

import CinemaRoomRestService.RestService.api.dto.CinemaRoomDTO;
import CinemaRoomRestService.RestService.domain.entity.CinemaRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CinemaRoomMapper {

    @Autowired
    SeatMapper seatMapper;

    public CinemaRoomDTO toCinemaRoomDTO(CinemaRoom cinemaRoom) {
        return CinemaRoomDTO.builder()
                .allSeats(cinemaRoom.getAllSeats().stream()
                        .map(seat -> seatMapper.toSeatDTO(seat))
                        .collect(Collectors.toList()))
                .build();
    }
}