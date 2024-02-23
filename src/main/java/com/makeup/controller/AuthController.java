package com.makeup.controller;

import com.makeup.controller.Form.SignInForm;
import com.makeup.controller.Form.SignUpForm;
import com.makeup.controller.Response.ApiResponse;
import com.makeup.controller.Response.MemberIdResponse;
import com.makeup.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.makeup.service.MemberService;
import com.makeup.dto.MemberDto;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final MemberService memberService;

    @PostMapping("/sign-up")
    public BaseResponse<?> signUp(@RequestBody SignUpForm form) {
        Long memberId = memberService.addMember(MemberDto.from(form));
        return BaseResponse.success(memberId);
    }

    @GetMapping("/sign-up/validation")
    public BaseResponse<?> validateId(@RequestParam String email) {
        memberService.validateEmail(email);
        return BaseResponse.ok();
    }

    @PostMapping ("/sign-in")
    public BaseResponse<?> signIn(@RequestBody SignInForm form) {
        Long memberId = memberService.signInMember(MemberDto.from(form));
        return BaseResponse.successMemberId(memberId);
    }
}
