package com.example.gaeguri.domein.post.Entity;

import com.example.gaeguri.domein.member.entity.MemberEntity;
import com.example.gaeguri.global.Entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PostEntity extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_Id;
    private String title;
    private String body;
    private String deadline;
    private String expected_period;
    private String imege;
    private String purpose;
    private String age;
    private Boolean field;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private MemberEntity memberEntity;

    @Builder
     public PostEntity(Long post_Id, String title, String body, String deadline, String expected_period, String imege, String purpose, String age, Boolean field) {
        this.post_Id = post_Id;
        this.title = title;
        this.body = body;
        this.deadline = deadline;
        this.expected_period = expected_period;
        this.imege = imege;
        this.purpose = purpose;
        this.age = age;
        this.field = field;
    }
}