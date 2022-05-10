package CinemaRoomRestService.RestService.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WrongTokenException extends RuntimeException {
    private final String message;

    public WrongTokenException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
