package CinemaRoomRestService.RestService.domain.entity;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
@Getter
public class CinemaRoom {
    private final int totalRows = 9;
    private final int totalColumns = 9;
    private final List<Seat> allSeats = Arrays.asList(new Seat[totalColumns * totalRows]);
    private final List<TokenOfSeat> activeTickets = new ArrayList<>();

    public CinemaRoom() {
        int counter = 0;
        for (int i = 1; i < totalRows + 1; i++) {
            for (int j = 1; j < totalColumns + 1; j++) {
                allSeats.set(counter++, new Seat(i, j));
            }
        }
    }

    public boolean isContainToken(String token) {
     // return   activeTickets.stream().anyMatch(element -> element.getToken().equals(token));


        for(TokenOfSeat tokenOfSeat : activeTickets){
            if (tokenOfSeat.equals(token)){
                return true;
            }
        }
        return false;
    }
}