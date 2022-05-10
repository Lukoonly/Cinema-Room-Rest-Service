package CinemaRoomRestService.RestService.service;

import CinemaRoomRestService.RestService.*;
import CinemaRoomRestService.RestService.api.exception.WrongPasswordException;
import CinemaRoomRestService.RestService.api.exception.SeatOutOfBoundsException;
import CinemaRoomRestService.RestService.api.exception.WrongTokenException;
import CinemaRoomRestService.RestService.domain.entity.CinemaRoom;
import CinemaRoomRestService.RestService.domain.entity.Seat;
import CinemaRoomRestService.RestService.domain.entity.Statistics;
import CinemaRoomRestService.RestService.domain.entity.TokenOfSeat;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
@NoArgsConstructor
public class BookingService {

    @Autowired
    CinemaRoom cinemaRoom;

    public CinemaRoom getSeatInfo() {
        return cinemaRoom;
    }

    private Seat getSeatAfterReturning(TokenOfSeat tokenOfSeat) {
        Seat seat = tokenOfSeat.getTicket();
        seat.isOccupied = false;
        return seat;
    }

    private TokenOfSeat getSeatAfterBooking(Seat seat) {
        seat.isOccupied = true;
        return new TokenOfSeat(seat);
    }

    private boolean isSeatExists(Seat seat) {
        return seat.getRow() < cinemaRoom.getTotalRows() || seat.getColumn() < cinemaRoom.getTotalColumns()
                || seat.getRow() > 1 || seat.getColumn() > 1;
    }

    public TokenOfSeat bookingOfSeat(Seat seat) {
        if (!isSeatExists(seat)) throw new SeatOutOfBoundsException(ErrorMessage.OUT_OF_BOUNDS.toString());

        Predicate<Seat> isValidRowOfSeat = currentSeat -> seat.getRow() == currentSeat.getRow();
        Predicate<Seat> isValidColumnOfSeat = currentSeat -> seat.getColumn() == currentSeat.getColumn();
        Predicate<Seat> isOccupiedSeat = currentSeat -> currentSeat.isOccupied;

        TokenOfSeat tokenOfSeat = cinemaRoom.getAllSeats().stream()
                .filter(isValidRowOfSeat.and(isValidColumnOfSeat).and(isOccupiedSeat.negate()))
                .findAny()
                .map(this::getSeatAfterBooking)
                .orElseThrow(() -> new SeatOutOfBoundsException(ErrorMessage.NOT_AVAILABLE_TICKET.toString()));
        cinemaRoom.getActiveTickets().add(tokenOfSeat);
        return tokenOfSeat;
    }

    public Seat returnOfSeat(TokenOfSeat clientTicket) {
        return cinemaRoom.getActiveTickets().stream()
                .filter((token) -> clientTicket.getToken().equals(token.getToken()))
                .findAny()
                .map(this::getSeatAfterReturning)
                .orElseThrow(() -> new WrongTokenException(ErrorMessage.WRONG_TOKEN.toString()));
    }

    public Statistics getStatistics(String password) {
        if (password != null && password.equals("super_secret")) {
            return Statistics.getInstance(cinemaRoom.getAllSeats());
        } else {
            throw new WrongPasswordException(ErrorMessage.WRONG_PASSWORD.toString());
        }
    }
}