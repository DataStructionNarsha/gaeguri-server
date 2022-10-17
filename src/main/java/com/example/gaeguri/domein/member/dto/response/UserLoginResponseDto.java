package com.example.gaeguri.domein.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponseDto {
    private String access_token;
    private String refresh_token;
}
