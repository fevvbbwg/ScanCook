package org.example.backend.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String userID;     // 로그인용 아이디
    private String username; // 이름
    private String password;
    private String email;
    private String phone;
    private String birthdate;
}
