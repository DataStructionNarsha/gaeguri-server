package com.example.gaeguri.domein.member.controller;

import com.example.gaeguri.domein.auth.dto.request.TokenRequestDto;
import com.example.gaeguri.domein.auth.dto.response.TokenResponseDto;
import com.example.gaeguri.domein.member.dto.request.UserLoginRequestDto;
import com.example.gaeguri.domein.member.dto.request.UserSignupRequestDto;
import com.example.gaeguri.domein.member.dto.response.UserLoginResponseDto;
import com.example.gaeguri.domein.member.dto.response.UserSignupResponseDto;
import com.example.gaeguri.domein.member.entity.MemberEntity;
import com.example.gaeguri.domein.member.repository.MemberRepository;
import com.example.gaeguri.domein.member.service.SignupService;
import com.example.gaeguri.global.Response.SingleResult;
import com.example.gaeguri.global.Response.service.ResponseService;
import com.example.gaeguri.global.exception.MemberEmailAlreadyExistsException;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final SignupService signupService;
    private final ResponseService responseService;

    @PostMapping("/signup")
    public SingleResult<UserSignupResponseDto> Signup(@RequestBody UserSignupRequestDto requestDto){
        UserSignupResponseDto responseDto = signupService.signup(requestDto);
        return responseService.getSingleResult(responseDto);
    }

    @ApiOperation(value = "로컬 로그인", notes = "로컬을 통해 로그인을 진행한다.")
    @PostMapping("/login")
    public SingleResult<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto requestDto) {
        UserLoginResponseDto responseDto = signupService.loginMember(requestDto);
        return responseService.getSingleResult(responseDto);
    }

    @ApiOperation(value = "토큰 재발급", notes = "Refresh Token을 통해 토큰을 재발급받는다.")
    @PostMapping("/reissue")
    public SingleResult<TokenResponseDto> reIssue(@RequestBody TokenRequestDto tokenRequestDto) {
        TokenResponseDto responseDto = signupService.reIssue(tokenRequestDto);
        return responseService.getSingleResult(responseDto);
    }

    @GetMapping("/{id}")
    public void checkId(@PathVariable String id) {
        signupService.validateDuplicated(id);
    }
    @GetMapping("/info")
    public SingleResult<MemberEntity> getMyInfo(Authentication authentication) {
        MemberEntity UserInfo = signupService.findById(authentication.getName());
        return responseService.getSingleResult(UserInfo);
    }
}
