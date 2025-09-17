package com.sih.surakshasetu.surakshasetu.controller;

import com.sih.surakshasetu.surakshasetu.dto.UserDTO;
import com.sih.surakshasetu.surakshasetu.entity.User;
import com.sih.surakshasetu.surakshasetu.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        User currentUser = userService.getUserByUsername(currentUserName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(currentUser.getUsername());
        userDTO.setEmail(currentUser.getEmail());
        userDTO.setRegisteredAt(currentUser.getRegisteredAt());
        userDTO.setLastActiveAt(currentUser.getLastActiveAt());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Optional<User> userIs = userService.getUserById(id);
        if(userIs.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        else
            return new ResponseEntity<>(userIs.get(), HttpStatus.OK);
        //To return UserDTO during optimization for security purpose
    }
    @PostMapping("/users/{id}/update")
    public ResponseEntity<UserDTO> updateUserInfo(@PathVariable long id, @Valid @RequestBody UserDTO userDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        Optional<UserDTO> updatedUserOpt = userService.updateUserInfo(id, userDTO);

        if (updatedUserOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id);
        }

        return ResponseEntity.ok(updatedUserOpt.get());
    }


}
