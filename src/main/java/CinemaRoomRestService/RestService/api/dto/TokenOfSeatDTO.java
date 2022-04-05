package CinemaRoomRestService.RestService.api.dto;

public class TokenOfSeatDTO {
    private String token;
    private SeatDTO ticket;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SeatDTO getTicket() {
        return ticket;
    }

    public void setTicket(SeatDTO ticket) {
        this.ticket = ticket;
    }
}
