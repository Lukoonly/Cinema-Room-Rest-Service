package CinemaRoomRestService.RestService.api.dto;

import CinemaRoomRestService.RestService.domain.entity.Seat;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CinemaRoomDTO {
    private List<Seat> allSeats;
}