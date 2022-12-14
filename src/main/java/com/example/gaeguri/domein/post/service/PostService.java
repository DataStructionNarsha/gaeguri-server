package com.example.gaeguri.domein.post.service;

import com.example.gaeguri.domein.member.entity.MemberEntity;
import com.example.gaeguri.domein.member.repository.MemberRepository;
import com.example.gaeguri.domein.post.dto.repsonse.PostResponseDto;
import com.example.gaeguri.domein.post.dto.request.PostRequestDto;
import com.example.gaeguri.domein.post.entity.PostEntity;
import com.example.gaeguri.domein.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public PostResponseDto create(String user_id, PostRequestDto requestDto){
        MemberEntity member = memberRepository.findMemberById(user_id);
        PostEntity post = postRepository.save(
                PostEntity.builder()
                        .title(requestDto.getTitle())
                        .body(requestDto.getBody())
                        .deadline(requestDto.getDeadline())
                        .expected_period(requestDto.getExpected_period())
                        .imege(requestDto.getImege())
                        .purpose(requestDto.getPurpose())
                        .age(requestDto.getAge())
                        .field(requestDto.isField())
                        .memberEntity(member)
                        .build());

        return PostResponseDto.builder()
                .postId(post.getPostId())
                .build();
    }
    @Transactional
    public PostEntity Info(Long postId){
        PostEntity pe = postRepository.findPostEntityByPostId(postId);
        MemberEntity m = new MemberEntity();
        return postRepository.findPostEntityByPostId(postId);
    }
    //전체 불러오기
    @Transactional
    public Page<PostEntity> InfoAll(Pageable pageable) {
        return postRepository.findAllByOrderByPostIdDesc(pageable);
    }
    //제목 검색
    @Transactional
    public Page<PostEntity> TitleSearch(String keyword, Pageable pageable){
        return postRepository.findPostEntityByTitleOrderByPostIdDesc(keyword, pageable);
    }
    //전체 검색
    @Transactional
    public Page<PostEntity> Search(String keyword, Pageable pageable){
        return postRepository.findAllSearch(keyword, pageable);
    }
//    @Transactional
//    public Page<PostEntity> TitleSearch(String keyword, Pageable pageable){
//        return postRepository.findPostEntityByTitleOrderByPostIdDesc(keyword, pageable);
//    }
}
