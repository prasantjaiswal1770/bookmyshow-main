package com.jaivy.BMS.Dto.BookingDto;

import com.jaivy.BMS.Dto.SeatDto.SeatDTO;
import com.jaivy.BMS.Enum.BookingStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BookingResponseDTO {

    private Long bookingId;

    private String userName;

    private String movieTitle;

    private String theaterName;

    private String screenName;

    private List<String> seatNumbers;
    private List<SeatDTO> seats;
    private double totalPrice;

    private BookingStatus bookingStatus;

    private LocalDateTime bookedAt;
}