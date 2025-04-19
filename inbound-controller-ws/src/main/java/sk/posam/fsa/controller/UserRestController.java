package sk.posam.fsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sk.posam.fsa.User;
import sk.posam.fsa.dto.UserDto;
import sk.posam.fsa.mapper.UserMapper;
import sk.posam.fsa.ports.UserRepository;
import sk.posam.fsa.security.CurrentUserDetailService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUserDetailService currentUserDetailService;

    public UserRestController(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder,
            CurrentUserDetailService currentUserDetailService
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUserDetailService = currentUserDetailService;
    }

    // GET /api/users/me - vracia info o prihlásenom používateľovi
    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser() {
        String email = currentUserDetailService.getUserEmail();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Používateľ sa nenašiel"));
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    // POST /api/users - registrácia nového používateľa
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email už existuje");
        }

        User user = userMapper.toDomain(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // zašifruj heslo
        userRepository.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
