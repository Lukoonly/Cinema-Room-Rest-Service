package CinemaRoomRestService.RestService;

import java.util.UUID;

public class TokenOfSeat {
    String token;
    Seat ticket;

    public TokenOfSeat() {
    }

    public TokenOfSeat(Seat seat) {
        this.ticket = seat;
        this.token = String.valueOf(UUID.randomUUID());
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }
}
