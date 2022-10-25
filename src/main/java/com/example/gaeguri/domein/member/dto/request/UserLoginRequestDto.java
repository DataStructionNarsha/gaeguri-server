package com.example.gaeguri.domein.member.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestDto {
    @ApiModelProperty(example = "아이디")
    private String id;
    @ApiModelProperty(example = "비밀번호")
    private String password;
}
