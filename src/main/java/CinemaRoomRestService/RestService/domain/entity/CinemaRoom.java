package CinemaRoomRestService.RestService.domain.entity;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter
public class CinemaRoom {
    private final int TOTAL_ROWS = 9;
    private final int TOTAL_COLUMNS = 9;
    private final List<Seat> allSeats = Arrays.asList(new Seat[TOTAL_COLUMNS * TOTAL_ROWS]);
    private final List<TokenOfSeat> activeTickets = new ArrayList<>();

    public CinemaRoom() {
        int counter = 0;
        for (int i = 1; i < TOTAL_ROWS + 1; i++) {
            for (int j = 1; j < TOTAL_COLUMNS + 1; j++) {
                allSeats.set(counter++, new Seat(i, j));
            }
        }
    }
}