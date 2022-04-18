package CinemaRoomRestService.RestService.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenOfSeatDTO {
    private String token;
    private SeatDTO ticket;
}
