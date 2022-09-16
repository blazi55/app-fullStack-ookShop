package com.ookshop.application.user;

import com.ookshop.application.security.config.CustomUserDetails;
import com.ookshop.application.tables.User;
import com.ookshop.application.tables.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto createUser(CreateUserDto createUserDto) {
        final User user = create(createUserDto);
        final UserAccount userAccount = UserAccount.builder()
                .user(user)
                .amountBook(0L)
                .build();
        user.setUserAccount(userAccount);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDto updatePasswordUser(UpdateUserDto updateUserDto) {
        if (updateUserDto.getEmail() == null) {
            throw new IllegalArgumentException("Id shouldn't be null. Id= " + updateUserDto.getEmail());
        }
        final User user = userRepository.findByEmail(updateUserDto.getEmail());

        if (user.getEmail() == null) {
            throw new IllegalArgumentException("Id shouldn't be null. Email= " + user.getEmail());
        }

        user.setPassword(new BCryptPasswordEncoder().encode(updateUserDto.getPassword()));
        this.userRepository.save(user);
        return this.userMapper.toDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userEmail);
        if (user == null) {
            throw new UsernameNotFoundException("Email doesn't exist");
        }

        return new CustomUserDetails(user);
    }

    private User create(CreateUserDto createUserDto) {
        return User.builder()
                .fullName(createUserDto.getFullName())
                .email(createUserDto.getEmail())
                .password(new BCryptPasswordEncoder().encode(createUserDto.getPassword()))
                .creationDate(LocalDateTime.now())
                .build();
    }
}
