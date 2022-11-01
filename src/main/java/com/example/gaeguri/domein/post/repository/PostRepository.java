package com.example.gaeguri.domein.post.repository;

import com.example.gaeguri.domein.post.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    PostEntity findPostEntityByPostId(Long postId);
    Page<PostEntity> findPostEntityByTitleOrderByPostIdDesc(String keyword, Pageable pageable);
//    Page<PostEntity> findPostEntityByOrderByPostIdDesc(String keyword, Pageable pageable);
    @Query(value = "SELECT b FROM PostEntity b WHERE b.title LIKE %:keyword% OR b.body LIKE %:keyword% ORDER BY b.postId desc")
    Page<PostEntity> findAllSearch(String keyword, Pageable pageable);
    Page<PostEntity> findAllByOrderByPostIdDesc(Pageable pageable);

}