package CinemaRoomRestService.RestService.api.mappers;

import CinemaRoomRestService.RestService.api.dto.StatisticsDTO;
import CinemaRoomRestService.RestService.domain.entity.Statistics;
import org.springframework.stereotype.Component;

@Component
public class StatisticsMapper {

    public StatisticsDTO toStatisticsDTO(Statistics statistics) {
        return StatisticsDTO.builder()
                .availableSeats(statistics.getAvailableSeats())
                .currentIncome(statistics.getCurrentIncome())
                .purchasedTickets(statistics.getPurchasedTickets())
                .build();
    }
}