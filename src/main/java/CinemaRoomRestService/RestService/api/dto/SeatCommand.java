package CinemaRoomRestService.RestService.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SeatCommand {
    private int row;
    private int column;
    private int price;
}