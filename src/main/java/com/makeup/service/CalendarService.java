package com.makeup.service;

import com.makeup.controller.Form.AvailableDateForm;
import com.makeup.domain.AvailableDate;
import com.makeup.domain.Member;
import com.makeup.dto.AvailableDateDto;
import com.makeup.exception.MemberNotFoundException;
import com.makeup.repository.AvailableDateRepository;
import com.makeup.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final AvailableDateRepository availableDateRepository;
    private final MemberRepository memberRepository;

    public void addReservationDate(Long memberId, AvailableDateForm form) {
        Member member =
                memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);

        List<AvailableDate> dates = form.getAvailableDates().stream()
                .map(localDate -> AvailableDate.toAvailableDate(localDate, member))
                .toList();

        availableDateRepository.saveAll(dates);
    }

    public List<AvailableDateDto> getAvailableDatesOf(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        List<AvailableDate> dates = availableDateRepository.findAllByMember(member);
        return dates.stream().map(AvailableDateDto::from).toList();
    }
}
