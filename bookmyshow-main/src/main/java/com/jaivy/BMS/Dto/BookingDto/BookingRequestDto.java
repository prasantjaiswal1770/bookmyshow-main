package com.jaivy.BMS.Dto.BookingDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDto {

    private Long userId;

    private Long showId;

    @JsonProperty("seatIds")
    private List<Long> seatIds;
}