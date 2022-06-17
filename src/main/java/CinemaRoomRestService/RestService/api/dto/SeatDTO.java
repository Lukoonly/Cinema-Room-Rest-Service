package CinemaRoomRestService.RestService.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SeatDTO {
    private int row;
    private int column;
    private int price;
}
