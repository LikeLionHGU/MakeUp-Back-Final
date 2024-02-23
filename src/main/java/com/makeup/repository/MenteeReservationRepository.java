/*package com.makeup.repository;

import com.makeup.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenteeReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select m from Reservation m  where m.mentoReservationId = :mentoReservationId")
    List<Reservation> findBymentoReservationId(Long mentoReservationId);
}
*/