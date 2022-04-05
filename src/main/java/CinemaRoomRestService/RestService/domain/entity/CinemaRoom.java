package CinemaRoomRestService.RestService.domain.entity;

import org.springframework.stereotype.Component;

import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CinemaRoom {
    private final int TOTAL_ROWS = 9;
    private final int TOTAL_COLUMNS = 9;
    private final Seat[] ALL_SEATS = new Seat[TOTAL_COLUMNS * TOTAL_ROWS];
    private CopyOnWriteArrayList<TokenOfSeat> activeTickets = new CopyOnWriteArrayList<>();
    public Statistics stat = new Statistics(getAllSeats().length);

    public CinemaRoom() {
        int counter = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                ALL_SEATS[counter++] = new Seat(i, j);
            }
        }
    }

    public boolean isContainToken(String token) {
        return activeTickets.stream().anyMatch(curToken -> curToken.getToken().equals(token));
    }

    public int getTotalRows() {
        return TOTAL_ROWS;
    }

    public int getTotalColumns() {
        return TOTAL_COLUMNS;
    }

    public Seat[] getAllSeats() {
        return ALL_SEATS;
    }

    public CopyOnWriteArrayList<TokenOfSeat> getActiveTickets() {
        return activeTickets;
    }
}