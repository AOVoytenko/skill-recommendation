package ru.itis.skill.recommendation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.skill.recommendation.db.entity.User;
import ru.itis.skill.recommendation.db.repository.UserRepository;
import ru.itis.skill.recommendation.dto.SignUpForm;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public Long saveUser(SignUpForm user) {
        User userFromDB = userRepository.findByEmail(user.getEmail());

        if (userFromDB != null) {
            throw new IllegalArgumentException("Email already registered");
        }

        String password = passwordEncoder.encode(user.getPassword());
        return userRepository.save(User.builder()
                        .email(user.getEmail())
                        .password(password)
                        .age(user.getAge())
                        .dateOfBirth(user.getDateOfBirth())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .build())
                .getId();
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}