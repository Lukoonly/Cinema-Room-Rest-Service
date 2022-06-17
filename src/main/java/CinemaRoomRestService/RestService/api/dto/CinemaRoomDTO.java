package CinemaRoomRestService.RestService.api.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CinemaRoomDTO {
    private List<SeatDTO> allSeats;
}