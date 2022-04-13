package CinemaRoomRestService.RestService.domain.entity;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    public int getCurrentIncome() {
        return currentIncome;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getPurchasedTickets() {
        return purchasedTickets;
    }
}