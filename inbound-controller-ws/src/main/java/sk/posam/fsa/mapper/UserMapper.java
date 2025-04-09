package sk.posam.fsa.mapper;

import org.springframework.stereotype.Component;
import sk.posam.fsa.User;
import sk.posam.fsa.UserRole;
import sk.posam.fsa.dto.UserDto;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole().name());
        return dto;
    }
    public User toDomain(UserDto dto) {
        return new User(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getPassword(),
                UserRole.valueOf(dto.getRole())
        );
    }

}
