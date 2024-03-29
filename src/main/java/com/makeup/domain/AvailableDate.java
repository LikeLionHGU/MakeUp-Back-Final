package com.makeup.domain;

import com.makeup.dto.AvailableDateDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter // 이 어노테이션 추가
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AvailableDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availableDateId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate availableDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static AvailableDate toAvailableDate(LocalDate localDate, Member member) {
        return AvailableDate.builder()
                .availableDate(localDate)
                .member(member)
                .build();
    }
}
