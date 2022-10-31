package com.example.gaeguri.domein.post.repository;

import com.example.gaeguri.domein.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    PostEntity findPostEntityByPostId(Long postId);
    List<PostEntity> findPostEntityByTitle(String title);
}
