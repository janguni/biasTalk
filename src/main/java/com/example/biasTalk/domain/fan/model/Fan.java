package com.example.biasTalk.domain.fan.model;

import com.example.biasTalk.domain.auth.model.AuthProvider;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fans")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Fan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uniqueId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, length = 20)
    private String status; // 예: ACTIVE, INACTIVE, BLACKLISTED

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthProvider authProvider;

    public Fan(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
        this.status = status != null ? status : "ACTIVE";
    }

    public Fan(String nickname, String email, AuthProvider authProvider) {
        this.nickname = nickname;
        this.email = email;
        this.status = status != null ? status : "ACTIVE";
        this.authProvider = authProvider;
    }
}
