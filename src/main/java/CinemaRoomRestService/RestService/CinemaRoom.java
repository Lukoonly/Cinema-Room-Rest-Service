package CinemaRoomRestService.RestService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CinemaRoom {
    private final int total_rows = 9;
    private final int total_columns = 9;
    private Seat[] available_seats = new Seat[total_columns * total_rows];
    private CopyOnWriteArrayList<TokenOfSeat> activeTickets = new CopyOnWriteArrayList<>();
    Stat stat = new Stat(getAvailable_seats().length);

    public CinemaRoom() {
        int counter = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                available_seats[counter++] = new Seat(i, j);
            }
        }
    }

    public boolean isContainToken(String token) {
        for (TokenOfSeat curToken : activeTickets) {
            if (curToken.token.equals(token))
                return true;
        }
        return false;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public Seat[] getAvailable_seats() {
        return available_seats;
    }

    @JsonIgnore
    public CopyOnWriteArrayList<TokenOfSeat> getActiveTickets() {
        return activeTickets;
    }
}