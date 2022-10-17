package com.example.gaeguri.domein.member.service;

import com.example.gaeguri.domein.member.dto.request.UserSignupRequestDto;
import com.example.gaeguri.domein.member.dto.response.UserSignupResponseDto;
import com.example.gaeguri.domein.member.entity.MemberEntity;
import com.example.gaeguri.domein.member.repository.MemberRepository;
import com.example.gaeguri.global.exception.MemberEmailAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignupService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입 builder패턴
    @Transactional
    public UserSignupResponseDto signup(UserSignupRequestDto requestDto){
        validateDuplicated(requestDto.getId());
        MemberEntity member = memberRepository.save(
                MemberEntity.builder()
                        .id(requestDto.getId())
                        .password(passwordEncoder.encode(requestDto.getPassword()))
                        .info(requestDto.getInfo())
                        .profileimage(requestDto.getProfileimage())
                        .age(requestDto.getAge())
                        .build());
        return UserSignupResponseDto.builder()
                .User_id(member.getUser_Id())
                .id(member.getId())
                .build();
    }

    //아이디 중복 체크
    public void validateDuplicated(String id) {
        if (memberRepository.findById(id).isPresent())
            throw new MemberEmailAlreadyExistsException();
    }
}
