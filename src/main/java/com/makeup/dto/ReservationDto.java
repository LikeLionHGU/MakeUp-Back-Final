package com.makeup.dto;

import com.makeup.controller.Form.SignUpForm;
import com.makeup.domain.MentoReservation;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long mentoReservationId;

    private LocalDate mentoDate;

    public static ReservationDto MentoFrom(MentoReservation mentoReservation) {
        return ReservationDto.builder()
                .mentoReservationId(mentoReservation.getMentoReservationId())
                .mentoDate(mentoReservation.getMentoDate())
                .build();
    }
}