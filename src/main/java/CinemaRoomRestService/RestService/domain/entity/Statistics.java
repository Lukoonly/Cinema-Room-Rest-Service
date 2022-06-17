package CinemaRoomRestService.RestService.domain.entity;

import lombok.Getter;
import java.util.List;

@Getter
public class Statistics {

    private static Statistics instance;
    private int currentIncome;
    private int availableSeats;
    private int purchasedTickets;

    public void setInstance(Statistics instance) {
        Statistics.instance = instance;
    }


    public static Statistics getInstance(List<Seat> seats) {
        if (instance == null) {
            instance = new Statistics();
        }
        return instance.setFieldsValue(seats);
    }

    private Statistics setFieldsValue(List<Seat> seats) {
        resetFieldsValue();
        purchasedTickets = (int) seats.stream()
                .filter(seat -> seat.isOccupied)
                .peek(seat -> currentIncome += seat.getPrice())
                .count();
        availableSeats = seats.size() - purchasedTickets;
        return instance;
    }

    private void resetFieldsValue() {
        currentIncome = 0;
        availableSeats = 0;
        purchasedTickets = 0;
    }
}