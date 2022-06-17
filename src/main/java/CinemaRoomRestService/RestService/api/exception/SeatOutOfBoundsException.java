package CinemaRoomRestService.RestService.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SeatOutOfBoundsException extends RuntimeException {
    private final String message;

    public SeatOutOfBoundsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
