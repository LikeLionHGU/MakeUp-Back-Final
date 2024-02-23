package com.makeup.repository;

import com.makeup.domain.AvailableDate;
import com.makeup.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    @Query("select m from AvailableDate m  where m.member = :member")
    List<AvailableDate> findAllByMember(Member member);

}
