package org.example.backend.Service;

import org.example.backend.Dto.ChangePasswordRequest;
import org.example.backend.Dto.LoginDTO;
import org.example.backend.Dto.UserDTO;
import org.example.backend.Entity.User;

public interface UserService {

    void register(UserDTO userDTO);  // 회원가입

    User registerUser(User user);  // 사용자 등록

    String login(LoginDTO loginDTO);  // 로그인

    boolean isUserIDAvailable(String userID);  // 아이디 사용 가능 여부

    boolean checkUserIDExists(String userID);  // 아이디 존재 여부

    String findUserId(String username, String phone);  // 아이디 찾기

    boolean changePassword(ChangePasswordRequest userDTO);  // 비밀번호 변경
}
