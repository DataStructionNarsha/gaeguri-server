package com.example.gaeguri.domein.member.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponseDto {
    @ApiModelProperty(example = "회원 고유 번호")
    private Long User_Id;
    @ApiModelProperty(example = "엑세스 토큰")
    private String access_token;
    @ApiModelProperty(example = "리프레쉬 토큰")
    private String refresh_token;
}
