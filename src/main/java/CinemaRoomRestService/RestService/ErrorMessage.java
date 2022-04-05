package CinemaRoomRestService.RestService;

import java.util.Locale;

public enum ErrorMessage {
    OUT_OF_BOUNDS("The number of a row or a column is out of bounds!"),
    NOT_AVAILABLE_TICKET("The ticket has been already purchased!"),
    WRONG_PASSWORD("The password is wrong!"),
    WRONG_TOKEN("Wrong token!");

    final String error;

    ErrorMessage(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return this.error.toLowerCase(Locale.ROOT);
    }
}