package CinemaRoomRestService.RestService.api.mapper;

import CinemaRoomRestService.RestService.domain.entity.CinemaRoom;
import CinemaRoomRestService.RestService.domain.entity.Seat;
import CinemaRoomRestService.RestService.domain.entity.TokenOfSeat;
import CinemaRoomRestService.RestService.api.dto.CinemaRoomDTO;
import CinemaRoomRestService.RestService.api.dto.SeatDTO;
import CinemaRoomRestService.RestService.api.dto.TokenOfSeatDTO;

public class Mapper {

    public CinemaRoomDTO toCinemaRoomDTO(CinemaRoom cinemaRoom) {
        CinemaRoomDTO cinemaRoomDTO = new CinemaRoomDTO();
        cinemaRoomDTO.setAllSeats(cinemaRoom.getAllSeats());
        return cinemaRoomDTO;
    }

    public TokenOfSeatDTO toTokenOfSeatDTO(TokenOfSeat tokenOfSeat) {
        SeatDTO seatDTO = toSeatDTO(tokenOfSeat.getTicket());
        TokenOfSeatDTO tokenOfSeatDTO = new TokenOfSeatDTO();
        tokenOfSeatDTO.setToken(tokenOfSeat.getToken());
        tokenOfSeatDTO.setTicket(seatDTO);
        return tokenOfSeatDTO;
    }

    public SeatDTO toSeatDTO(Seat seat) {
        SeatDTO seatDTO = new SeatDTO();
        seatDTO.setColumn(seat.getColumn());
        seatDTO.setRow(seat.getRow());
        seatDTO.setPrice(seat.getPrice());
        return seatDTO;
    }
}
