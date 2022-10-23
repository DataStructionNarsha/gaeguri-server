package com.example.gaeguri.domein.post.dto.repsonse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Long post_Id;
    private String title;
    private String body;
    private String deadline;
    private String expected_period;
    private String imege;
    private String purpose;
    private String age;
    private Boolean field;
}
