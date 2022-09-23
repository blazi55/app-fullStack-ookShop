package com.ookshop.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userOokShop")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto registerUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }

    @PutMapping
    public UserDto updatePassword(@RequestBody UpdateUserDto updateUserDto) {
        return userService.updatePasswordUser(updateUserDto);
    }
}
