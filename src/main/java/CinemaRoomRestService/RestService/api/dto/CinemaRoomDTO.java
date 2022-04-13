package CinemaRoomRestService.RestService.api.dto;

import CinemaRoomRestService.RestService.domain.entity.Seat;

import java.util.List;

public class CinemaRoomDTO {
    private List<Seat> allSeats;

    public List<Seat> getAllSeats() {
        return allSeats;
    }

    public static class Builder {
        private CinemaRoomDTO cinemaRoomDTO;

        public Builder() {
            cinemaRoomDTO = new CinemaRoomDTO();
        }

        public Builder withAllSeat(List<Seat> seat) {
            cinemaRoomDTO.allSeats = seat;
            return this;
        }

        public CinemaRoomDTO build() {
            return cinemaRoomDTO;
        }
    }
}