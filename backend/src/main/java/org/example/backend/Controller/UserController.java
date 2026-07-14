package org.example.backend.Controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.Repository.UserRepository;
import org.example.backend.Service.ChangePasswordService;
import org.example.backend.Service.UserService;
import org.example.backend.Dto.ChangePasswordRequest;
import org.example.backend.Dto.LoginDTO;
import org.example.backend.Dto.UserDTO;
import org.example.backend.Dto.UserRequestDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final ChangePasswordService changePasswordService;
    private final UserService userService; // final로 선언하여 생성자를 통해 주입 받도록


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        try {
            userService.register(userDTO);
            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "회원가입 성공"
            ));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of(
                            "success", false,
                            "message", "이미 존재하는 이메일 또는 아이디입니다."
                    ));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "success", false,
                            "message", "서버 오류가 발생했습니다."
                    ));
        }
    }

    @PostMapping("/find-id")
    public ResponseEntity<String> findUserId(@RequestBody Map<String, String> request) {
        try {
            String username = request.get("username");
            String phone = request.get("phone");

            String userId = userService.findUserId(username, phone);

            if (userId != null) {
                return ResponseEntity.ok(userId);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("아이디를 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다.");
        }
    }

    @PostMapping("/verify-user")
    public ResponseEntity<Map<String, Object>> verifyUser(@RequestBody UserRequestDTO userRequestDTO) {
        // 로그 추가
        System.out.println("Received userID: " + userRequestDTO.getUserID());
        System.out.println("Received username: " + userRequestDTO.getUsername());
        System.out.println("Received email: " + userRequestDTO.getEmail());

        // 여기서 userRequest를 기반으로 DB 조회 후 결과 반환
        // ...

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);  // 실제 응답값 확인 후 수정
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        String token = userService.login(loginDTO);
        return ResponseEntity.ok().body(Map.of("token", token));
    }

    @PostMapping("/check-userID")
    public ResponseEntity<?> checkUserID(@RequestBody Map<String, String> request) {
        String userID = request.get("userID");
        boolean isAvailable = userService.isUserIDAvailable(userID);
        return ResponseEntity.ok(Map.of("isAvailable", isAvailable));
    }
    // 비밀번호 변경 (비밀번호 찾기 이후 재설정용)
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request) {
        try {
            // oldPassword 제거된 버전
            changePasswordService.changePassword(
                    request.getUserId(),
                    request.getNewPassword()
            );
            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "비밀번호가 성공적으로 변경되었습니다."
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "비밀번호 변경 실패: " + e.getMessage()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "success", false,
                    "message", "서버 오류가 발생했습니다."
            ));
        }
    }

}
