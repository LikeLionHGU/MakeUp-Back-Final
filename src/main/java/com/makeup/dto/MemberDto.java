package com.makeup.dto;

import com.makeup.controller.Form.EditMemberForm;
import com.makeup.controller.Form.SignInForm;
import com.makeup.controller.Form.SignUpForm;
import com.makeup.domain.Gender;
import com.makeup.domain.Member;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long memberId;

    private String email;
    private String username;
    private String userNickname;
    private String password;
    private String birthYear;
    private Gender gender;
    private String phoneNumber;

    // Form에서
    public static MemberDto from(SignUpForm signUpForm) {
        return MemberDto.builder()
                .email(signUpForm.getEmail())
                .username(signUpForm.getUsername())
                .userNickname(signUpForm.getUserNickname())
                .password(signUpForm.getPassword())
                .birthYear(signUpForm.getBirthYear())
                .gender(Gender.findByKor(signUpForm.getGender()))
                .phoneNumber(signUpForm.getPhoneNumber())
                .build();
    }

    public static MemberDto from(SignInForm signInForm) {
        return MemberDto.builder()
                .email(signInForm.getEmail())
                .password(signInForm.getPassword())
                .build();
    }

    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .memberId(member.getMemberId())
                .email(member.getEmail())
                .username(member.getUsername())
                .userNickname(member.getUserNickname())
                .password(member.getPassword())
                .gender(member.getGender())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }

//    public static MemberDto from(EditMemberForm editMemberForm) {
//        return MemberDto.builder()
//                .username(editMemberForm.getUsername())
//                .birthYear(editMemberForm.getBirthYear())
//                .gender(editMemberForm.getGender())
//                .build();
//    }
}
