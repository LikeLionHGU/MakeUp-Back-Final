package com.makeup.dto;

import com.makeup.controller.Form.AvailableDateForm;
import com.makeup.domain.AvailableDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvailableDateDto {
    private Long dateId;
    private Long memberId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate availableDates;

    public static AvailableDateDto from(AvailableDate date) {
        return AvailableDateDto.builder()
                .availableDates(date.getAvailableDate())
                .memberId(date.getMember().getMemberId())
                .build();
    }
}
