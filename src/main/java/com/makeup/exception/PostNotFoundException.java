package com.makeup.exception;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException() {
        super("해당하는 피드를 찾을 수 없습니다");
    }
}
