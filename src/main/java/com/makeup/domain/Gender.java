package com.makeup.domain;


import com.makeup.exception.NoMatchedGenderFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Gender {
    MALE("남성"), FEMALE("여성");

    private final String kor;

    public static Gender findByKor(String source) {
        return Arrays.stream(values())
                .filter(gender -> gender.kor.equals(source))
                .findAny()
                .orElseThrow(NoMatchedGenderFoundException::new);
    }
}
