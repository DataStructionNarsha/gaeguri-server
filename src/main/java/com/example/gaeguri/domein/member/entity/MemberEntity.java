package com.example.gaeguri.domein.member.entity;

import com.example.gaeguri.domein.member.entity.type.Role;
import com.example.gaeguri.domein.post.type.Age;
import com.example.gaeguri.global.Entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "User")
@NoArgsConstructor
public class MemberEntity extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long User_Id;

    @Column(unique = true)
    private String id;

    private String password;

    private String info;

    private String profileimage;

    private Age age;

    private String refreshToken;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    @Builder
    public MemberEntity(String id, String password, String profileimage ,String info, Age age) {
        this.id = id;
        this.password = password;
        this.info = info;
        this.profileimage = profileimage;
        this.age = age;
    }

    public void update(String password, String profileimage, String info, Age age) {
        this.password = password;
        this.info = info;
        this.profileimage = profileimage;
        this.age = age;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}
