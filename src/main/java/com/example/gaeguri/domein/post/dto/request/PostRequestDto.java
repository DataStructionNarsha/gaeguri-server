package com.example.gaeguri.domein.post.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {
    private Long post_Id;
    private String title;
    private String body;
    private String deadline;
    private String expected_period;
    private String imege;
    private String purpose;
    private String age;
}
