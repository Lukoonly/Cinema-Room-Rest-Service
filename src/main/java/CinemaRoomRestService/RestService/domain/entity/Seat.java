package CinemaRoomRestService.RestService.domain.entity;

public class Seat {
    private final int ROW;
    private final int COLUMN;
    private final int PRICE;
    public boolean isFree;

    public Seat(int row, int column) {
        this.ROW = row;
        this.COLUMN = column;
        this.PRICE = row <= 4 ? 10 : 8;
        this.isFree = true;
    }

    public int getRow() {
        return ROW;
    }

    public int getColumn() {
        return COLUMN;
    }

    public int getPrice() {
        return PRICE;
    }
}