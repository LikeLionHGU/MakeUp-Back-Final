package com.makeup.repository;

import com.makeup.domain.Member;
import com.makeup.domain.MenteeReservation;
import com.makeup.domain.MentoReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenteeReservationRepository extends JpaRepository<MenteeReservation, Long> {

    @Query("select m from MenteeReservation m  where m.mentoReservationId = :mentoReservationId")
    List<MenteeReservation> findBymentoReservationId(Long mentoReservationId);
}
