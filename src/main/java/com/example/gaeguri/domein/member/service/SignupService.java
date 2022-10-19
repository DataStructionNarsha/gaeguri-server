package com.example.gaeguri.domein.member.service;

import com.example.gaeguri.domein.auth.dto.request.TokenRequestDto;
import com.example.gaeguri.domein.auth.dto.response.TokenResponseDto;
import com.example.gaeguri.domein.auth.jwt.JwtTokenProvider;
import com.example.gaeguri.domein.member.dto.request.UserLoginRequestDto;
import com.example.gaeguri.domein.member.dto.request.UserSignupRequestDto;
import com.example.gaeguri.domein.member.dto.response.UserLoginResponseDto;
import com.example.gaeguri.domein.member.dto.response.UserSignupResponseDto;
import com.example.gaeguri.domein.member.entity.MemberEntity;
import com.example.gaeguri.domein.member.repository.MemberRepository;
import com.example.gaeguri.global.exception.InvalidRefreshTokenException;
import com.example.gaeguri.global.exception.LoginFailureException;
import com.example.gaeguri.global.exception.MemberEmailAlreadyExistsException;
import com.example.gaeguri.global.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignupService {
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    //회원가입 builder패턴
    @Transactional
    public UserSignupResponseDto signup(UserSignupRequestDto requestDto){
        MemberEntity member = memberRepository.save(
                MemberEntity.builder()
                        .id(requestDto.getId())
                        .password(passwordEncoder.encode(requestDto.getPassword()))
                        .info(requestDto.getInfo())
                        .profileimage(requestDto.getProfileimage())
                        .age(requestDto.getAge())
                        .position(requestDto.getPosition())
                        .build());
        return UserSignupResponseDto.builder()
                .User_id(member.getUser_Id())
                .id(member.getId())
                .build();
    }

    @Transactional
    public TokenResponseDto reIssue(TokenRequestDto requestDto) {
        if (!jwtTokenProvider.validateTokenExpiration(requestDto.getRefresh_Token()))
            throw new InvalidRefreshTokenException();

        MemberEntity member = findMemberByToken(requestDto);

        if (!member.getRefreshToken().equals(requestDto.getRefresh_Token()))
            throw new InvalidRefreshTokenException();

        String accessToken = jwtTokenProvider.createToken(member.getId());
        String refreshToken = jwtTokenProvider.createRefreshToken();
        member.updateRefreshToken(refreshToken);
        return new TokenResponseDto(accessToken, refreshToken);
    }

    @Transactional
    public UserLoginResponseDto loginMember(UserLoginRequestDto requestDto) {
        MemberEntity member = memberRepository.findById(requestDto.getId()).orElseThrow(LoginFailureException::new);
        if (!passwordEncoder.matches(requestDto.getPassword(), member.getPassword()))
            throw new LoginFailureException();
        member.updateRefreshToken(jwtTokenProvider.createRefreshToken());
        return new UserLoginResponseDto(member.getUser_Id(), jwtTokenProvider.createToken(requestDto.getId()), member.getRefreshToken());
    }

    public MemberEntity findMemberByToken(TokenRequestDto requestDto) {
        Authentication auth = jwtTokenProvider.getAuthentication(requestDto.getAccess_Token());
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();
        return memberRepository.findById(username).orElseThrow(MemberNotFoundException::new);
    }
}