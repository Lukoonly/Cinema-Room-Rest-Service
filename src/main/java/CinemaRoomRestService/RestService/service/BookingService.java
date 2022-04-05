package CinemaRoomRestService.RestService.service;

import CinemaRoomRestService.RestService.*;
import CinemaRoomRestService.RestService.api.exception.WrongPasswordException;
import CinemaRoomRestService.RestService.api.exception.BadRequestException;
import CinemaRoomRestService.RestService.domain.entity.CinemaRoom;
import CinemaRoomRestService.RestService.domain.entity.Seat;
import CinemaRoomRestService.RestService.domain.entity.Statistics;
import CinemaRoomRestService.RestService.domain.entity.TokenOfSeat;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    CinemaRoom cinemaRoom;

    public BookingService() {
    }

    public CinemaRoom getSeatInfo() {
        return cinemaRoom;
    }

    public TokenOfSeat bookingOfSeat(@NotNull Seat reqSeat) {
        TokenOfSeat tokenOfSeat = null;
        if (reqSeat.getRow() > cinemaRoom.getTotalRows() || reqSeat.getColumn() > cinemaRoom.getTotalColumns()
                || reqSeat.getRow() < 1 || reqSeat.getColumn() < 1) {
            throw new BadRequestException(ErrorMessage.OUT_OF_BOUNDS.toString());
        }
        for (Seat seat : cinemaRoom.getAllSeats()) {
            if (reqSeat.getRow() == seat.getRow() && reqSeat.getColumn() == seat.getColumn()) {
                if (!seat.isFree) {
                    throw new BadRequestException(ErrorMessage.NOT_AVAILABLE_TICKET.toString());
                }
                tokenOfSeat = new TokenOfSeat(cinemaRoom.stat.addTicket(seat));
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
                    cinemaRoom.stat.subTicket(seat);
                    cinemaRoom.getActiveTickets().remove(tokenOfSeat);
                }
            }
        } else {
            throw new BadRequestException(ErrorMessage.WRONG_TOKEN.toString());
        }
        return seat;
    }

    public Statistics getStatistics(String password) {
        if (password != null && password.equals("super_secret")) {
            return cinemaRoom.stat;
        } else {
            throw new WrongPasswordException(ErrorMessage.WRONG_PASSWORD.toString());
        }
    }
}