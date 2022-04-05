package CinemaRoomRestService.RestService.domain.entity;

import java.util.UUID;

public class TokenOfSeat {
    private String token;
    private Seat ticket;

    public TokenOfSeat() {
    }

    public TokenOfSeat(Seat seat) {
        this.ticket = seat;
        this.token = String.valueOf(UUID.randomUUID());
    }

    public String getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }
}