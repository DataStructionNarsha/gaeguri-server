package com.example.gaeguri.domein.post.service;

import com.example.gaeguri.domein.member.entity.MemberEntity;
import com.example.gaeguri.domein.member.repository.MemberRepository;
import com.example.gaeguri.domein.post.dto.repsonse.PostResponseDto;
import com.example.gaeguri.domein.post.dto.request.PostRequestDto;
import com.example.gaeguri.domein.post.entity.PostEntity;
import com.example.gaeguri.domein.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
        m.setPassword(" ");
        return postRepository.findPostEntityByPostId(postId);
    }

//    @Transactional
//    public
}
