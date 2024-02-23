package com.makeup.controller.Form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class AvailableDateForm {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private List<LocalDate> availableDates;

}
