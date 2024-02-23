//package com.makeup.service;
//
//import com.makeup.controller.Form.AvailableDateForm;
//import com.makeup.domain.Member;
//import com.makeup.domain.Reservation;
//import com.makeup.dto.MenteeReservationDto;
//import com.makeup.repository.MemberRepository;
//import com.makeup.repository.MenteeReservationRepository;
//import com.makeup.repository.AvailableDateRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import com.makeup.exception.MemberNotFoundException;
//import com.makeup.exception.ReservationNotFoundException;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.makeup.domain.Reservation.toMenteeReservation;
//
//@Service
//@RequiredArgsConstructor
//public class ReservationService {
//
//    private final AvailableDateRepository availableDateRepository;
//    private final MemberRepository memberRepository;
//    private final MenteeReservationRepository menteeReservationRepository;
//
//    public Long addReservationDate(AvailableDateForm form) {
//        Member member =
//                memberRepository.findById(form.getMemberId()).orElseThrow(MemberNotFoundException::new);
//        Calendar calendar = availableDateRepository.save(Calendar.toMentoReservation(form, member));
//        return calendar.getMentoReservationId();
//    }
//
//    public List<CalendarDto> findAll(Long memberId) {
//        Member mento = memberRepository
//                .findMemberById(memberId)
//                .orElseThrow(MemberNotFoundException::new);;
//
//        List<Calendar> calendarList = availableDateRepository
//                .findAllByMember(mento);
//        //Controller로 dto로 변환해서 줘야 함
//
//
//        List<CalendarDto> calendarDtoList = new ArrayList<>();
//        for (Calendar calendar : calendarList){
//            calendarDtoList.add(CalendarDto.MentoFrom(calendar));
//
//        }
//        return calendarDtoList;
//    }
//
//    public void deleteReservation(Long mentoReservationId) {
//        availableDateRepository.deleteById(mentoReservationId);
//    }
//
//
//
//
//    public Long menteeReservation(MenteeReservationDto menteeReservationDto) {
//        Calendar calendar =
//                availableDateRepository.findById(menteeReservationDto.getMentoReservationId()).orElseThrow(ReservationNotFoundException::new);
//
//        Long mentoReservationId =
//                menteeReservationDto.getMentoReservationId();
//
//        Member mento =
//                calendar.getMember();
//
//        LocalDateTime dateTime =
//                menteeReservationDto.getReservationDateTime();
//
//        Member mentee =
//                memberRepository.findById(menteeReservationDto.getMemberId()).orElseThrow(MemberNotFoundException::new);
//
//        Reservation menteeReservation = menteeReservationRepository.save(toMenteeReservation(dateTime, mento, mentee, mentoReservationId));
//        return menteeReservation.getReservationId();
//    }
//
//    public List<MenteeReservationDto> findFinalReservationTime(Long mentoReservationId) {
//
//        List<Reservation> menteeReservationList = menteeReservationRepository
//                .findBymentoReservationId(mentoReservationId);
//        //Controller로 dto로 변환해서 줘야 함
//
//
//        List<MenteeReservationDto> menteeReservationDtoList = new ArrayList<>();
//        for (Reservation menteeReservation : menteeReservationList){
//            menteeReservationDtoList.add(MenteeReservationDto.finalReservationFrom(menteeReservation));
//
//        }
//        return menteeReservationDtoList;
//    }
//}
