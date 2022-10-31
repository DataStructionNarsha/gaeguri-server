package com.example.gaeguri.domein.member.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequestDto {
    @ApiModelProperty(example = "아이디")
    private String id;
    @ApiModelProperty(example = "비밀번호")
    private String password;
    @ApiModelProperty(example = "자기소개")
    private String info;
    @ApiModelProperty(example = "프로필 사진")
    private String profileimage;
    @ApiModelProperty(example = "[" +
            "분야" +
            "]")
    private List<String> position;
    @ApiModelProperty(example = "나이")
    private String age;
}
