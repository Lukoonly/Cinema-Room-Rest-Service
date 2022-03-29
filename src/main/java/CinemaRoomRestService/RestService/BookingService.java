package CinemaRoomRestService.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookingService {

    @Autowired
    CinemaRoom cinemaRoom;

    public BookingService() {
    }

    public CinemaRoom getSeatInfo() {
        return cinemaRoom;
    }

    public ResponseEntity<?> bookingOfSeat(Seat reqSeat) {
        ResponseEntity<?> responseEntity = null;
        if (reqSeat.getRow() > cinemaRoom.getTotal_rows() || reqSeat.getColumn() > cinemaRoom.getTotal_columns()
                || reqSeat.getRow() < 1 || reqSeat.getColumn() < 1) {
            responseEntity = ResponseEntity.badRequest()
                    .body(Map.of(ErrorMessage.ERROR, ErrorMessage.OUT_OF_BOUNDS));
        }
        for (Seat seat : cinemaRoom.getAvailable_seats()) {
            if (reqSeat.getRow() == seat.getRow() && reqSeat.getColumn() == seat.getColumn()) {
                if (!seat.isSeatFree) {
                    return ResponseEntity.badRequest()
                            .body(Map.of(ErrorMessage.ERROR, ErrorMessage.NOT_AVAILABLE_TICKET));
                }
                TokenOfSeat tokenOfSeat = new TokenOfSeat(cinemaRoom.stat.addTicket(seat));
                cinemaRoom.getActiveTickets().add(tokenOfSeat);
                responseEntity = ResponseEntity.ok(tokenOfSeat);
            }
        }
        return responseEntity;
    }

    public ResponseEntity<?> returnOfSeat(TokenOfSeat reqToken) {
        ResponseEntity<?> responseEntity = null;
        if (!cinemaRoom.isContainToken(reqToken.token)) {
            responseEntity = ResponseEntity.badRequest()
                    .body(Map.of(ErrorMessage.ERROR, ErrorMessage.WRONG_TOKEN));
        } else {
            for (TokenOfSeat tokenOfSeat : cinemaRoom.getActiveTickets()) {
                if (tokenOfSeat.token.equals(reqToken.token)) {
                    Seat seat = tokenOfSeat.getTicket();
                    cinemaRoom.stat.subTicket(seat);
                    cinemaRoom.getActiveTickets().remove(tokenOfSeat);
                    responseEntity = ResponseEntity.ok()
                            .body(Map.of(ErrorMessage.RETURNED_TICKET, seat));
                }
            }
        }
        return responseEntity;
    }

    public ResponseEntity<?> getStatistics(String password) {
        if (password != null && password.equals("super_secret")) {
            return ResponseEntity.ok()
                    .body(cinemaRoom.stat);
        } else {
            return new ResponseEntity(Map.of(ErrorMessage.ERROR, ErrorMessage.WRONG_PASSWORD),
                    HttpStatus.UNAUTHORIZED);
        }
    }
}