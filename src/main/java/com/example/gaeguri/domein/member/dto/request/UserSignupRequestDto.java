package com.example.gaeguri.domein.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequestDto {
    private String id;
    private String password;
    private String info;
    private String profileimage;
    private List<String> position;
    private String age;
}
