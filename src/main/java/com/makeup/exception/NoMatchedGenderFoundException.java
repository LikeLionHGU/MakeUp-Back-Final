package com.makeup.exception;

public class NoMatchedGenderFoundException extends RuntimeException {

    public NoMatchedGenderFoundException() {
        super("유효한 성별이 아닙니다.");
    }
}
