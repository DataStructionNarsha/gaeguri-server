package com.example.gaeguri.domein.member.repository;

import com.example.gaeguri.domein.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findById(String id);

    MemberEntity findMemberById(String id);
}
