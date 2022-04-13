package CinemaRoomRestService.RestService.domain.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CinemaRoom {
    private final int TOTAL_ROWS = 9;
    private final int TOTAL_COLUMNS = 9;
    private final List<Seat> ALL_SEATS = Arrays.asList(new Seat[TOTAL_COLUMNS * TOTAL_ROWS]);
    private List<TokenOfSeat> activeTickets = new ArrayList<>();

    public CinemaRoom() {
        int counter = 0;
        for (int i = 1; i < TOTAL_ROWS + 1; i++) {
            for (int j = 1; j < TOTAL_COLUMNS + 1; j++) {
                ALL_SEATS.set(counter++, new Seat(i, j));
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

    public List<Seat> getAllSeats() {
        return ALL_SEATS;
    }

    public List<TokenOfSeat> getActiveTickets() {
        return activeTickets;
    }
}