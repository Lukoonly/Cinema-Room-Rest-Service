package CinemaRoomRestService.RestService.domain.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Statistics {
    private int currentIncome;
    private int availableSeats;
    private int purchasedTickets;

    @Autowired
    public Statistics(int numberOfAvailableSeats) {
        this.availableSeats = numberOfAvailableSeats;
    }

    public Seat addTicket(Seat seat) {
        seat.isFree = false;
        addCurrentIncome(seat.getPrice());
        addNumberOfPurchasedTickets();
        subNumberOfAvailableSeats();
        return seat;
    }

    public Seat subTicket(Seat seat) {
        seat.isFree = true;
        subCurrentIncome(seat.getPrice());
        subNumberOfPurchasedTickets();
        addNumberOfAvailableSeats();
        return seat;
    }

    public void addCurrentIncome(int currentIncome) {
        this.currentIncome += currentIncome;
    }

    public void subCurrentIncome(int currentIncome) {
        this.currentIncome -= currentIncome;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void addNumberOfAvailableSeats() {
        this.availableSeats++;
    }

    public void subNumberOfAvailableSeats() {
        this.availableSeats--;
    }

    public int getPurchasedTickets() {
        return purchasedTickets;
    }

    public void addNumberOfPurchasedTickets() {
        this.purchasedTickets++;
    }

    public void subNumberOfPurchasedTickets() {
        this.purchasedTickets--;
    }
}