package CinemaRoomRestService.RestService.service;

import CinemaRoomRestService.RestService.*;
import CinemaRoomRestService.RestService.api.exception.WrongPasswordException;
import CinemaRoomRestService.RestService.api.exception.SeatOutOfBoundsException;
import CinemaRoomRestService.RestService.domain.entity.CinemaRoom;
import CinemaRoomRestService.RestService.domain.entity.Seat;
import CinemaRoomRestService.RestService.domain.entity.Statistics;
import CinemaRoomRestService.RestService.domain.entity.TokenOfSeat;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class BookingService {

    @Autowired
    CinemaRoom cinemaRoom;

    public CinemaRoom getSeatInfo() {
        return cinemaRoom;
    }

    public TokenOfSeat bookingOfSeat(Seat seat) {
        TokenOfSeat tokenOfSeat = null;
        if (seat.getRow() > cinemaRoom.getTotalRows() || seat.getColumn() > cinemaRoom.getTotalColumns()
                || seat.getRow() < 1 || seat.getColumn() < 1) {
            throw new SeatOutOfBoundsException(ErrorMessage.OUT_OF_BOUNDS.toString());
        }
        for (Seat currentSeat : cinemaRoom.getAllSeats()) {
            if (seat.getRow() == currentSeat.getRow() && seat.getColumn() == currentSeat.getColumn()) {
                if (!currentSeat.isFree) {
                    throw new SeatOutOfBoundsException(ErrorMessage.NOT_AVAILABLE_TICKET.toString());
                }
                currentSeat.isFree = false;
                tokenOfSeat = new TokenOfSeat(currentSeat);
                cinemaRoom.getActiveTickets().add(tokenOfSeat);
            }
        }
        return tokenOfSeat;
    }

    public Seat returnOfSeat(TokenOfSeat reqToken) {
        Seat seat = null;
        if (cinemaRoom.isContainToken(reqToken.getToken())) {
            for (TokenOfSeat tokenOfSeat : cinemaRoom.getActiveTickets()) {
                if (tokenOfSeat.getToken().equals(reqToken.getToken())) {
                    seat = tokenOfSeat.getTicket();
                    seat.isFree = true;
                }
            }
        } else {
            throw new SeatOutOfBoundsException(ErrorMessage.WRONG_TOKEN.toString());
        }
        return seat;
    }

    public Statistics getStatistics(String password) {
        if (password != null && password.equals("super_secret")) {
            return new Statistics(cinemaRoom.getAllSeats());
        } else {
            throw new WrongPasswordException(ErrorMessage.WRONG_PASSWORD.toString());
        }
    }
}