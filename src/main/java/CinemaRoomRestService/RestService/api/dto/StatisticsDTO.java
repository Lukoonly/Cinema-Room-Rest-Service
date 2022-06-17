package CinemaRoomRestService.RestService.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StatisticsDTO {
    private int currentIncome;
    private int availableSeats;
    private int purchasedTickets;
}
