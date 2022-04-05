package CinemaRoomRestService.RestService.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class WrongPasswordException extends RuntimeException {
    private static final long serialVersionUID = -7806029002430564887L;

    private String message;

    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
