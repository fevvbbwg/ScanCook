package org.example.backend.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordRequest {
    private String userId;
    private String newPassword;

    // getter, setter 자동 생성
}
