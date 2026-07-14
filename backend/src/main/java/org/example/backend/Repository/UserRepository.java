package org.example.backend.Repository;

import org.example.backend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // userID (로그인 아이디)로 유저 존재 여부 확인
    boolean existsByUserID(String userID);

    // userID와 password로 로그인 시도
    User findByUserIDAndPassword(String userID, String password);

    // userID로 사용자 정보 조회
    Optional<User> findByUserID(String userID);

    // username과 phone으로 유저 정보 조회
    Optional<User> findByUsernameAndPhone(String username, String phone);

    // userID, username, email 기준 존재 여부 확인
    boolean existsByUserIDAndUsernameAndEmail(String userID, String username, String email);

}
