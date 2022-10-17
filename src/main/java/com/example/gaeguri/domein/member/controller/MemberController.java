package com.example.gaeguri.domein.member.controller;

import com.example.gaeguri.domein.member.dto.request.UserSignupRequestDto;
import com.example.gaeguri.domein.member.dto.response.UserSignupResponseDto;
import com.example.gaeguri.global.service.ResponseService;
import com.example.gaeguri.domein.member.service.SignupService;
import com.example.gaeguri.global.Result.SingleResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class MemberController {
    private final SignupService signupService;
    private final ResponseService responseService;

    @PostMapping("/signup")
    public SingleResult<UserSignupResponseDto> Signup(@RequestBody UserSignupRequestDto requestDto){
        UserSignupResponseDto responseDto = signupService.signup(requestDto);
        return responseService.getSingleResult(responseDto);
    }
}
