package sk.posam.fsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sk.posam.fsa.User;
import sk.posam.fsa.dto.UserDto;
import sk.posam.fsa.mapper.UserMapper;
import sk.posam.fsa.ports.UserRepository;
import sk.posam.fsa.security.JwtConverter;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final JwtConverter jwtConverter;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserRestController(
            JwtConverter jwtConverter,
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder
    ) {
        this.jwtConverter = jwtConverter;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    // GET /api/users/me - vyžaduje JWT token
    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser(@AuthenticationPrincipal Jwt jwt) {
        String userId = jwtConverter.getUserId(jwt);
        User user = userRepository.read(Long.parseLong(userId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    // POST /api/users - verejne dostupný endpoint na registráciu
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already used");
        }

        User user = userMapper.toDomain(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // zakóduj heslo
        userRepository.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}