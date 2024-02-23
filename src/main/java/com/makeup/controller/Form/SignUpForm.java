package com.makeup.controller.Form;

import com.makeup.domain.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpForm {

    private String email;

    private String username;

    private String userNickname;

    private String password;

    private String birthYear;

    private String gender;

    private String phoneNumber;

}
