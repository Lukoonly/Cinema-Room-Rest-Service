package CinemaRoomRestService.RestService.api.dto;

public class SeatDTO {
    private int row;
    private int column;
    private int price;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    public static class Builder {
        private SeatDTO seatDTO;

        public Builder() {
            this.seatDTO = new SeatDTO();
        }

        public Builder withRow(int row) {
            seatDTO.row = row;
            return this;
        }

        public Builder withColumn(int column) {
            seatDTO.column = column;
            return this;
        }

        public Builder withPrice(int price) {
            seatDTO.price = price;
            return this;
        }

        public SeatDTO build() {
            return seatDTO;
        }
    }
}
