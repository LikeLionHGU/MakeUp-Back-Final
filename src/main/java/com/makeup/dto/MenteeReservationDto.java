//package com.makeup.dto;
//
//import com.makeup.controller.Form.MenteeReservationForm;
//import com.makeup.domain.Member;
//import com.makeup.domain.Reservation;
//import lombok.*;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class MenteeReservationDto {
//    private Long menteeReservationId;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
//    private LocalDateTime reservationDateTime;
//    private Long memberId;
//    private Long mentoReservationId;
//
//    public static MenteeReservationDto menteeFrom(MenteeReservationForm menteeReservationForm) {
//        return MenteeReservationDto.builder()
//                .memberId(menteeReservationForm.getMemberId())
//                .mentoReservationId(menteeReservationForm.getMentoReservationId())
//                .reservationDateTime(menteeReservationForm.getReservationDateTime())
//                .build();
//    }
//
//    public static MenteeReservationDto finalReservationFrom(Reservation menteeReservation) {
//        Member mentee = menteeReservation.getMentee();
//
//        return MenteeReservationDto.builder()
//                .menteeReservationId(menteeReservation.getReservationId())
//                .reservationDateTime(menteeReservation.getReservationDateTime())
//                .memberId(mentee.getMemberId())
//                .mentoReservationId(menteeReservation.getMentoReservationId())
//                .build();
//    }
//}
