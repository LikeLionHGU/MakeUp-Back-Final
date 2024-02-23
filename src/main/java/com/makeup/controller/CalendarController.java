//
//package com.makeup.controller;
//
//import com.makeup.controller.Form.AvailableDateForm;
//import com.makeup.controller.Response.ApiResponse;
//import com.makeup.controller.Response.MentoDateIdResponse;
//import com.makeup.service.CalendarService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/posts/calender")
//@RequiredArgsConstructor
//public class CalendarController {
//
//    CalendarService calendarService;
//
//    @PostMapping("/{memberId}")
//    public ResponseEntity<ApiResponse> mentoReservation(@PathVariable Long memberId, @RequestBody AvailableDateForm availableDateForm) {
//        Long mentoReservationId = calendarService.addReservationDate(memberId, availableDateForm);
//        ApiResponse response = new MentoDateIdResponse(mentoReservationId);
//        return ResponseEntity.ok(response);
//    }
//}
