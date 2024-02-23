package com.makeup.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter // 이 어노테이션 추가
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private LocalDateTime reservedDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentee_id")
    private Member mentee;

//    public static Reservation toMenteeReservation(LocalDateTime date, Member mento, Member mentee, Long mentoReservationId) {
//        return Reservation.builder()
//                .reservedDateTime(date)
//                .post(mento)
//                .mentee(mentee)
//                .mentorReservationId(mentoReservationId)
//                .build();
//    }
}

