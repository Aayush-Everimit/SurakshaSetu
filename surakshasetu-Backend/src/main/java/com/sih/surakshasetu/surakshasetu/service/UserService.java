package com.sih.surakshasetu.surakshasetu.service;

import com.sih.surakshasetu.surakshasetu.dto.UserDTO;
import com.sih.surakshasetu.surakshasetu.entity.User;
import com.sih.surakshasetu.surakshasetu.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }


    public Optional<User> getUserById(long id)
    {
        return userRepository.findById(id);
    }
    public Optional<UserDTO> updateUserInfo(long id, UserDTO updatedUserDTO) {
        User user = userRepository.findById(id).orElse(null);
        assert user != null;
        user.setLocation(updatedUserDTO.getLocation());
        user.setPassword(updatedUserDTO.getPassword());
        user.setLastActiveAt(updatedUserDTO.getLastActiveAt());
        user.setEmail(updatedUserDTO.getEmail());
        userRepository.save(user);
        return Optional.of(new UserDTO());
    }

}
