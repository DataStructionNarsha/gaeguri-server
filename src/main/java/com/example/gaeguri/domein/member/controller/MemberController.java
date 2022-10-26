package com.example.gaeguri.domein.member.controller;

import com.example.gaeguri.domein.auth.dto.request.TokenRequestDto;
import com.example.gaeguri.domein.auth.dto.response.TokenResponseDto;
import com.example.gaeguri.domein.member.dto.request.UserLoginRequestDto;
import com.example.gaeguri.domein.member.dto.request.UserSignupRequestDto;
import com.example.gaeguri.domein.member.dto.response.UserInfoResponseDto;
import com.example.gaeguri.domein.member.dto.response.UserLoginResponseDto;
import com.example.gaeguri.domein.member.dto.response.UserSignupResponseDto;
import com.example.gaeguri.domein.member.entity.MemberEntity;
import com.example.gaeguri.domein.member.service.SignupService;
import com.example.gaeguri.global.Response.SingleResult;
import com.example.gaeguri.global.Response.service.ResponseService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class MemberController {
    private final SignupService signupService;
    private final ResponseService responseService;

    @ApiOperation(value = "회원 등록", notes = "회원 등록 API")
    @PostMapping("/signup")
    public SingleResult<UserSignupResponseDto> Signup(@RequestBody UserSignupRequestDto requestDto){
        UserSignupResponseDto responseDto = signupService.signup(requestDto);
        return responseService.getSingleResult(responseDto);
    }

    @ApiOperation(value = "로그인", notes = "로그인 API")
    @PostMapping("/login")
    public SingleResult<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto requestDto) {
        UserLoginResponseDto responseDto = signupService.loginMember(requestDto);
        return responseService.getSingleResult(responseDto);
    }

    @ApiOperation(value = "토큰 재발급", notes = "토큰 재발급 API")
    @PostMapping("/reissue")
    public SingleResult<TokenResponseDto> reIssue(@RequestBody TokenRequestDto tokenRequestDto) {
        TokenResponseDto responseDto = signupService.reIssue(tokenRequestDto);
        return responseService.getSingleResult(responseDto);
    }

    @ApiOperation(value = "중복 아이디 체크", notes = "중복 아이디 체크 API")
    @GetMapping("/{id}")
    public void checkId(@PathVariable String id) {
        signupService.validateDuplicated(id);
    }

    @ApiOperation(value = "회원 정보 찾기", notes = "토큰으로 회원 정보 찾는 API")
    @GetMapping("/info")
    public SingleResult<UserInfoResponseDto> getMyInfo(Authentication authentication) {
        UserInfoResponseDto UserInfo = signupService.findById(authentication.getName());
        return responseService.getSingleResult(UserInfo);
    }
}