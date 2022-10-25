package com.example.gaeguri.domein.post.dto.request;

import com.example.gaeguri.domein.member.entity.MemberEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {
    @ApiModelProperty(example = "제목")
    private String title;
    @ApiModelProperty(example = "내용")
    private String body;
    @ApiModelProperty(example = "마감 날짜")
    private LocalDate deadline;
    @ApiModelProperty(example = "예상 기간")
    private String expected_period;
    @ApiModelProperty(example = "이미지")
    private String imege;
    @ApiModelProperty(example = "목적")
    private String purpose;
    @ApiModelProperty(example = "나이")
    private String age;
    @ApiModelProperty(example = "글 마감 확인")
    private boolean field;
}
