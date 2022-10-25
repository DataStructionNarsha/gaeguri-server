package com.example.gaeguri.domein.post.controller;

import com.example.gaeguri.domein.post.dto.repsonse.PostResponseDto;
import com.example.gaeguri.domein.post.dto.request.PostRequestDto;
import com.example.gaeguri.domein.post.service.PostService;
import com.example.gaeguri.global.Response.SingleResult;
import com.example.gaeguri.global.Response.service.ResponseService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final ResponseService responseService;

    @ApiOperation(value = "글 등록", notes = "글 등록 API")
    @PostMapping("/create")
    public SingleResult<PostResponseDto> create(@RequestBody PostRequestDto requestDto, Authentication authentication){
        PostResponseDto responseDto = postService.create(authentication.getName(), requestDto);
        return responseService.getSingleResult(responseDto);
    }


}
