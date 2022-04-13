package CinemaRoomRestService.RestService.api.dto;

public class StatisticsDTO {
    private int currentIncome;
    private int availableSeats;
    private int purchasedTickets;

    public static class Builder {
        private StatisticsDTO statisticsDTO;

        public Builder() {
            statisticsDTO = new StatisticsDTO();
        }

        public Builder withCurrentIncome(int currentIncome) {
            statisticsDTO.currentIncome = currentIncome;
            return this;
        }

        public Builder withAvailableSeats(int availableSeats) {
            statisticsDTO.availableSeats = availableSeats;
            return this;
        }

        public Builder withPurchasedTickets(int purchasedTickets) {
            statisticsDTO.purchasedTickets = purchasedTickets;
            return this;
        }

        public StatisticsDTO build() {
            return statisticsDTO;
        }
    }
}
