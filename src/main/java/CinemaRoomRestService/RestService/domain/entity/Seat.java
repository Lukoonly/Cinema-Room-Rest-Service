package CinemaRoomRestService.RestService.domain.entity;

import lombok.Getter;

public class Seat {

    @Getter
    private final int row;
    @Getter
    private final int column;
    @Getter
    private final int price;
    public boolean isOccupied;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
        this.isOccupied = false;
    }
}