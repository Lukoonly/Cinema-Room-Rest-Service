package CinemaRoomRestService.RestService.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class WrongPasswordException extends RuntimeException {
    private String message;

    public WrongPasswordException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
