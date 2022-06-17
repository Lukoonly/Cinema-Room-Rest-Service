package CinemaRoomRestService.RestService.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class TokenOfSeat {
    private String token;
    private Seat ticket;

    public TokenOfSeat(Seat seat) {
        this.ticket = seat;
        this.token = UUID.randomUUID().toString();
    }
}