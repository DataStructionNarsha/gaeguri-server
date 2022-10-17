package com.example.gaeguri.domein.member.dto.request;

import com.example.gaeguri.domein.post.type.Age;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequestDto {
    private String id;
    private String password;
    private String info;
    private String profileimage;
    private Age age;
}
