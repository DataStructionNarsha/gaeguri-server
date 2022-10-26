package com.example.gaeguri.domein.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponseDto {
    private Long User_Id;
    private String id;
    private String info;
    private String profileimage;
    private String age;
    private String refreshToken;
}