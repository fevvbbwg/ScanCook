package org.example.backend.impl;

import org.example.backend.Repository.UserRepository;
import org.example.backend.Service.UserService;
import org.example.backend.Dto.ChangePasswordRequest;
import org.example.backend.Dto.UserDTO;
import org.example.backend.Dto.LoginDTO;
import org.example.backend.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkUserIDExists(String userID) {
        return userRepository.existsByUserID(userID);
    }

    @Override
    public void register(UserDTO userDTO) {
        if (userRepository.existsByUserID(userDTO.getUserID())) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }

        User user = new User();
        user.setUserID(userDTO.getUserID());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setBirthdate(userDTO.getBirthdate());

        userRepository.save(user);
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean isUserIDAvailable(String userID) {
        return !userRepository.existsByUserID(userID);
    }

    @Override
    public String login(LoginDTO loginDTO) {
        User user = userRepository.findByUserIDAndPassword(
                loginDTO.getUserID(), loginDTO.getPassword());

        if (user == null) {
            throw new RuntimeException("아이디 또는 비밀번호가 일치하지 않습니다.");
        }

        return "dummy-token";  // 실제 JWT 토큰으로 대체 필요
    }

    @Override
    public String findUserId(String username, String phone) {
        User user = userRepository.findByUsernameAndPhone(username, phone)
                .orElseThrow(() -> new RuntimeException("일치하는 사용자 정보가 없습니다."));
        return user.getUserID();
    }

    // 비밀번호 변경 메서드
    @Override
    public boolean changePassword(ChangePasswordRequest changePasswordRequest) {
        Optional<User> optionalUser = userRepository.findByUserID(changePasswordRequest.getUserId());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("사용자를 찾을 수 없습니다.");
        }

        User user = optionalUser.get();

        // 새 비밀번호로 업데이트
        user.setPassword(changePasswordRequest.getNewPassword());
        userRepository.save(user);
        return true;
    }

}
