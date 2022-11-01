package com.example.gaeguri.domein.post.controller;

import com.example.gaeguri.domein.post.dto.repsonse.PostResponseDto;
import com.example.gaeguri.domein.post.dto.request.PostRequestDto;
import com.example.gaeguri.domein.post.entity.PostEntity;
import com.example.gaeguri.domein.post.service.PostService;
import com.example.gaeguri.global.Response.SingleResult;
import com.example.gaeguri.global.Response.service.ResponseService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/post")
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

    @ApiOperation(value =  "정보 조회", notes = "정보 조회 API")
    @GetMapping("/info/{id}")
    public SingleResult<PostEntity> info(@PathVariable Long id){
        PostEntity post = postService.Info(id);
        return responseService.getSingleResult(post);
    }

    @GetMapping("/infos")
    public SingleResult<Page<PostEntity>> infoAll(@PageableDefault(size=20)Pageable pageable){
        Page<PostEntity> entity = postService.InfoAll(pageable);
        return responseService.getSingleResult(entity);
    }

    @GetMapping("/search")
    public SingleResult<Page<PostEntity>> TitleSearch(@RequestParam String keyword, @RequestParam String category , Pageable pageable){
        if(Objects.equals(category, "제목")) {
            return responseService.getSingleResult(postService.TitleSearch(keyword, pageable));
        } else if (Objects.equals(category, "전체")) {
           return responseService.getSingleResult(postService.Search(keyword, pageable));
        }
//        else {
//
//        }
        return null;
    }

}
