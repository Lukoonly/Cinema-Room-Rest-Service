package CinemaRoomRestService.RestService.api.dto;

public class TokenOfSeatDTO {
    private String token;
    private SeatDTO ticket;

    public String getToken() {
        return token;
    }

    public SeatDTO getTicket() {
        return ticket;
    }

    public static class Builder {
        private TokenOfSeatDTO tokenOfSeatDTO;

        public Builder() {
            tokenOfSeatDTO = new TokenOfSeatDTO();
        }

        public Builder withToken(String token) {
            tokenOfSeatDTO.token = token;
            return this;
        }

        public Builder withTicket(SeatDTO ticket) {
            tokenOfSeatDTO.ticket = ticket;
            return this;
        }

        public TokenOfSeatDTO build() {
            return tokenOfSeatDTO;
        }
    }
}
