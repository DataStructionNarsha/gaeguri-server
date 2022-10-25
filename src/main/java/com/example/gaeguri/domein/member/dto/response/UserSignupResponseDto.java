package com.example.gaeguri.domein.member.dto.response;

import com.example.gaeguri.domein.member.entity.MemberEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSignupResponseDto {
    @ApiModelProperty(example = "유저 고유 번호")
    private Long User_Id;
    @ApiModelProperty(example = "아이디")
    private String id;

    @Builder
    public UserSignupResponseDto(Long User_id, String id) {
        this.User_Id = User_id;
        this.id = id;
    }
}
