package CinemaRoomRestService.RestService;

import org.springframework.beans.factory.annotation.Autowired;

public class Stat {
    private int current_income;
    private int number_of_available_seats;
    private int number_of_purchased_tickets;

    @Autowired
    public Stat(int number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public Stat() {
    }

    public Seat addTicket(Seat seat) {
        seat.isSeatFree = false;
        addCurrent_income(seat.getPrice());
        addNumber_of_purchased_tickets();
        subNumber_of_available_seats();
        return seat;
    }

    public Seat subTicket(Seat seat) {
        seat.isSeatFree = true;
        subCurrent_income(seat.getPrice());
        subNumber_of_purchased_tickets();
        addNumber_of_available_seats();
        return seat;
    }

    public int getCurrent_income() {
        return current_income;
    }

    public void addCurrent_income(int current_income) {
        this.current_income += current_income;
    }

    public void subCurrent_income(int current_income) {
        this.current_income -= current_income;
    }

    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public void addNumber_of_available_seats() {
        this.number_of_available_seats++;
    }

    public void subNumber_of_available_seats() {
        this.number_of_available_seats--;
    }

    public int getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }

    public void addNumber_of_purchased_tickets() {
        this.number_of_purchased_tickets++;
    }

    public void subNumber_of_purchased_tickets() {
        this.number_of_purchased_tickets--;
    }

    public void setNumber_of_available_seats(int number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }
}