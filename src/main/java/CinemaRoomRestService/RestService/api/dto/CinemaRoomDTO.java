package CinemaRoomRestService.RestService.api.dto;

import CinemaRoomRestService.RestService.domain.entity.Seat;

public class CinemaRoomDTO {
    private Seat[] allSeats;

    public Seat[] getAllSeats() {
        return allSeats;
    }

    public void setAllSeats(Seat[] allSeats) {
        this.allSeats = allSeats;
    }
}