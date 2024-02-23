//package com.makeup.controller;
//
//import com.makeup.controller.Form.MenteeReservationForm;
//import com.makeup.controller.Response.ApiResponse;
//import com.makeup.controller.Response.MentoDateIdResponse;
//import com.makeup.dto.MenteeReservationDto;
//import com.makeup.service.ReservationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/reservation")
//@RequiredArgsConstructor
//public class ReservationController {
//    private final ReservationService reservationService;
//
//
//
//    @GetMapping("/view/mento/{memberId}")
//    public List<CalendarDto> mentoReservationView(@PathVariable Long memberId){
//        List<CalendarDto> mentoReservationList = reservationService.findAll(memberId);
//        return mentoReservationList;
//    }
//
//    @DeleteMapping("/mento/{mentoReservationId}")
//    public ResponseEntity<ApiResponse> deleteMentoReservation(@PathVariable Long mentoReservationId) {
//        reservationService.deleteReservation(mentoReservationId);
//        ApiResponse response = new MentoDateIdResponse(mentoReservationId);
//        return ResponseEntity.ok(response);
//    }
//
//
//
//    @PostMapping("/mentee")
//    public ResponseEntity<ApiResponse> menteeReservation(@RequestBody MenteeReservationForm form) {
//        Long reservationId = reservationService.menteeReservation(MenteeReservationDto.menteeFrom(form));
//        ApiResponse response = new MentoDateIdResponse(reservationId);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/view/mentee/{mentoReservationId}")
//    public List<MenteeReservationDto> viewFinalReservation(@PathVariable Long mentoReservationId){
//        List<MenteeReservationDto> menteeReservationDtoList = reservationService.findFinalReservationTime(mentoReservationId);
//        return menteeReservationDtoList;
//    }
//
//}
