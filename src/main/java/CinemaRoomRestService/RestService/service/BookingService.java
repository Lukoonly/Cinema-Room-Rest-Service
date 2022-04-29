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

    private Seat getSeatAfterBooking(TokenOfSeat tokenOfSeat) {
        Seat seat = tokenOfSeat.getTicket();
        seat.isOccupied = false;
        return seat;
    }

    private TokenOfSeat getSeatAfterReturning(Seat seat) {
        seat.isOccupied = true;
        return new TokenOfSeat(seat);
    }

    public TokenOfSeat bookingOfSeat(Seat seat) {
        if (seat.getRow() > cinemaRoom.getTotalRows() || seat.getColumn() > cinemaRoom.getTotalColumns()
                || seat.getRow() < 1 || seat.getColumn() < 1) {
            throw new SeatOutOfBoundsException(ErrorMessage.OUT_OF_BOUNDS.toString());
        }
        TokenOfSeat tokenOfSeat = cinemaRoom.getAllSeats().stream()
                .filter(currentSeat -> seat.getRow() == currentSeat.getRow()
                        && seat.getColumn() == currentSeat.getColumn())
                .filter(currentSeat -> !currentSeat.isOccupied)
                .findFirst()
                .map(this::getSeatAfterReturning)
                .orElseThrow(() -> new SeatOutOfBoundsException(ErrorMessage.NOT_AVAILABLE_TICKET.toString()));
        cinemaRoom.getActiveTickets().add(tokenOfSeat);
        return tokenOfSeat;
    }

    public Seat returnOfSeat(TokenOfSeat clientTicket) {
        return cinemaRoom.getActiveTickets().stream()
                .filter((token) -> clientTicket.getToken().equals(token.getToken()))
                .findFirst()
                .map(this::getSeatAfterBooking)
                .orElseThrow(() -> new SeatOutOfBoundsException(ErrorMessage.WRONG_TOKEN.toString()));
    }

    public Statistics getStatistics(String password) {
        if (password != null && password.equals("super_secret")) {
            return Statistics.getInstance(cinemaRoom.getAllSeats());
        } else {
            throw new WrongPasswordException(ErrorMessage.WRONG_PASSWORD.toString());
        }
    }
}