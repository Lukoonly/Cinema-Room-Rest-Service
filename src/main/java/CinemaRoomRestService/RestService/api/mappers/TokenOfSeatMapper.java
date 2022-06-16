package CinemaRoomRestService.RestService.api.mappers;

import CinemaRoomRestService.RestService.api.dto.TokenOfSeatDTO;
import CinemaRoomRestService.RestService.domain.entity.TokenOfSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenOfSeatMapper {

    @Autowired
    SeatMapper seatMapper;

    public TokenOfSeatDTO toTokenOfSeatDTO(TokenOfSeat tokenOfSeat) {
        return TokenOfSeatDTO.builder()
                .token(tokenOfSeat.getToken())
                .ticket(seatMapper.toSeatDTO(tokenOfSeat.getTicket()))
                .build();
    }
}