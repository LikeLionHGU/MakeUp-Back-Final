package com.makeup.domain;
import com.makeup.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String email;
    private String password;
    private String username;
    private String userNickname;
    private String birthYear;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String phoneNumber;

    public static Member toMember(MemberDto memberDto) {
        return Member.builder()
                .email(memberDto.getEmail())
                .username(memberDto.getUsername())
                .userNickname(memberDto.getUserNickname())
                .password(memberDto.getPassword())
                .birthYear(memberDto.getBirthYear())
                .gender(memberDto.getGender())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }
}

