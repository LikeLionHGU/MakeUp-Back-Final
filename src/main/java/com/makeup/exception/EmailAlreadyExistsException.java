package com.makeup.exception;

public class EmailAlreadyExistsException extends RuntimeException {

  private static final String MESSAGE = "이미 존재하는 이메일입니다.";

  public EmailAlreadyExistsException() {
    super(MESSAGE);
  }
}
