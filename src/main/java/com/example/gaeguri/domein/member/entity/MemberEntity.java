package com.example.gaeguri.domein.member.entity;

import com.example.gaeguri.domein.member.entity.type.Role;
import com.example.gaeguri.global.Entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MemberEntity extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long User_Id;

    @Column(unique = true)
    private String id;

    private String password;

    private String info;

    private String profileimage;

    private String age;

    private String refreshToken;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> position;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    @Builder
    public MemberEntity(String id, String password, String profileimage ,String info, String age, List<String> position, List<Role> roles) {
        this.id = id;
        this.password = password;
        this.info = info;
        this.profileimage = profileimage;
        this.position = position;
        this.age = age;
        this.roles = Collections.singletonList(Role.USER);
    }

    public void update(String password, String profileimage, String info, String age, List<String> position) {
        this.password = password;
        this.info = info;
        this.profileimage = profileimage;
        this.position = position;
        this.age = age;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}
