package org.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String userID;  // 로그인용 아이디이자 PK

    @Column(nullable = false)
    private String username;  // 사용자 이름 (실명)

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)  // 생일은 선택적일 수 있습니다.
    private String birthdate;  // 날짜 타입으로 변경

    @Column(nullable = true)  // 전화번호는 선택적일 수 있습니다.
    private String phone;  // 전화번호
}
