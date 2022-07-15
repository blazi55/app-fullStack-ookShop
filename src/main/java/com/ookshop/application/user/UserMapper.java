package com.ookshop.application.user;

import com.ookshop.application.tables.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(user.getPassword())
                .creationDate(user.getCreationDate())
                .build();
    }

    public User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .fullName(userDto.getFullName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .creationDate(userDto.getCreationDate())
                .build();
    }
}
