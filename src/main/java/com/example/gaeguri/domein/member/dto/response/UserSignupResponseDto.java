package com.example.gaeguri.domein.member.dto.response;

import com.example.gaeguri.domein.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSignupResponseDto {
    private Long User_Id;
    private String id;

    @Builder
    public UserSignupResponseDto(Long User_id, String id) {
        this.User_Id = User_id;
        this.id = id;
    }
}
