package org.example.backend.impl;


import org.example.backend.Service.UserService;
import org.example.backend.Service.ChangePasswordService;
import org.example.backend.Dto.ChangePasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {

    private final UserService userService;

    @Autowired
    public ChangePasswordServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void changePassword(String userId, String newPassword) {
        ChangePasswordRequest request = new ChangePasswordRequest();
        request.setUserId(userId);
        request.setNewPassword(newPassword);

        userService.changePassword(request);
    }
}
