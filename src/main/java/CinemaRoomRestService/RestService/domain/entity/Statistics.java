package CinemaRoomRestService.RestService.domain.entity;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
public class Statistics {
    private int currentIncome;
    private int availableSeats;
    private int purchasedTickets;

    @Autowired
    public Statistics(List<Seat> list) {
        availableSeats = list.size();
        for (Seat current : list) {
            if (!current.isFree) {
                availableSeats--;
                purchasedTickets++;
                currentIncome += current.getPrice();
            }
        }
    }
}