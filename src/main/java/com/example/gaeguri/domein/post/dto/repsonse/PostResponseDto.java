package com.example.gaeguri.domein.post.dto.repsonse;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    @ApiModelProperty(example = "게시판 고유 번호")
    private Long post_Id;
}
