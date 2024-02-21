package com.makeup.controller.Form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MentoReservationForm {
    private Long memberId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate mentoDate;

}
