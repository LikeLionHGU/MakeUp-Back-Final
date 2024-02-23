package com.makeup.controller;

import com.makeup.controller.Response.ApiResponse;
import com.makeup.controller.Response.ExceptionResponse;
import com.makeup.exception.EmailAlreadyExistsException;
import com.makeup.exception.MemberNotFoundException;
import com.makeup.exception.PostNotFoundException;
import com.makeup.exception.ReservationNotFoundException;
import com.makeup.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController{

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public BaseResponse<?> handleUserEmailAlreadyExistsException(
            EmailAlreadyExistsException e) {
            String message = e.getMessage();
        return BaseResponse.error(message);
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public BaseResponse<?> handleMemberNotFoundException(MemberNotFoundException e) {
        String message = e.getMessage();
        return BaseResponse.error(message);
    }



    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<ApiResponse> handleReservationNotFoundException(ReservationNotFoundException e) {
        ApiResponse response =
                ExceptionResponse.builder()
                        .isSuccessful(false)
                        .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .message(e.getMessage())
                        .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}