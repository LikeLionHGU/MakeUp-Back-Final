package com.makeup.controller.Response;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MentoReservationListResponse {
    private Long mentoReservationId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate mentoDate;
}
